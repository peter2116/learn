package pattern.singleLeton;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/17
 * @Description: 饱汉，threadSafe,并发时synchronized锁效率差，不敏感场景建议
 * @modifier
 */
public class SingleLeton2 {

	private static SingleLeton2 singleLeton2;

	private SingleLeton2() {};

	public synchronized static SingleLeton2 getNewInstance() {
		if(singleLeton2 == null) {
			singleLeton2 = new SingleLeton2();
		}
		return singleLeton2;
	}

}
