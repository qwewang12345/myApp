package com.example.demo.service.zk.exmaple;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WatcherTest {
    private String url;
    private String username;
    private String password;

    private static final String ZOOKEEPER_SERVER_ADDRESS = "localhost:2181";
    private static final Logger logger = LoggerFactory.getLogger(WatcherTest.class);
    private static ZooKeeper zooKeeper = null;

    public WatcherTest() {
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
                        } else if (event.getType() == Event.EventType.NodeDataChanged) {
                            // 当配置信息发生变化时
                            initValue();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            zooKeeper = new ZooKeeper(ZOOKEEPER_SERVER_ADDRESS, 60000, watcher);
            initValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initValue() {
        this.url = getDbUrl();
        this.username = getDbUsername();
        this.password = getDbPassword();
    }

    private String getDbUrl() {
        try {
            byte[] urlData = zooKeeper.getData("/dbconfig/url", true, null);
            return new String(urlData);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getDbUsername() {
        try {
            byte[] data = zooKeeper.getData("/dbconfig/username", true, null);
            return new String(data);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getDbPassword() {
        try {
            byte[] data = zooKeeper.getData("/dbconfig/password", true, null);
            return new String(data);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws InterruptedException {
        WatcherTest watcherTest = new WatcherTest();
        for (int i = 0; i < 30; i++) {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("dburl : " + watcherTest.getDbUrl());
            System.out.println("dbusername : " + watcherTest.getDbUsername());
            System.out.println("dbpassword : " + watcherTest.getPassword());
            System.out.println("####################################################");
        }
    }

}