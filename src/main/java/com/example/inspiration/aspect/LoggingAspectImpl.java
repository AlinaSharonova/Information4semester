package com.example.inspiration.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LoggingAspectImpl implements LoggingAspect{

    @Pointcut("execution(* com.example.inspiration.service.*.*(..))")
    public void logMethod(){}

    @Override
    @Around("logMethod()")
    public Object logMethodAround(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Method params: " + Arrays.toString(proceedingJoinPoint.getArgs()));
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("Method occured");
        return object;
    }

    @Override
    @Before("logMethod()")
    public void logMethodBefore(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature() + " starting");
    }
}
