package com.agan;

import com.agan.bean.Blue;
import com.agan.bean.Person;
import com.agan.config.MainConfig;
import com.agan.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void testImport() {
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println("Blue bean " + bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
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

    @Test
    public void testCondition() {
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        //可以获取环境信息
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testSingleTon() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(applicationContext);
        System.out.println("ioc容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }

    @SuppressWarnings("resource")
    @Test
    public void testBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        printBeans(applicationContext);
    }
}
