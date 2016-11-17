package com.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Created by tancw on 2016/11/9.
 */
public class ThreadDemo {
	static ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

	public static void main(String[] args) {
		List<Bean> rs = dothread();
        System.out.println(rs);
    }

	static List<Bean> dothread() {
		List<Bean> lst = new ArrayList<Bean>();
		for (int i = 0; i < 100; i++) {
			lst.add(new Bean(true));
		}

		ListenableFuture<List<Bean>> f = executor.submit(new Callable<List<Bean>>() {
			@Override
			public List<Bean> call() throws Exception {
				return doSend(lst);
			}
		});

		Futures.addCallback(f, new FutureCallback<List<Bean>>() {
			@Override
			public void onSuccess(List<Bean> result) {
				System.out.println("success");
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("fail");
			}
		});

		try {
			return  f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
		return null;
	}

	static List<Bean> doSend(final List<Bean> param) {
		for (Bean bean : param) {
			System.out.println("dosomething");
			bean.setStatus(false);
		}
		return param;
	}

	static class Bean {
		private boolean status;

		public Bean(boolean status) {
			this.status = status;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Bean{" + "status=" + status + '}';
		}
	}

}
