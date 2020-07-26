package com.agan.bean;

public class Person {

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("构造Person, name=" + name + ", age=" + age);
    }

    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
