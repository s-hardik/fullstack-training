package com.hardik.shah;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
   @Before("execution(* com.hardik.shah.ShoppingCart.checkOut(..))")
    public void beforeLogger(JoinPoint jp){
      // System.out.println(jp.getSignature().toString());
       System.out.println(jp.getArgs()[0].toString());
        System.out.println("Before Logger");
    }

    @After("execution(* com.hardik.shah.ShoppingCart.checkOut(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }
    @Pointcut("execution(* com.hardik.shah.ShoppingCart.quantity())")
    public void afterReturningPointCut(){

    }
    @AfterReturning(pointcut = "afterReturningPointCut()",
    returning = "retVal")
    public void afterReturning(int retVal){
        System.out.println("After Returning: "+retVal);
    }
}
