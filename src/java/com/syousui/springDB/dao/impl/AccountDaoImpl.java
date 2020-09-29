package com.syousui.springDB.dao.impl;

import com.syousui.springDB.dao.AccountDao;
import com.syousui.springDB.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : AccountDaoImpl.java
 * @PackageLoaction : com.syousui.springDB.dao.impl
 * @createTime : 2020-09-29 11:18:00 星期二
 * @Description : TODO
 */
public class AccountDaoImpl implements AccountDao {
    // 声明JdbcTemplate属性及其setter方法
    private JdbcTemplate springJDBC_jdbcTemplate;
    public void setJdbcTemplate ( JdbcTemplate springJDBC_jdbcTemplate ) {
        this.springJDBC_jdbcTemplate = springJDBC_jdbcTemplate;
    }
    // 添加账户
    public int addAccount ( Account account ) {
        // 定义SQL
        String sql = "insert into account(username,balance) value(?,?)";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {
                account.getUsername( ),
                account.getBalance( )
        };
        // 执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.springJDBC_jdbcTemplate.update( sql, obj );
        return num;
    }
    // 更新账户
    public int updateAccount ( Account account ) {
        // 定义SQL
        String sql = "update account set username=?,balance=? where id = ?";
        // 定义数组来存放SQL语句中的参数
        Object[] params = new Object[] {
                account.getUsername( ),
                account.getBalance( ),
                account.getId( )
        };
        // 执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.springJDBC_jdbcTemplate.update( sql, params );
        return num;
    }
    // 删除账户
    public int deleteAccount ( int id ) {
        // 定义SQL
        String sql = "delete  from account where id = ? ";
        // 执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.springJDBC_jdbcTemplate.update( sql, id );
        return num;
    }

    // 通过id查询账户数据信息
    public Account findAccountById ( int id ) {
        //定义SQL语句
        String sql = "select * from account where id = ?";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>( Account.class );
        // 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
        return this.springJDBC_jdbcTemplate.queryForObject( sql, rowMapper, id );
    }

    // 查询所有账户信息
    public List<Account> findAllAccount ( ) {
        // 定义SQL语句
        String sql = "select * from account";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>( Account.class );
        // 执行静态的SQL查询，并通过RowMapper返回结果
        return this.springJDBC_jdbcTemplate.query( sql, rowMapper );
    }

    public void setSpringJDBC_jdbcTemplate ( JdbcTemplate springJDBC_jdbcTemplate ) {
        this.springJDBC_jdbcTemplate = springJDBC_jdbcTemplate;
    }
}
