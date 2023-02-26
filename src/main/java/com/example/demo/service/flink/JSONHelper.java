package com.example.demo.service.flink;

import com.alibaba.fastjson.JSONObject;

/**
 * @author gaonan1
 * @date 2021/2/4 14:07
 **/
public class JSONHelper {

    /**
     * 解析消息，得到时间字段
     * @param raw
     * @return
     */
    public static long getTimeLongFromRawMessage(String raw){
        SingleMessage singleMessage = parse(raw);
        return null==singleMessage ? 0L : singleMessage.getTimeLong();
    }

    /**
     * 将消息解析成对象
     * @param raw
     * @return
     */
    public static SingleMessage parse(String raw){
        SingleMessage singleMessage = null;

        if (raw != null) {
            singleMessage = JSONObject.parseObject(raw, SingleMessage.class);
        }

        return singleMessage;
    }
}
