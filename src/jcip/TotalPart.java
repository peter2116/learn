package jcip;

import java.util.concurrent.TimeUnit;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class TotalPart implements Runnable {

	int time;
	int count;

	public TotalPart(int time, int count) {
		this.time = time;
		this.count = count;
	}

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Total.total += count;
	}
}
