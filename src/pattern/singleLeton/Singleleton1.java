package pattern.singleLeton;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/17
 * @Description: 饱汉，懒加载，unThreadSafe
 * @modifier
 */
public class Singleleton1 {

	private static Singleleton1 singleleton1;

	private Singleleton1() {};

	public static Singleleton1 getNewInstance() {
		if(null == singleleton1) {
			singleleton1 = new Singleleton1();
		}
		return singleleton1;
	}


}
