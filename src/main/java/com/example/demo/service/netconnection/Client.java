package com.example.demo.service.netconnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client {

    private Socket socket;
    private WriteTask writeTask;

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
    }

    String[] string = {"用户名：admin；密码：admin", "身无彩凤双飞翼，心有灵犀一点通。", "两情若是久长时，又岂在朝朝暮暮。"
            , "沾衣欲湿杏花雨，吹面不寒杨柳风。", "何须浅碧轻红色，自是花中第一流。", "更无柳絮因风起，唯有葵花向日倾。"
            , "海上生明月，天涯共此时。", "一寸丹心图报国，两行清泪为思亲。", "清香传得天心在，未话寻常草木知。",
            "和风和雨点苔纹，漠漠残香静里闻。"};

    public Client() throws IOException {
        //1、创建客户端Socket，指定服务器地址和端口
        socket = new Socket("127.0.0.1", 9013);
    }

    public void start(){
        try {
            writeTask = new WriteTask();
            writeTask.outputStream = new DataOutputStream(socket.getOutputStream());//默认初始化发给自己
            writeTask.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] int2ByteArrays(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }
    //消息队列
    private volatile ConcurrentLinkedQueue<BasicProtocol> reciverData= new ConcurrentLinkedQueue<BasicProtocol>();

    /**
     * 负责写入数据
     */
    public class WriteTask extends Thread{
        private DataOutputStream outputStream;
        private boolean isCancle = false;
        private Timer heart = new Timer();//发送心跳包的定时任务
        private Timer message = new Timer();//模拟发送普通数据
        @Override
        public void run() {
            //每隔20s发送一次心跳包
            heart.schedule(new TimerTask() {
                @Override
                public void run() {
                    reciverData.add(new HeartBeatProtocol());
                }
            },0,1000*20);

            //先延时2s，然后每隔6s发送一次普通数据
            Random random = new Random();
            message.schedule(new TimerTask() {
                @Override
                public void run() {
                    MessageProtocol bp = new MessageProtocol();
                    bp.setContext(string[random.nextInt(string.length)]);
                    reciverData.add(bp);
                }
            },1000*2,1000*6);


            while (!isCancle){
                BasicProtocol bp = reciverData.poll();
                if(bp!=null){
                    System.out.println("------:"+bp.getContext());
                    ProtocolUtil.writeOutputStream(bp,outputStream);
                }
            }
        }
    }

    /**
     * 停止掉所有活动
     */
    public void stops(){
//        if (readTask!=null){
//            readTask.isCancle=true;
//            readTask.interrupt();
//            readTask=null;
//        }

        if (writeTask!=null) {
            writeTask.isCancle = true;
            //取消发送心跳包的定时任务
            writeTask.heart.cancel();
            //取消发送普通消息的定时任务
            writeTask.message.cancel();
            writeTask.interrupt();
            writeTask=null;
        }
    }
}
