package pattern.watchPattern;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/25
 * @Description:
 * @modifier
 */
public class WatcherB implements IWatcher {

	@Override
	public void actAfterWatch() {
		System.out.println("I am B i have watched and act!");
	}
}
