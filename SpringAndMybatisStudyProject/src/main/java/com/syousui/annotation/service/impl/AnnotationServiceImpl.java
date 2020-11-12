package com.syousui.annotation.service.impl;

import com.syousui.annotation.dao.AnnotationDao;
import com.syousui.annotation.service.AnnotationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : AnnotationImpl.java
 * @PackageLoaction : com.syousui.annotation.service
 * @createTime : 2020-09-08 10:42:00 星期二
 * @Description : TODO
 */
@Service ( "myService" )
public class AnnotationServiceImpl implements AnnotationService {
    @Resource ( name = "myDao" )
    private AnnotationDao annotationDao;
    @Override
    public void save ( ) {
        this.annotationDao.save();
        System.out.println( "service worked..." );
    }
}
