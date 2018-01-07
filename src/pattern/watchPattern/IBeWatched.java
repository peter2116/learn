package pattern.watchPattern;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/25
 * @Description:
 * @modifier
 */
public interface IBeWatched {

	void addWatcher(IWatcher watcher);

	void deleteWatcher(IWatcher watcher);

	void notifyWathcer();

}
