package com.sane.dubbo.samples.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.sane.dubbo.samples.echo.refer.EchoConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class AnnotationConsumer {

    public static void main(String[] args){
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(ConsumerConfiguration.class);

        configApplicationContext.start();
        EchoConsumer echoConsumer=configApplicationContext.getBean(EchoConsumer.class);
        String hello=echoConsumer.echo("muyushan");
        System.out.println(hello);
    }
    @Configuration
    @EnableDubbo(scanBasePackages = "com.sane.dubbo.samples.echo")
    @ComponentScan(value = {"com.sane.dubbo.samples.echo"})
    static class  ConsumerConfiguration{
        @Bean
        public ApplicationConfig applicationConfig(){
            ApplicationConfig applicationConfig=new ApplicationConfig();
            applicationConfig.setName("echo-annotation-consumer");
            return applicationConfig;
        }
        @Bean
        public ConsumerConfig consumerConfig(){
            return new ConsumerConfig();
        }

        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig=new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("localhost");
            registryConfig.setPort(2181);
            return  registryConfig;
        }
    }
}
