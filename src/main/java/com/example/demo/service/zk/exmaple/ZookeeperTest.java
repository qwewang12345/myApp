package com.example.demo.service.zk.exmaple;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @author gaonan
 * @date 2022/12/28 上午10:02
 */
public class ZookeeperTest {

    //增加
    public static void creat(ZooKeeper zooKeeper, String node, String data) throws KeeperException, InterruptedException {
        System.out.println("开始添加节点："+node+"，节点数据为："+data);
        List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        CreateMode createMode = CreateMode.PERSISTENT;
        zooKeeper.create(node,data.getBytes(),acl,createMode);
        System.out.println("zk节点添加成功");
    }

    //删除
    public static void delete(ZooKeeper zooKeeper,String node) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(node,new TestWatcher());
        System.out.println("开始删除节点："+node+"节点版本号为："+stat.getVersion());
        zooKeeper.delete(node, stat.getVersion());
        System.out.println("删除成功");
    }

    //更改
    public static void update(ZooKeeper zooKeeper,String node,String data) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(node,new TestWatcher());
        System.out.println("开始修改节点："+node+"节点版本号为："+stat.getVersion()+"修改数据为："+data);
        zooKeeper.setData(node,data.getBytes(),stat.getVersion());
        System.out.println("zk节点修改成功");
    }

    //查看
    public static void query(ZooKeeper zooKeeper,String node) throws KeeperException, InterruptedException {
        String result = new String(zooKeeper.getData(node, new TestWatcher(),null));
        System.out.println("准备查询节点数据："+node+"-----------"+"节点数据为："+result);
    }

    public static ZooKeeper connect() throws IOException {
        return new ZooKeeper("localhost:2181", 60000, new TestWatcher());
    }

    static class TestWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("事件内容" + watchedEvent.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = connect();
        query(zooKeeper,"/zktest1");
        // creat(zooKeeper,"/zktest1","zktest");
        delete(zooKeeper,"/zktest1");
        creat(zooKeeper,"/zktest1","zktest");
        update(zooKeeper,"/zktest1","myzktest");
        query(zooKeeper,"/zktest1");
    }

}
