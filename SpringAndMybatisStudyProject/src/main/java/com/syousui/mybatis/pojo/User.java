package com.syousui.mybatis.pojo;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : User.java
 * @PackageLoaction : com.syousui.mybatis.pojo
 * @createTime : 2020-10-15 09:23:00 星期四
 * @Description : TODO
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User ( ) {
    }
    public User ( Integer id, String name, Integer age ) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId ( ) {
        return id;
    }
    public void setId ( Integer id ) {
        this.id = id;
    }
    public String getName ( ) {
        return name;
    }
    public void setName ( String name ) {
        this.name = name;
    }
    public Integer getAge ( ) {
        return age;
    }
    public void setAge ( Integer age ) {
        this.age = age;
    }
    @Override
    public String toString ( ) {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
