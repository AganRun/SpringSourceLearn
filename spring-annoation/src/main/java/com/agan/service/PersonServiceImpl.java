package com.agan.service;

import com.agan.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author agan
 */
@Service
public class PersonServiceImpl implements PersonService {

    //    @Qualifier("personDao1")    //指定ID装配
//    @Autowired(required = false)      //默认按类型，其次按属性名
//    public PersonDao personDao2;

//    @Resource(name = "personDao1")       //JAVA规范，默认按属性名，可以指定名称，不支持@Primary
    @Inject     //支持@Primary,支持Spring的装配注解
    public PersonDao personDao2;

    @Override
    public String toString() {
        return "PersonServiceImpl{" +
                "personDao=" + personDao2 +
                '}';
    }
}
