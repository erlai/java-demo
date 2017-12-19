package com.zjh.daily.thrift.service;

import org.apache.thrift.TException;

/**
 * Created by zhaojinhai on 2017/12/19 09:59.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "[thrift] hello "+username;
    }
}
