package com.syousui.annotation.dao.impl;

import com.syousui.annotation.dao.AnnotationDao;
import org.springframework.stereotype.Repository;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : AnnotationDaoImpl.java
 * @PackageLoaction : com.syousui.annotation.dao
 * @createTime : 2020-09-08 10:42:00 星期二
 * @Description : TODO
 */
@Repository( "myDao" )
public class AnnotationDaoImpl implements AnnotationDao {
    @Override
    public void save ( ) {
        System.out.println( "dao worked..." );
    }
}
