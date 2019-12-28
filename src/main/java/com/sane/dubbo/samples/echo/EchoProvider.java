package com.sane.dubbo.samples.echo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class EchoProvider {


    public  static void main(String args[]) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring/echo-provider.xml");
        classPathXmlApplicationContext.start();
        System.in.read();

    }
}
