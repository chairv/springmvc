package zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by tancw on 2017/11/14. http://blog.csdn.net/dc_726/article/details/46475633
 */
public class CuratorClientTest {
	private static final String ZK_ADDRESS = "119.29.239.229:2181";
	private static final String ZK_PATH = "/zktest";

	private CuratorFramework client;

	@BeforeClass
	public void init() {
		client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));
		client.start();
		System.out.println("zk client start successfully!");
	}

	@Test
	void create() throws Exception {
		String data1 = "hello";
		print("create", ZK_PATH, data1);
		client.create().creatingParentsIfNeeded().forPath(ZK_PATH, data1.getBytes());
	}

	@Test
	void get() throws Exception {
		print("ls", "/");
		print(client.getChildren().forPath("/"));
		print("get", ZK_PATH);
		print(client.getData().forPath(ZK_PATH));
	}

	@Test
	void getData() throws Exception {
		print("ls", "/");
		print(client.getChildren().forPath("/"));
		print("get", ZK_PATH);
		print(client.getData().forPath(ZK_PATH));
	}

	@Test
	void modifyData() throws Exception {
		String data2 = "world";
		print("set", ZK_PATH, data2);
		client.setData().forPath(ZK_PATH, data2.getBytes());
		print("get", ZK_PATH);
		print(client.getData().forPath(ZK_PATH));
	}

	@Test
	void delete() throws Exception {
		print("delete", ZK_PATH);
		client.delete().forPath(ZK_PATH);
	}

	@Test void list() throws Exception {
		print("ls", "/");
		print(client.getChildren().forPath("/"));
	}

	private static void print(String... cmds) {
		StringBuffer text = new StringBuffer("$");
		for (String cmd : cmds) {
			text.append(cmd).append("  ");
		}
	}

	private static void print(Object result) {
		System.out.println(result instanceof byte[] ? new String((byte[]) result) : result);
	}
}
