package com.example.demo.service.netconnection;

/**
 * @author gaonan1
 * @date 2020/1/7
 **/
public class MessageProtocol extends BasicProtocol{

    private String context;
    static final String TYPE = "0001";

    public void setContext(String context){
        this.context = context;
    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void parseBinary(byte[] bytes) {
        setContext(new String(bytes));
    }

}
