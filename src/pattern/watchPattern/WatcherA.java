package pattern.watchPattern;
import static java.lang.System.out;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/25
 * @Description:
 * @modifier
 */
public class WatcherA implements  IWatcher{

	@Override
	public void actAfterWatch() {
		out.println("I am A , i have watched it and act!");
	}
}
