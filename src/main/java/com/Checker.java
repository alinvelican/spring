package com;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface Checker {
    String check(String text);
}
@Service
class EnglishChecker implements Checker {

    @Override
    public String check(String text) {
        System.out.println("am verificat textul in engleza");
        return text;
    }
}
@Service
class FrenchChecker implements Checker {

    @Override
    public String check(String text) {
        System.out.println("am verificat textul in franceza");
        return text;
    }
}