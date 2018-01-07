package jcip;

import sun.applet.Main;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/26
 * @Description:
 * @modifier
 */
public class LiftOff implements Runnable{

	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount ++;

	public LiftOff() {};

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "liftOff!") + ")";
	}

	@Override
	public void run() {
		while (countDown-- >0) {
			System.out.println(status());
//			Thread.yield();
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

//		LiftOff liftOff = new LiftOff();
//		liftOff.run();


//		Thread thread = new Thread(new LiftOff());
//		thread.start();


//		for(int i=0; i < 5; i++){
//			new Thread(new LiftOff()).start();
//		}

		ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i=0; i<8; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();

		Executor executor = null;


		System.out.println("waiting for liftOff!");


	}



}
