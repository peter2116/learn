package concurrent;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author chen_wj
 * @Description:
 * @date 2018/1/23
 * @Description:
 * @modifier
 */
public class PriorityBlockingQueueDemo {


	@Test
	public void testQueue() {

		Queue<String> que = new PriorityQueue<String>();

		que.add("1");
		que.add("2");
		que.add("3");
		que.offer("4");

		System.out.println(que.poll());
		System.out.println(que.peek());
		System.out.println(que.element());
	}

}
