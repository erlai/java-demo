package com.zjh.daily.thirft.app;

import com.zjh.daily.thirft.service.HelloService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by zhaojinhai on 2017/12/19 14:19.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class NonBlockClient {
    public static void main(String[] args)throws Exception {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8080));
        TProtocol protocol = new TCompactProtocol(transport);
        HelloService.Client client = new HelloService.Client(protocol);
        transport.open();
        String msg = client.sayHello("wdo");
        System.out.println(msg);
    }
}
