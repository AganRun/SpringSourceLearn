package com.agan.config;

import com.agan.bean.Person;
import org.springframework.context.annotation.*;

/**
 * @author agan
 * <p>
 * 配置类
 * 涉及注解：@Configuration、@Bean、@ComponentScan、@Conditional
 */
@Configuration  //配置类==配置文件、告诉Spring这是一个配置类
/*
 * @ComponentScan value:指定要扫描的包
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 */
@ComponentScan(
        value = "com.agan",     //扫描指定的包
        includeFilters = {
//                @Filter(type = FilterType.ANNOTATION, value = {Controller.class})   //指定注解 @Controller
//                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = {PeopleService.class})    //指定类型
//                @Filter(type = FilterType.CUSTOM, value = {MySuffixFilter.class})       //指定bean name包含er的类
        }, useDefaultFilters = false    //关闭默认的filter,才能使自定义的Filter生效
)
public class MainConfig {

    @Bean
    public Person person() {
        return new Person("Agan", 12);
    }

//    @Bean
//    @Conditional(DayCondition.class)  //工作日加载
//    public People workerPeople() {
//        return new People("TiredMan", 55);
//    }
}
