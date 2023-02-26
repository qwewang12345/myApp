package com.example.demo.service.netconnection;

/**
 * @author gaonan1
 * @date 2020/1/7
 **/
public class HeartBeatProtocol extends BasicProtocol {

    static final String TYPE = "0000";
    @Override
    public String getContext() {
        return "兄弟，我还在，你不要担心";
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void parseBinary(byte[] bytes) {

    }
}
