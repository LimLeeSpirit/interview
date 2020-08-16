package com.lzz.learn.designPattern.proxy.proxys;


import com.lzz.learn.designPattern.proxy.IUserDao;

public class UserDaoStaticProxy implements IUserDao {
    private IUserDao iUserDao;

    public UserDaoStaticProxy(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        iUserDao.save();
        System.out.println("提交事务");
    }
}
