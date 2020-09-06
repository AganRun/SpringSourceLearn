package com.agan.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {

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
}
