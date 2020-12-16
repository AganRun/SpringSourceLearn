package com.agan.aop.book;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class ProxyTest {

    public static void main(String[] args) {
//        jdkAOP();
        cglibAOP();
    }

    static void cglibAOP() {
        ProxyFactory factory = new ProxyFactory(new Executable());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        factory.addAdvisor(advisor);
        Executable proxyObject = (Executable) factory.getProxy();
        proxyObject.execute();
        System.out.println(proxyObject.getClass());
    }

    static void jdkAOP() {
        MockTask task = new MockTask();
        ProxyFactory factory = new ProxyFactory(task);
//        factory.setInterfaces(new Class[]{ITask.class});

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());

        factory.addAdvisor(advisor);

        ITask proxyObject = (ITask) factory.getProxy();
        proxyObject.execute();
        System.out.println("----" + proxyObject.getClass());
    }
}
