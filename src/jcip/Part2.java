package jcip;

import net.jcip.annotations.GuardedBy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/24
 * @Description:
 * @modifier
 */
public class Part2 {

	@GuardedBy("this")private final AtomicLong count = new AtomicLong(0);

	public long getCount() {
		return count.get();
	}

	public void increaseCount() {
		count.incrementAndGet();
	}

}
