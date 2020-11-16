//package com.uniform.userservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Configuration
//public class MailConfig {
//
//    //@Value("${spring.mail.host}")
//    private String hostMail;
//
//    //@Value("${spring.mail.port}")
//    private int port;
//
//    //@Value("${spring.mail.username}")
//    private String mailUserName;
//
//    //@Value("${spring.mail.password}")
//    private String mailPassword;
//
//    @Bean
//    public JavaMailSenderImpl emailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(hostMail);
//        mailSender.setPort(port);
//
//        mailSender.setUsername(mailUserName);
//        mailSender.setPassword(mailPassword);
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return mailSender;
//    }
//
//}
