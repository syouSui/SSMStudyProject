package com.syousui.di.impl;

import com.syousui.di.UserService;
import com.syousui.ioc.UserDao;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : UserServiceImpl.java
 * @PackageLoaction : com.syousui.di.impl
 * @createTime : 2020-09-03 16:03:00 星期四
 * @Description : TODO
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao ( UserDao userDao ) {
        this.userDao = userDao;
    }
    @Override
    public void say ( ) {
        this.userDao.say();
        System.out.println( "UserService say: 'Hello World!'" );
    }
}
