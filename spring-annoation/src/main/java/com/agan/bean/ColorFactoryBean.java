package com.agan.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 *
 * @author agan
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象，这个对象会添加到容器中。
     * 从容器中获取Bean时会调用
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("FactoryBean创建Color");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是单例？
     *     true：这个bean是单实例，在容器中保存一份。（只调用一次getObject）
     *     false：多实例，每次获取都会创建一个新的bean；
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
