package pattern.chain;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class HandlerA extends Handler {

	@Override
	public void handleRequest() {
		System.out.println("I am A ,my next Handler is B");

		if(null != getNextHandler()) {
			getNextHandler().handleRequest();
		}
	}
}
