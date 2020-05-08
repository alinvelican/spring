package com;

public class Main {
    public static void main(String[] args) {

        Checker checker = new FrenchChecker();
        EmailService emailService = new EmailService(checker);

//        Emailer emailer = new Emailer();
//        emailService.send("text");

        EmailServiceFactory.newEnglishEmailer().send("text");


    }
}
