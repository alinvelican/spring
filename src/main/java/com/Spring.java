package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.type.AnnotatedTypeMetadata;


class Cond implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
@EnableAspectJAutoProxy
@Configuration
@ComponentScan
//@Profile("dev")
@PropertySource(value = "classpath:application.properties")
class Config{
    //@Bean(name="aaaa")
//    @Profile("dev")
//    @Conditional(Cond.class)
//    @Bean
//    Checker checker() {
//
//        return new EnglishChecker();
//    }
    @Value("${prop}") String title;
    @Bean
    public
    static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

public class Spring {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//ctx.getBean(EmailService.class).send("text");
//        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

//        ctx.registerBean("emailService",EmailService.class, () -> new EmailService( new FrenchChecker()));
        ((EmailService)ctx.getBean("emailService")).send("text din spring");

    }
}
