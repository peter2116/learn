package jcip.total;

import jcip.Total;

import java.util.concurrent.*;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class CallParTotal implements Callable<Integer> {

	int time;
	int count;

	public CallParTotal(int time, int count) {
		this.time = time;
		this.count = count;
	}


	@Override
	public Integer call() throws Exception {

		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return count;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		long begin = System.currentTimeMillis();

		ExecutorService es = Executors.newCachedThreadPool();

		Future<Integer> f1 = es.submit(new CallParTotal(1000,1));
		Future<Integer> f2 = es.submit(new CallParTotal(2000,2));
		Future<Integer> f3 = es.submit(new CallParTotal(5000,3));

		int total = f1.get() + f2.get() + f3.get();

		System.out.println("total ==== > " + total);

		long end = System.currentTimeMillis();

		System.out.println("time : " + (end - begin));

	}
}
