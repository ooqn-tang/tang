package com.ooqn;

import java.security.Principal;
import java.sql.SQLException;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.realm.RealmBase;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@EnableJpaRepositories
@SpringBootApplication
@ServletComponentScan
public class TangApplication {


	/**
	 * 注入实体管理器
	 */
	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) throws SQLException {
		/**
		 * 启动h2数据库
		 */
		Server.main("-tcp", "-tcpAllowOthers","-ifNotExists");
		SpringApplication springApplication = new SpringApplication(TangApplication.class);
		springApplication.run(args);
	}

	/**
	 * 配置websocket
	 */
    @Bean
    ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	/**
	 * 配置https
	 * @ConditionalOnProperty注解的作用是当配置文件中tang-https=true时，才会执行下面的方法
	 */
    @Bean
    @ConditionalOnProperty(value = "tang-https", havingValue = "true")
    ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(createStandardConnector());

		tomcat.addContextCustomizers(context -> {
			RealmBase realmBase = new RealmBase() {
				@Override
				protected String getPassword(String username) {
					return null;
				}

				@Override
				protected Principal getPrincipal(String username) {
					return null;
				}
			};
			realmBase.setTransportGuaranteeRedirectStatus(301);
			context.setRealm(realmBase);
		});
		return tomcat;
	}

	/**
	 * 配置http转https
	 */
	private Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(80);
		connector.setSecure(false);
		connector.setRedirectPort(443);
		return connector;
	}
}
