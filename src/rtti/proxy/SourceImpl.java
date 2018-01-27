package rtti.proxy;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/30
 * @Description:
 * @modifier
 */
public class SourceImpl implements Source {

	@Override
	public void method() {
		System.out.println("$$$$$$$$$$$$$$$$$");
	}


	@Override
	public void method2() {
		System.out.println("---------method2");
	}

}
