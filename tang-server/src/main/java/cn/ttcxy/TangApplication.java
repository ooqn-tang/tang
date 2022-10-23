package cn.ttcxy;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.realm.RealmBase;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.querydsl.jpa.impl.JPAQueryFactory;

import java.security.Principal;

import javax.persistence.EntityManager;

@SpringBootApplication(scanBasePackages = { "cn.ttcxy" })
@MapperScan("cn.ttcxy.mapper")
@ServletComponentScan
public class TangApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TangApplication.class);
		springApplication.run(args);
	}

	@Bean
    @Autowired
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
	
	@Bean
	@ConditionalOnProperty(value = "tang-https", havingValue = "true")
	public ServletWebServerFactory servletContainer() {
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

	private Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(80);
		connector.setSecure(false);
		connector.setRedirectPort(443);
		return connector;
	}
}
