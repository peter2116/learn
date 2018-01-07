package jcip;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/12/10
 * @Description:
 * @modifier
 */
public class LockDemo {

	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		System.out.println("main ---- begiin");

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("5 seconds later!");
			}
		},5000);

		System.out.println("main --- end !");
	}

	public void test() {
		synchronized(String.class) {

		}
	}

}
