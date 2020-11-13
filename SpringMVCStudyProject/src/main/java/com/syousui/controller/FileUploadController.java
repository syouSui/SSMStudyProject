package com.syousui.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传下载控制器
 */
@Controller
public class FileUploadController {

    /**
     * 文件上传控制
     * @param personName 上传人名
     * @param uploadFiles 上传的文件.
     *                    注意 @RequestParam的参数一定要与表单中input的name一致!!!
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping ( "/fileUpload" )
    public void handleFormUpload ( @RequestParam ( "person" ) String personName,
                                   @RequestParam ( "files" ) List<MultipartFile> uploadFiles,
                                   HttpServletRequest request,
                                   HttpServletResponse response ) throws IOException {
        // 判断所上传文件是否存在
        if ( uploadFiles.isEmpty( ) ) {
            response.setContentType( "text/html" );
            response.setCharacterEncoding( "utf-8" );
            response.getWriter( ).println( "文件不能为空!请重新上传!" );
            return;
        }
        //循环输出上传的文件
        for ( MultipartFile file : uploadFiles ) {
            // 设置上传文件的保存地址目录
//            File filePath = new File( request.getServletContext( ).getRealPath( "/upload/" ) );
            File filePath = new File( request.getServletContext( ).getRealPath( "/" ) + "upload/" );
            // 如果保存文件的地址不存在，就先创建目录
            if ( !filePath.exists( ) ) filePath.mkdirs( );

            // 使用UUID重新命名上传的文件名称(上传人_UUID_原文件名称), 并使用MultipartFile接口的方法完成文件上传到指定位置
            file.transferTo( new File(
                            filePath + File.separator +
                                    personName + "_" + UUID.randomUUID( ) + "_" + file.getOriginalFilename( )
                    )
            );
        }
        response.setContentType( "text/html" );
        response.setCharacterEncoding( "utf-8" );
        response.getWriter( ).println( "文件上传成功!" );
    }

    /**
     * 文件下载控制
     * @param fileName 文件名
     * @param request 此参数仅仅是为了传递HTTP请求到下一个处理文件编码的函数.
     * @return
     * @throws IOException
     */
    @RequestMapping ( "/download" )
    public ResponseEntity<byte[]> fileDownload ( String fileName, HttpServletRequest request ) throws IOException {
        // 创建该文件对象
        File file = new File( request.getServletContext( ).getRealPath( "/upload/" ) + File.separator + fileName );

        // 对文件名编码，防止中文文件乱码
        fileName = this.handleFilNameEncoding( fileName, request );

        // 设置响应头
        HttpHeaders headers = new HttpHeaders( );
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData( "attachment", fileName );
        // 定义以流的形式下载返回文件数据
        headers.setContentType( MediaType.APPLICATION_OCTET_STREAM );

        // 使用Spring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray( file ),
                headers,
                HttpStatus.OK
        );
    }

    /**
     * 根据浏览器的不同进行编码设置，返回编码后的文件名
     * @param fileName
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public String handleFilNameEncoding ( String fileName, HttpServletRequest request ) throws UnsupportedEncodingException {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = { "MSIE", "Trident", "Edge" };
        // 获取请求头代理信息
        String userAgent = request.getHeader( "User-Agent" );
        for ( String keyWord : IEBrowserKeyWords ) {
            if ( userAgent.contains( keyWord ) ) {
                //IE内核浏览器，统一为UTF-8编码显示
                return URLEncoder.encode( fileName, "UTF-8" );
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String( fileName.getBytes( StandardCharsets.UTF_8 ), StandardCharsets.ISO_8859_1 );
    }


}
