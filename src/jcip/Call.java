package jcip;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/26
 * @Description:
 * @modifier
 */
public class Call implements Callable<String> {

	private int id;

	public Call(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "The call id is == >" + id;
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> rsList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			rsList.add(exec.submit(new Call(i)));
		}

		for(Future<String> fs: rsList) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
