package jcip;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/25
 * @Description:
 * @modifier
 */
public class NotVisiable {

	private static boolean ready;
	private static int number;


	public static class ReadyThread extends Thread{
		@Override
		public void run() {
			while (ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new ReadyThread().start();
		number = 42;
		ready = true;
	}

}
