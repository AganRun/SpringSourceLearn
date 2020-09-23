package com.agan.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("构造Person, name=" + name + ", age=" + age);
    }

    public Person() {}

    /**
     * value赋值
     * 1. 基本数值
     * 2. Spel表达式#{}
     * 3.从配置文件取值（运行时环境变量）
     */
    @Value("默认名字")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.remark}")
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }
}
