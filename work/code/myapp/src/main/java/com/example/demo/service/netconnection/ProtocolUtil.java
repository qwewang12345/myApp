package com.example.demo.service.netconnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2020/1/7
 **/
public class ProtocolUtil {

    private static Map<String,String> msgImp=new HashMap<String,String>();
    static {
        msgImp.put(HeartBeatProtocol.TYPE,"com.example.demo.service.netconnection.HeartBeatProtocol");
        msgImp.put(MessageProtocol.TYPE,"com.example.demo.service.netconnection.MessageProtocol");
    }

    /**
     * 返回业务类型
     * @param data
     * @return
     */
    public static String paraseType(byte[] data){
        return new String(data,0,BasicProtocol.TYPE_LEN);
    }

    /**
     * int 转 四位字节
     * @param i
     * @return
     */
    public static byte[] int2ByteArrays(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    /**
     * 字节数组转int
     * @param b
     * @return
     */
    public static int byteArrayToInt(byte[] b) {
        int intValue = 0;
        for (int i = 0; i < b.length; i++) {
            intValue += (b[i] & 0xFF) << (8 * (3 - i));
        }
        return intValue;
    }

    /**
     * 从输入流中读取数据
     * @param inputStream
     * @return
     */
    public static BasicProtocol readInputStream(DataInputStream inputStream) {
        try {
            byte[] bytes = new byte[BasicProtocol.TYPE_LEN];
            int type_len = inputStream.read(bytes);
            if(type_len!=bytes.length){
                return null;
            }
            String s_type = paraseType(bytes);
            bytes = new byte[BasicProtocol.CONTEXT_LEN];
            int context_len = inputStream.read(bytes);
            if(context_len != bytes.length){
                return null;
            }
            bytes = new byte[byteArrayToInt(bytes)];
            inputStream.read(bytes);

            BasicProtocol basicProtocol = (BasicProtocol) Class.forName(msgImp.get(s_type)).newInstance();
            basicProtocol.parseBinary(bytes);
            return basicProtocol;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向输出流中写入数据
     * @param protocol
     * @param outputStream
     */
    public static boolean writeOutputStream(BasicProtocol protocol, DataOutputStream outputStream) {
        try {
            outputStream.write(protocol.getData());
            outputStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
