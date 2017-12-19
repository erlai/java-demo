package com.zjh.daily.thrift.app;

import com.zjh.daily.thrift.service.HelloService;
import com.zjh.daily.thrift.service.HelloServiceImpl;
import com.zjh.daily.thrift.service.UserService;
import com.zjh.daily.thrift.service.UserServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingTransport;

/**
 * Created by zhaojinhai on 2017/12/19 15:17.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class MutilServer {
    public static void main(String[] args) throws Throwable{
        TMultiplexedProcessor processor = new TMultiplexedProcessor();
        processor.registerProcessor("HelloService",new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl()));
        processor.registerProcessor("UserService",new UserService.Processor<UserService.Iface>(new UserServiceImpl()));

        TNonblockingServerTransport transport = new TNonblockingServerSocket(8080);
        TThreadedSelectorServer.Args params = new TThreadedSelectorServer.Args(transport);
        params.processor(processor);
        params.protocolFactory(new TCompactProtocol.Factory());
        params.transportFactory(new TFramedTransport.Factory());
        TServer server = new TThreadedSelectorServer(params);
        server.serve();
    }
}
