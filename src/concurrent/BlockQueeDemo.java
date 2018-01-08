package concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author chen_wj
 * @Description:
 * @date 2018/1/7
 * @Description:
 * @modifier
 */
public class BlockQueeDemo {

	/**
	 * 测试 ArrayBlockQuee
	 * size初始化固定 FIFO
	 */
	@Test
	public void testArrayBlockQuee() throws InterruptedException {

		BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);
		AbqProducer abqProducer = new AbqProducer(blockingQueue);
		AbqConcusmer abqConcusmer = new AbqConcusmer(blockingQueue);

		new Thread(abqConcusmer).start();
		new Thread(abqProducer).start();

		TimeUnit.SECONDS.sleep(5);
	}


	class AbqProducer implements Runnable{

		private BlockingQueue blockingQueue = null;

		public AbqProducer(BlockingQueue blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			try {
				blockingQueue.put("1");
				TimeUnit.SECONDS.sleep(1);
				blockingQueue.put("2");
				TimeUnit.SECONDS.sleep(1);
				blockingQueue.put("3");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ArrayBlockQuee 消费者
	 */
	class AbqConcusmer implements Runnable{

		private BlockingQueue blockingQueue = null;

		public AbqConcusmer(BlockingQueue blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			try {
				System.out.println(blockingQueue.take());
				System.out.println(blockingQueue.take());
				System.out.println(blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/***************************************************************************************/


}
