package pattern.watchPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/25
 * @Description:
 * @modifier
 */
public class BeWatchedImpl implements IBeWatched {

	private List<IWatcher> watcherList = new ArrayList<>();

	@Override
	public void addWatcher(IWatcher watcher) {
		watcherList.add(watcher);
	}

	@Override
	public void deleteWatcher(IWatcher watcher) {
		watcherList.remove(watcher);
	}

	@Override
	public void notifyWathcer() {
		System.out.println("i am order i am going to show a notice!");
		for(IWatcher watcher : watcherList) {
			watcher.actAfterWatch();
		}
	}

	public static void main(String[] args) {

		IWatcher watcherA = new WatcherA();
		IWatcher watcherB = new WatcherB();
		IWatcher watcherC = new WatcherC();

		IBeWatched watched = new BeWatchedImpl();

		watched.addWatcher(watcherA);
		watched.addWatcher(watcherB);
		watched.addWatcher(watcherC);

		watched.notifyWathcer();

		System.out.println("===================");

		watched.deleteWatcher(watcherB);

		watched.notifyWathcer();
	}
}
