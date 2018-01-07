package jcip;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class Total {

	public volatile static int total = 0;


	public static void main(String[] args) throws InterruptedException {

		long begin = System.currentTimeMillis();

		Thread t1 = new Thread(new TotalPart(100,1));
		Thread t2 = new Thread(new TotalPart(200,2));
		Thread t3 = new Thread(new TotalPart(300,3));
		Thread t4 = new Thread(new TotalPart(500,4));

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();

		System.out.println(total);

		long end = System.currentTimeMillis();

		System.out.println("time : " + (end - begin));


	}

}
