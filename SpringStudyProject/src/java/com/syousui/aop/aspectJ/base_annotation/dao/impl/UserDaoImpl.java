package com.syousui.aop.aspectJ.base_annotation.dao.impl;

import com.syousui.aop.aspectJ.base_annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : UserDaoImpl.java
 * @PackageLoaction : com.syousui.proxy.dao.impl
 * @createTime : 2020-09-22 08:50:00 星期二
 * @Description : TODO
 */
@Repository( "aspectJ_dao" )
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser ( ) {
        System.out.println( "adding user..." );
//        int temp = 10/0;
    }
    @Override
    public void deleteUser ( ) {
        System.out.println( "deleting user..." );
    }
}
