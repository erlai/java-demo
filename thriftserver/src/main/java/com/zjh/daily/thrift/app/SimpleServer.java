package com.zjh.daily.thrift.app;

import com.zjh.daily.thrift.service.HelloService;
import com.zjh.daily.thrift.service.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by zhaojinhai on 2017/12/19 09:55.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */
public class SimpleServer {
    private static int port = 8080;

    public static void main(String[] args) {
        System.out.println("thrift service start .....");
        try {
            TProcessor proc = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
            TServerSocket tServerSocket = new TServerSocket(port);
            TServer.Args  targs = new TServer.Args(tServerSocket);
            targs.processor(proc);
            targs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(targs);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
