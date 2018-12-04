package com.solo.damocles.lab.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * zookeeper自定义客户端
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/11/23 4:04 PM
 */
public class ZkClient {

    private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zk;

    private static final String ZOOKEEPER_ZNODE_NAME = "zookeeper";

    public static void main(String[] args) {
        try {
            ZkClient.startZK();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startZK() throws Exception {
        logger.info("startZK----------------------");
        //确保server确实已经开启了，这里是创建client到server的session
        zk = new ZooKeeper("127.0.0.1:2181", 20000,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        System.out.println("process " + watchedEvent);
                        if (watchedEvent.getState() ==
                                Event.KeeperState.SyncConnected) {
                            countDownLatch.countDown();
                        }
                    }
                });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("state is " + zk.getState());
        logger.info("zk session begin");
    }
}
