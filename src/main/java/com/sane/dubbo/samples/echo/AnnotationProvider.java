package com.sane.dubbo.samples.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class AnnotationProvider {
    public static void main(String args[]) throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        annotationConfigApplicationContext.start();
        System.in.read();


    };

    @Configuration
    @EnableDubbo(scanBasePackages ="com.sane.dubbo.samples.echo")
    static class ProviderConfiguration {
        @Bean
        public ProviderConfig providerConfig(){
            return new ProviderConfig();
        }

        @Bean
        public ApplicationConfig applicationConfig(){
            ApplicationConfig applicationConfig=new ApplicationConfig();
            applicationConfig.setName("echo-annotation-provider");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig=new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("localhost");
            registryConfig.setPort(2181);
            return  registryConfig;
        }
        @Bean
        public ProtocolConfig protocolConfig(){
            ProtocolConfig protocolConfig=new ProtocolConfig();
            protocolConfig.setName("dubbo");
            protocolConfig.setPort(20880);
            return protocolConfig;
        }

    }
}

