package com.agan.condition;

import com.agan.bean.RainBow;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author agan
 *
 * 类注册器
 */
public class MyImportBeanRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册方法
     * @param importingClassMetadata 当前类的注解信息
     * @param registry  BeanDefinition注册类；
     *                  把所有需要添加到容器中的bean；调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //如果注册了蓝色类，那么要出现彩虹
        boolean blueDefinition = registry.containsBeanDefinition("com.agan.bean.Blue");
        if (blueDefinition) {
            BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
