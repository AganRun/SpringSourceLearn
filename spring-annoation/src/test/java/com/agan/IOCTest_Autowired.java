package com.agan;

import com.agan.bean.Dog;
import com.agan.bean.Person;
import com.agan.config.MainConfigOfAutowired;
import com.agan.config.MainConfigOfPropertyValues;
import com.agan.dao.PersonDao;
import com.agan.service.PersonService;
import com.agan.service.PersonServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IOCTest_Autowired {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void testPrintBeans() {
        PersonServiceImpl service = context.getBean(PersonServiceImpl.class);
        System.out.println(service);

        Map<String, PersonDao> map = context.getBeansOfType(PersonDao.class);
        System.out.println(map);
    }

    @Test
    public void testAware() {
        System.out.println(context.getBean("personDao1"));;
        Dog dog = context.getBean(Dog.class);
        System.out.println(dog.context.getBean("personDao1"));
    }
}
