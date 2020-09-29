package com.syousui.springDB.dao;

import com.syousui.springDB.pojo.Account;

import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : AccountDao.java
 * @PackageLoaction : com.syousui.springDB.dao
 * @createTime : 2020-09-29 11:18:00 星期二
 * @Description : TODO
 */
public interface AccountDao {
    // 添加
    public int addAccount ( Account account );

    // 更新
    public int updateAccount ( Account account );

    // 删除
    public int deleteAccount ( int id );

    // 通过id查询
    public Account findAccountById(int id);

    // 查询所有账户
    public List<Account> findAllAccount();
}
