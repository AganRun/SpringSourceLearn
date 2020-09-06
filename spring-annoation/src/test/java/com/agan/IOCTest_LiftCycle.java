package com.agan;

import com.agan.config.MainConfigOfLiftCycle;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 生命周期测试类
 */
public class IOCTest_LiftCycle {

    @Test
    public void testLiftCycle() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLiftCycle.class);
        System.out.println("容器启动完成");
        System.out.println("容器关闭");
        applicationContext.close();
    }
}
