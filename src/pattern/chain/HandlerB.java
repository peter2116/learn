package pattern.chain;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class HandlerB extends Handler {

	@Override
	public void handleRequest() {
		System.out.println("I am B ,my next Handler is C");

		if(null != getNextHandler()) {
			getNextHandler().handleRequest();
		}
	}
}
