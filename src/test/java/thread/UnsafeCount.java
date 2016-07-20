package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tancw on 2016/7/20.
 */
public class UnsafeCount {
	public static AtomicInteger count = new AtomicInteger(0);

	public static void inc() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		count++;
		count.incrementAndGet();
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(Integer.MAX_VALUE);
		for (int i = 0; i < 100; i++) {
			service.execute(() -> UnsafeCount.inc());
		}
		service.shutdown();
		service.awaitTermination(5000, TimeUnit.SECONDS);
		System.out.println("运行结果:UnsafeCOunt.count=" + UnsafeCount.count);
	}
}
