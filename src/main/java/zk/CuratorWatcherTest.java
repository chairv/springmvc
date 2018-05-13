package zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryNTimes;

/**
 * Created by tancw on 2017/11/15.
 * http://blog.csdn.net/sqh201030412/article/details/51446434
 */
public class CuratorWatcherTest {

    private static final String ZK_ADDRESS = "119.29.239.229:2181";
    private static final String ZK_PATH = "/zktest";


    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS,new RetryNTimes(10,500));
        client.start();
        System.out.println("zk client start successfully!");

        PathChildrenCache watcher = new PathChildrenCache(client,ZK_PATH,true);

        watcher.getListenable().addListener((client1,event)->{
            ChildData data= event.getData();
            if(data == null){
                System.out.println("No data in event["+ event+"]");
            }else{
                System.out.println("Receive event:" + "type=[" + event.getType() + "]"
                + ",path=[" + data.getPath() + "]" + ",data=[" + new String(data.getData()) + "]"
                + ",stat=["+ data.getStat() + "]");
            }
        });
        watcher.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        System.out.println("Register zk watcher successfully!");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
