package com.example.demo.service.netconnection;

import java.io.ByteArrayOutputStream;

/**
 * @author gaonan1
 * @date 2020/1/7
 **/
public abstract class BasicProtocol {

    /**
     * 表示业务类型；1111 -> 心跳包   1234 -> 发送普通文字消息
     */
    static final int TYPE_LEN = 4;

    static final int CONTEXT_LEN = 4;

    /**
     * 获取正文文本
     * @return
     */
    public abstract String getContext();

    /**
     * 获取包装好的byte[]
     * @return
     */
    public byte[] getData() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(getType().getBytes(),0,TYPE_LEN);
            byte[] bytes = getContext().getBytes();
            baos.write(ProtocolUtil.int2ByteArrays(bytes.length),0, CONTEXT_LEN);
            baos.write(bytes,0,bytes.length);
            return baos.toByteArray();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取业务类型
     * @return
     */
    public abstract  String getType();

    /**
     * 解析数据
     * @param bytes
     */
    public abstract void parseBinary(byte[] bytes);

}
