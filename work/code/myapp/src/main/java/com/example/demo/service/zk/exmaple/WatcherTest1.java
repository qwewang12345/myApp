package com.example.demo.service.zk.exmaple;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WatcherTest1 {
    private String url;
    private String username;
    private String password;

    private static final String ZOOKEEPER_SERVER_ADDRESS = "localhost:2181";
    private static final Logger logger = LoggerFactory.getLogger(WatcherTest1.class);
    private static ZooKeeper zooKeeper = null;

    public WatcherTest1() {
        try {
            Watcher watcher = new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    try {
                        // 捕获事件状态
                        if (event.getType() == Event.EventType.None) {
                            if (event.getState() == Event.KeeperState.SyncConnected) {
                                logger.info("连接成功...");
                            } else if (event.getState() == Event.KeeperState.Disconnected) {
                                logger.info("连接断开...");
                            } else if (event.getState() == Event.KeeperState.Expired) {
                                logger.info("连接超时...");
                                // 超时后服务器端已经将连接释放，需要重新连接服务器端
                                zooKeeper = new ZooKeeper(ZOOKEEPER_SERVER_ADDRESS, 3000, this);
                            } else if (event.getState() == Event.KeeperState.AuthFailed) {
                                logger.info("验证失败...");
                            }
                        } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                            // 当配置信息发生变化时
                            List<String> nodelist =  zooKeeper.getChildren(event.getPath(), true);
                            logger.info("当前可用节点为nodeList={}", nodelist);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            zooKeeper = new ZooKeeper(ZOOKEEPER_SERVER_ADDRESS, 60000, watcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        WatcherTest1 watcherTest = new WatcherTest1();
        zooKeeper.exists("/ids", true);
        List<String> children = zooKeeper.getChildren("/ids", true);
        logger.info("当前存在的子节点，children={}",children);
        Thread.sleep(300000);
    }

}