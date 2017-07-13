package com.zookerper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by tancw on 2017/6/27.
 */
public class ZookeeperServer {
    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("localhost:9696", 60, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("已经触发了" + event.getType() + "事件!");
                }
            });

            //创建一个目录节点
            zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            //创建一个子目录节点
            zk.create("testRootPath/testChildPathOne", "testChildDataOne".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(new String(zk.getData("testRootPath", false, null)));
            //取出子目录节点列表
            System.out.println(zk.getChildren("/testRootPath", true));

            //修改子目录节点数据
            zk.setData("testRootpath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
            System.out.println("目录节点状态:[" + zk.exists("/testChildDataTwo", true) + "]");
            //创建另一个子目录节点
            zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));
            zk.delete("/testRootPath/testChildPathTwo", -1);
            zk.delete("/testRootPath/testChildPathOnw", -1);
            zk.delete("/testRootPath", -1);
            zk.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
