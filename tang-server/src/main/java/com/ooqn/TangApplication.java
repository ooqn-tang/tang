package com.ooqn;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.servlet.api.SecurityConstraint;
import io.undertow.servlet.api.SecurityInfo;
import io.undertow.servlet.api.TransportGuaranteeType;
import io.undertow.servlet.api.WebResourceCollection;

@EnableJpaRepositories
@SpringBootApplication
@ServletComponentScan
public class TangApplication {

	public static void main(String[] args) throws SQLException {
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

    @Bean
    @ConditionalOnProperty(value = "server.ssl.enabled", havingValue = "true")
    ServletWebServerFactory undertowFactory() {
        UndertowServletWebServerFactory undertowFactory = new UndertowServletWebServerFactory();

		undertowFactory.addBuilderCustomizers((Undertow.Builder builder) -> {
			builder.addHttpListener(80, "0.0.0.0");
			builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true);
		});

        undertowFactory.addDeploymentInfoCustomizers(deploymentInfo -> {
            // 开启HTTP自动跳转至HTTPS 
            deploymentInfo.addSecurityConstraint(new SecurityConstraint()
                    .addWebResourceCollection(new WebResourceCollection().addUrlPattern("/*"))
                    .setTransportGuaranteeType(TransportGuaranteeType.CONFIDENTIAL)
                    .setEmptyRoleSemantic(SecurityInfo.EmptyRoleSemantic.PERMIT))
                    .setConfidentialPortManager(exchange -> 443);
        });
        return undertowFactory;
    }

}
