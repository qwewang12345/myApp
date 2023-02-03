package com.example.demo.service.rpc;

import org.junit.Test;

/**
 * @author gaonan1
 * @date 2021/1/19 22:43
 **/
public class ServerTest {

    @Test
    public void startServer() {
        RpcServer server = new RpcServer();
        server.start(9998, "com.example.demo.service.rpc");
    }
}
