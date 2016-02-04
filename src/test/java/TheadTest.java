import com.comm.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by tancw on 2015/11/26.
 */
public class TheadTest {
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private CompletionService<Result> cs = new ExecutorCompletionService<Result>(executor);
	private CompletionService<int[]> csAry = new ExecutorCompletionService<int[]>(executor);

	@Test
	public void baseTest() {
		FutureTask<Result> future = new FutureTask<Result>(new Callable<Result>() {
			public Result call() throws Exception {
				return doRun();
			}
		});

		executor.execute(future);
		System.out.println("主线程");
		try {
			Result r = future.get();
			System.out.println(r.getMessage());
		} catch (InterruptedException e) {
			// e.printStackTrace();
		} catch (ExecutionException e) {
			// e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

	@Test
	public void submitTest() {
		FutureTask<Result> future = (FutureTask<Result>) executor.submit(new Callable<Result>() {
			public Result call() throws Exception {
				return doRun();
			}
		});

		Result r = null;
		try {
			r = future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
		System.out.println(r.getMessage());
	}

	@Test
	public void testCallableAndFurue() throws InterruptedException, ExecutionException {
		for (int i = 0; i < 100; i++) {
			cs.submit(new Callable<Result>() {
				public Result call() throws Exception {
					return doRun();
				}
			});
		}

		System.out.println("结束了");
		for (int j = 0; j < 100; j++) {
			Future<Result> future = cs.take();
			System.out.printf(future.get().getMessage());
		}
	}

	@Test()
	public void testThread() throws Exception {
		Future<int[]> rs = csAry.submit(new Callable<int[]>() {
			public int[] call() throws Exception {
				return doAry();
			}
		});

		List<Runnable> threadRs = executor.shutdownNow();
		System.out.println("主线程" + executor.isTerminated());
		while (!executor.isTerminated()) {
			Thread.sleep(200);
		}

		cs.submit(new Callable<Result>() {
			public Result call() throws Exception {
				return doRun();
			}
		});

		try {
			System.out.println("主获取: " + Arrays.toString(rs.get(5000, TimeUnit.MILLISECONDS)));
		} catch (InterruptedException e) {
			// e.printStackTrace();
		} catch (TimeoutException e) {
			// e.printStackTrace();
		}

		System.out.println("完了 : " + executor.isTerminated());
	}

	public Result doRun() {
		for (int i = 0; i < 100; i++) {
			System.out.println("结果执行了" + i);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new Result(true, "成功了" + ((int) (Math.random() * 100)));
	}

	public int[] doAry() throws InterruptedException {
		int[] result = { 0, 0 };
		System.out.println("doAry");
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				result[1]++;
			} else {
				result[0]++;
			}
		}
		System.out.println("执行完成了" + Arrays.toString(result));
		Thread.sleep(10000);
		return result;
	}
}
