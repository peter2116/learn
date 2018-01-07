package pattern.singleLeton;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/17
 * @Description: DCL模式，适合性能敏感场景
 * @modifier
 */
public class SingleLeton3 {

	private volatile static SingleLeton3 singleLeton3;   //volatile确保线程安全，避免了半个对象问题

	private SingleLeton3() {};

	public static SingleLeton3 getNewInstance() {
		if(singleLeton3 == null) {
			synchronized (SingleLeton3.class) {
				if(singleLeton3 == null) {
					singleLeton3 = new SingleLeton3();
				}
			}
		}
		return singleLeton3;
	}

}
