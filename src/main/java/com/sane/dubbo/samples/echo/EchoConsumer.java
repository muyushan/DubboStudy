package com.sane.dubbo.samples.echo;

import com.sane.dubbo.samples.echo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EchoConsumer {
    public static void main(String[] args){

        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring/echo-consumer.xml");
        classPathXmlApplicationContext.start();
       EchoService echoService= (EchoService) classPathXmlApplicationContext.getBean("echoService");
       echoService.echo("母玉山");
    }
}
