package com.agan.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements ApplicationContextAware {

    public ApplicationContext context;

    public Dog() {
        System.out.println("dog construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog post construct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dog pre destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
