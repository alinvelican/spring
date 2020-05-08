package com;

public class EmailServiceFactory {
    public static EmailService newFrenchEmailer() {
        Checker checker = new FrenchChecker();
        EmailService emailer = new EmailService(checker);
//        emailer.setChecker(checker);
        return emailer;
    }

    public static EmailService newEnglishEmailer() {
        Checker checker = new EnglishChecker();
        EmailService emailer = new EmailService(checker);
//        emailer.setChecker(checker);
        return emailer;
    }
}
