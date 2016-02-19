import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by tancw on 2016/1/26.
 */
public class FutureTest {
	ExecutorService executor = Executors.newSingleThreadExecutor();

	@Test
	public void test() {
		Callable<Boolean> callable = new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return doSendMsg();
			}
		};
		final FutureTask<Boolean> future = new FutureTask<Boolean>(callable);
		executor.execute(future);
		System.out.println("main over");

		// do {
		// Thread.sleep(1000L);
		// } while (future.isDone());
		// if (future.isDone()) {
		// System.out.println("over");
		// }
		// System.out.println("开始等2s.......");
		// try {
		// Thread.sleep(2000L);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println("结束等2s.......");

		new Timer(false).schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("run");
				if (future.isDone()) {
                    System.out.println("over");
                }
			}
		}, 1000L, 1000L);

		System.out.println("show");
	}

	@Test
	public void test2() {
		doSendMsg();
	}

	private Boolean doSendMsg() {
		// System.out.println("do sned");
		int i = 0;
		do {
			// System.out.println("do send" + i++);
		} while (i < 1000);
		return Boolean.TRUE;
	}
}
