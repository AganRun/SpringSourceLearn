package com.agan;

import com.agan.bean.Person;
import com.agan.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_PropertyValue {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void testPrintBeans() {
        printBeans(context);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        System.out.println("系统环境变量person.remark:" + context.getEnvironment().getProperty("person.remark"));
    }

    /**
     * 打印环境中的Bean名字
     *
     * @param applicationContext 上下文
     */
    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("bean name->" + name);
        }
    }
}
