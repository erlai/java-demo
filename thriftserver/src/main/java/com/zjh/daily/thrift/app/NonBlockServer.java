package com.zjh.daily.thrift.app;

import com.zjh.daily.thrift.service.HelloService;
import com.zjh.daily.thrift.service.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * Created by zhaojinhai on 2017/12/19 14:11.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class NonBlockServer {
    public static void main(String[] args)throws Exception {
        TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        TNonblockingServerSocket nbss=new TNonblockingServerSocket(8080);
        TNonblockingServer.Args params = new TNonblockingServer.Args(nbss);
        params.processor(processor);
        params.transportFactory(new TFramedTransport.Factory());
        params.protocolFactory(new TCompactProtocol.Factory());
        TNonblockingServer nbs = new TNonblockingServer(params);
        nbs.serve();
    }
}
