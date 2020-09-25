package com.agan.dao;

import org.springframework.stereotype.Repository;

/**
 * @author agan
 */
@Repository
public class PersonDao {

    private int flag;

    public PersonDao() {

    }

    public PersonDao(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "PersonDao{" +
                "flag=" + flag +
                '}';
    }
}
