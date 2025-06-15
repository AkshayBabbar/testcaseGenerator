package com.testcase.generator;

import org.apache.catalina.valves.RemoteIpValve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestCaseGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestCaseGeneratorApplication.class, args);
    }
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        RemoteIpValve remoteIpValve = new RemoteIpValve();
        remoteIpValve.setRemoteIpHeader("x-forwarded-for");
        remoteIpValve.setProtocolHeader("x-forwarded-proto");
        tomcat.addEngineValves(remoteIpValve);
        return tomcat;
    }
}