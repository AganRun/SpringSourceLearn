package com.agan.config;

import com.agan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// 使用PropertySource读取外部配置文件中的K-V保存到环境变量中
@PropertySource(value = {"classpath:person.properties"}, encoding = "UTF-8")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
