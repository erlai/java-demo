package com.zjh.daily.thrift.app;

import com.zjh.daily.thrift.service.HelloService;
import com.zjh.daily.thrift.service.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * Created by zhaojinhai on 2017/12/19 13:56.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class ThreadPoolServer {
    public static void main(String[] args)throws Exception {
        TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        TServerSocket serverSocket = new TServerSocket(8080);
        TThreadPoolServer.Args params = new TThreadPoolServer.Args(serverSocket);
        params.processor(processor);
        params.protocolFactory(new TBinaryProtocol.Factory());
        TThreadPoolServer server = new TThreadPoolServer(params);
        server.serve();
    }
}
