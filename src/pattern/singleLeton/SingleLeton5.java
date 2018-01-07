package pattern.singleLeton;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/17
 * @Description: holder模式
 * @modifier
 */
public  class SingleLeton5{

	private String name = "SingleLeton5";

//	private SingleLeton5() {};

	private static class Holder {
		private static final SingleLeton5 singleLeton5 = new SingleLeton5();
		private Holder() {}
	}

	public static SingleLeton5 getNewInstance() {
		return Holder.singleLeton5;
	}
}
