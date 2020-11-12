package com.syousui.springDB.pojo;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : Account.java
 * @PackageLoaction : com.syousui.springDB.pojo
 * @createTime : 2020-09-29 11:17:00 星期二
 * @Description : TODO
 */
public class Account {
    private Integer id;
    private String username;
    private Double balance;
    public Account ( ) {
    }
    public Account ( String username, Double balance ) {
        this.username = username;
        this.balance = balance;
    }
    public Account ( Integer id, String username, Double balance ) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }
    public Integer getId ( ) {
        return id;
    }
    public void setId ( Integer id ) {
        this.id = id;
    }
    public String getUsername ( ) {
        return username;
    }
    public void setUsername ( String username ) {
        this.username = username;
    }
    public Double getBalance ( ) {
        return balance;
    }
    public void setBalance ( Double balance ) {
        this.balance = balance;
    }
    public String toString ( ) {
        return "Account [id=" + id + ", "
                + "username=" + username +
                ", balance=" + balance + "]";
    }
}
