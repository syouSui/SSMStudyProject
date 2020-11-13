package com.syousui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestController.java
 * @PackageLoaction : com.syousui.controller
 * @createTime : 2020-11-10 10:33:00 星期二
 * @Description : TODO
 */

@Controller
@RequestMapping ( value = "/Test" )
public class TestController {

    @RequestMapping ( value = "/test" )
    public void test ( HttpServletResponse response ) throws Exception {
        System.out.println( "/Test/test" );
        response.getWriter( ).print( "Spring Test!" );
    }

    @RequestMapping ( value = "/auto" )
    public void var_auto ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String data = request.getParameter( "var" );
        response.getWriter( ).println( data );
    }

    @RequestMapping ( value = "/var/{num}", method = RequestMethod.GET )
    public void path_auto ( @PathVariable ( "num" ) String num, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println( num );
    }
}
