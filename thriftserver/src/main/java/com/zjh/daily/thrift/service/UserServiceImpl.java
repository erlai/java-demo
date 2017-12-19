package com.zjh.daily.thrift.service;

import org.apache.thrift.TException;

/**
 * Created by zhaojinhai on 2017/12/19 15:18.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public int save(User user) throws TException {
        System.out.println(user);
        return 0;
    }

    @Override
    public User getById(int id) throws TException {
        return new User("a",1,1);
    }
}
