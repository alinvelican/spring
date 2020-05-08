package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private Checker checker;
    @Monitor
    public void send(String text) {
        System.out.println(checker.check(text));
    }
//    @Autowired

    public EmailService(@Qualifier("frenchChecker") Checker checker) {
        this.checker = checker;
    }
//    public EmailService(@Qualifier("frenchChecker") Checker checker) {
//        this.checker = checker;
//    }

//    public EmailService() {
//        this.checker = new EnglishChecker();
//    }

//    public void setChecker(Checker checker) {
//        this.checker = checker;
//    }
}
