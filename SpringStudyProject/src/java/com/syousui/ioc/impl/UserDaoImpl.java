package com.syousui.ioc.impl;

import com.syousui.ioc.UserDao;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : UserDaoImpl.java
 * @PackageLoaction : com.syousui.ioc.impl
 * @createTime : 2020-09-03 09:39:00 星期四
 * @Description : TODO
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void say ( ) {
        System.out.println( "UserDao say: 'Hello World!'" );
    }
}
