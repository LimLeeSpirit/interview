package com.lzz.learn.designPattern.proxy.impl;

import com.lzz.learn.designPattern.proxy.IUserDao;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}