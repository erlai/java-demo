package com.zjh.daily.thirft.app;

import com.zjh.daily.thirft.service.HelloService;
import com.zjh.daily.thirft.service.User;
import com.zjh.daily.thirft.service.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by zhaojinhai on 2017/12/19 15:26.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class MulitClient {
    public static void main(String[] args) throws Exception{
        TTransport transport = new TFramedTransport(new TSocket("localhost",8080));
        TCompactProtocol protocol = new TCompactProtocol(transport);
        TMultiplexedProtocol userProtocol = new TMultiplexedProtocol(protocol,"UserService");
        TMultiplexedProtocol helloProtocol = new TMultiplexedProtocol(protocol,"HelloService");
        UserService.Client client = new UserService.Client(userProtocol);
        HelloService.Client helloClient = new HelloService.Client(helloProtocol);
        transport.open();
        User u = client.getById(1);
        String msg = helloClient.sayHello("test");
        System.out.println(u);
    }
}
