package pattern.singleLeton;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/17
 * @Description:
 * @modifier 非延迟加载模式,多线程下无锁，多线程下性能优于饥饿模式
 */
public class SingleLeton4 {

	private static SingleLeton4 singleLeton4 = new SingleLeton4();

	private SingleLeton4() {
		System.out.println("SingleLeton4 --- constuctor");
	};

	public static SingleLeton4 getNewInstance() {
		return singleLeton4;
	}

	public static void main(String[] args) {

	}
}
