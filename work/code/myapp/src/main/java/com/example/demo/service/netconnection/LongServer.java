package com.example.demo.service.netconnection;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongServer implements Runnable {

    private ReadTask readTask;//读数据的线程
    private Socket socket;

    public LongServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            readTask = new ReadTask();
            readTask.inputStream = new DataInputStream(socket.getInputStream());
            readTask.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 负责读取数据
     */
    public class ReadTask extends Thread {
        private DataInputStream inputStream;
        private boolean isCancle = false;//是否取消循环

        @Override
        public void run() {
            //   try {
            while (!isCancle) {
                try {
                    // inputStream = new DataInputStream (socket.getInputStream());
                    BasicProtocol protocol = ProtocolUtil.readInputStream(inputStream);
                    if (protocol != null) {
                        System.out.println("================:" + protocol.getContext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            } catch (IOException e) {
//                e.printStackTrace();
//                stops();//捕获到io异常，可能原因是连接断开了，所以我们停掉所有操作
//            }
        }
    }

    /**
     * 停止掉所有活动
     */
    public void stops() {
        if (readTask != null) {
            readTask.isCancle = true;
            readTask.interrupt();
            readTask = null;
        }
    }

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newCachedThreadPool();
        boolean isStart = true;
        LongServer serverResponseTask = null;
        try {
            serverSocket = new ServerSocket(9013);
            while (isStart) {
                Socket socket = serverSocket.accept();
                String userIP = socket.getInetAddress().getHostAddress();
                System.out.println("用户的IP地址为：" + userIP);
                serverResponseTask = new LongServer(socket);

                if (socket.isConnected()) {
                    executorService.execute(serverResponseTask);
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    isStart = false;
                    serverSocket.close();
                    serverResponseTask.stops();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}