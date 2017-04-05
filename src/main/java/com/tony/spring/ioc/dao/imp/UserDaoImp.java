package com.tony.spring.ioc.dao.imp;

import com.tony.spring.ioc.dao.UserDao;
import com.tony.spring.ioc.model.User;

public class UserDaoImp implements UserDao {

    public void add(User user) {

        System.out.println("user is saved");

    }

}
