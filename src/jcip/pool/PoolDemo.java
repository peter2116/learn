package jcip.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/12/15
 * @Description:
 * @modifier
 */
public class PoolDemo {

	private static int nThreads = 3000;//Runtime.getRuntime().availableProcessors();


	public static void main(String[] args) {

		long begin = System.currentTimeMillis();

		ThreadPoolExecutor executor = new ThreadPoolExecutor(nThreads, nThreads,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		List<Future<Integer>> futureList = new ArrayList<>();
		for(int i = 0; i < 100000; i++) {
			MyTask myTask = new MyTask(i);
			futureList.add(executor.submit(myTask));
			System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
					executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());

		}
		executor.shutdown();

		int totalTime = 0;
		for(Future<Integer> future : futureList) {
			try {
				totalTime += future.get();
			} catch (InterruptedException e) {
				System.out.println("异常1----" + e.getMessage());
			} catch (ExecutionException e) {
				System.out.println("异常2----" + e.getMessage());
			}
		}
		System.out.println("串行时间" + totalTime);

		long end = System.currentTimeMillis();

		System.out.println("并行用时---" + (end - begin)/1000 + "秒！");
	}

	public void test() {

	}


}

class MyTask implements Callable<Integer> {

	private int taskNum;

	public MyTask(int taskNum) {
		this.taskNum = taskNum;
	}

//	public void run() {
//
//		System.out.println("正在执行task ：" + taskNum);
//
//		int sleepSeconds = new Random().nextInt(10) + 1;
//
//		try {
////			TimeUnit.SECONDS.sleep(sleepSeconds);
//			Thread.sleep(sleepSeconds);
//		}catch (InterruptedException e) {
//			System.out.println("task ：" + taskNum + "发生异常" + e.getMessage());
//		}
//
//		System.out.println("task ：" + taskNum + "执行完毕");
//	}

	@Override
	public Integer call() throws Exception
	{
		System.out.println("正在执行task ：" + taskNum);

		int sleepSeconds = new Random().nextInt(10) + 1;

		try {
			TimeUnit.SECONDS.sleep(sleepSeconds);
//			Thread.sleep(sleepSeconds);
		}catch (InterruptedException e) {
			System.out.println("task ：" + taskNum + "发生异常" + e.getMessage());
		}

		System.out.println("task ：" + taskNum + "执行完毕");

		return sleepSeconds;
	}

}
