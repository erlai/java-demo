package com.zjh.daily.thirft.app;

import com.zjh.daily.thirft.service.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by zhaojinhai on 2017/12/19 10:21.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TSocket("localhost",8080,1000);
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloService.Client client = new HelloService.Client(protocol);
        try {
            transport.open();
            String msg = client.sayHello("zjh");
            System.out.println(msg);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
