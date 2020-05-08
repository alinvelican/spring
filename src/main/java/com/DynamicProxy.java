package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        System.out.println("dp");
        Checker englishChecker = new EnglishChecker();
//        Checker proxyChecker = (Checker)
//                Proxy.newProxyInstance(Checker.class.getClassLoader(),englishChecker.getClass().getInterfaces(), new LoggerProxy(englishChecker));
//

        Checker proxyChecker = (Checker)
                Proxy.newProxyInstance(Checker.class.getClassLoader(),englishChecker.getClass().getInterfaces(), (proxy,method,argss) -> {
                    System.out.println("inainte de apel metoda " + method.getName());
                    System.out.println("apelez metoda " + method.getName());
                    Object result = method.invoke(englishChecker, argss);
                    System.out.println("dupa ce apelez metoda "+ method.getName());
                    return result;

                });

        System.out.println(proxyChecker.check("aaaa"));
    }
}

class LoggerProxy implements InvocationHandler {

    private Object target;

    public LoggerProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("inainte de apel metoda " + method.getName());
        System.out.println("apelez metoda " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("dupa ce apelez metoda "+ method.getName());
        return result;

    }
}
