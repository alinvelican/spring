package com;

public class ProxyMain {
    public static void main(String[] args) {
        System.out.println("proxy");
        var proxy = new ProxyEnglishChecker(new EnglishChecker());
        proxy.check("aaa");
    }
}

class ProxyEnglishChecker implements Checker {
    private EnglishChecker englishChecker;

    public ProxyEnglishChecker(EnglishChecker englishChecker) {
        this.englishChecker = englishChecker;
    }

    @Override
    public String check(String text) {
        System.out.println("am logat english checker ul");
        return englishChecker.check(text);
    }
}

class ProxyEnglishChecker2 extends EnglishChecker {
    @Override
    public String check(String text) {
        System.out.println("am logat english checker ul");
        return super.check(text);
    }
}