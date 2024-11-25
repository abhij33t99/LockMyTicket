package com.ticketbooking.notificationservice.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Config {

    @Value("${spring.mail.host}")
    public String host;

    @Value("${spring.mail.port}")
    public int port;

    @Bean
    public JavaMailSender  javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");

        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }
}
