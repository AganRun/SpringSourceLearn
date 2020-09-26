package com.agan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(public int com.agan.aop.MathCalculator.*(..))")
    private void pointMethod1(){};

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    @Before("pointMethod1()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("Method:" + joinPoint.getSignature().getName()  + " start. Args: " + Arrays.asList(joinPoint.getArgs()));
    }

    @After("com.agan.aop.LogAspects.pointMethod1()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("end");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "execution(public int com.agan.aop.MathCalculator.*(..))", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("return object is " + result);
    }

    @AfterThrowing(value = "execution(public int com.agan.aop.MathCalculator.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("There is a exception ->" + exception);
    }

}
