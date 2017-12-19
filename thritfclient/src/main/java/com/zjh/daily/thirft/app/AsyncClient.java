package com.zjh.daily.thirft.app;

import com.zjh.daily.thirft.service.HelloService;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhaojinhai on 2017/12/19 14:35.
 * Email:zhaojinhai@wanda.cn
 * Version:1.0.0
 * Desc:
 */

public class AsyncClient {
    public static void main(String[] args) throws Throwable{
        TNonblockingTransport transport = new TNonblockingSocket("localhost", 8080) {
        };
        TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
        TAsyncClientManager clientManager = new TAsyncClientManager();
        HelloService.AsyncClient asyncClient =new HelloService.AsyncClient(protocolFactory,clientManager,transport);
        CountDownLatch latch = new CountDownLatch(1);
        asyncClient.sayHello("wanda123",new Callback(latch));
        latch.await();
        System.out.printf("execute finish");
    }
    public static class Callback implements AsyncMethodCallback<String>{
        CountDownLatch latch;

        public Callback(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void onComplete(String response) {
            System.out.println("async--------"+response);
            latch.countDown();
        }

        @Override
        public void onError(Exception exception) {
            exception.printStackTrace();
        }
    }
}
