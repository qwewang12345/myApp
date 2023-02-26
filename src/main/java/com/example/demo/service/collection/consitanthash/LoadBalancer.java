package com.example.demo.service.collection.consitanthash;

/**
 * @author gaonan1
 * @date 2020/11/6 20:11
 **/
public interface LoadBalancer {

    // 添加服务器节点
    void addServerNode(String serverNodeName);

    // 删除服务器节点
    void delServerNode(String serverNodeName);

    // 选择服务器节点
    String selectServerNode(String requestURL);
}
