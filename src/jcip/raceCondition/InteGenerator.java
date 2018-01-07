package jcip.raceCondition;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public abstract class InteGenerator {

	private volatile boolean canceled = false;

	public abstract int next();

	public void cancele() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}
}
