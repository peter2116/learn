package jcip.raceCondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class EvenChecker implements Runnable {

	private InteGenerator inteGenerator;

	private final int id;

	public EvenChecker(InteGenerator inteGenerator, int id) {
		this.inteGenerator = inteGenerator;
		this.id = id;
	}

	@Override
	public void run() {
		while(!inteGenerator.isCanceled()) {
			int val = inteGenerator.next();
			if(val % 2 !=0) {
				System.out.println(val + "not even!");
				inteGenerator.cancele();
			}
		}
	}

	public static void test(InteGenerator g, int count) {
		System.out.println("press Ctr+c to exit!");
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0; i<count; i++) {
			es.execute(new EvenChecker(g,count));
			es.shutdown();
		}

	}


	public static void main(String[] args) {

	}
}
