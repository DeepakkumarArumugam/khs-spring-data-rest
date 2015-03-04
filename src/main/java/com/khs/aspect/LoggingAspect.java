package com.khs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {

	@Before("logPointcut()")
    public void loggingAdvice(JoinPoint jp){
        System.out.println("entering:"+jp.getSignature()+":"+System.currentTimeMillis());
    }
     
    @After("logPointcut()")
    public void secondAdvice(JoinPoint jp){
    	  System.out.println("exiting:"+jp.getSignature()+":"+System.currentTimeMillis());
    }
     
    //Pointcut to execute on all the methods of classes in a package
    @Pointcut("within(com.khs.service.*)")
    public void logPointcut(){}
	

}
