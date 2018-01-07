package pattern.watchPattern;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/25
 * @Description:
 * @modifier
 */
public class WatcherC implements IWatcher {

	@Override
	public void actAfterWatch() {
		System.out.println("I am C i have watched and act !");
	}
}
