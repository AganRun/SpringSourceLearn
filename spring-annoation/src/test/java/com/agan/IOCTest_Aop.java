package com.agan;

import com.agan.aop.MathCalculator;
import com.agan.config.MainConfigOfAop;
import com.agan.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Aop {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

    @Test
    public void test01(){
        MathCalculator bean = context.getBean(MathCalculator.class);
        bean.div(1, 1);
    }
}
