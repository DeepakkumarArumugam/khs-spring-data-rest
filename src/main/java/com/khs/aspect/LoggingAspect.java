package com.khs.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {
	
	Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());	
	
	@Before("logPointcut()")
    public void loggingAdvice(JoinPoint jp){
        LOGGER.info("entering:"+jp.getSignature()+":"+System.currentTimeMillis());
    }
     
    @After("logPointcut()")
    public void secondAdvice(JoinPoint jp){
     LOGGER.info("exiting:"+jp.getSignature()+":"+System.currentTimeMillis());
    }
     
    //Pointcut to execute on all the methods of classes in a package
    @Pointcut("within(com.khs.service.*)")
    public void logPointcut(){}
	

}
