package com.agan.aop.book;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("start");
        try {
            System.out.println("before");
            return invocation.proceed();
        } catch (Exception e) {
            System.out.println("exception happend");
        } finally {
            System.out.println("final");
        }
        return null;
    }
}
