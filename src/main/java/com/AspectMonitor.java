package com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@interface Monitor {
}


@Component
@Aspect
public class AspectMonitor {
//    @Before("execution(public * com.EmailService.send(..))")
    @Before("@annotation(com.Monitor)")
    public void beforeSend(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("in before");
    }

    @Around("execution(*  check(..))")
//@Around("@annotation(com.Monitor)")

public String aroundCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("inainte de check");
        System.out.println(proceedingJoinPoint.getSignature());
        var rez = proceedingJoinPoint.proceed();

        System.out.println("dupa check");
        return (String) rez;
    }
}
