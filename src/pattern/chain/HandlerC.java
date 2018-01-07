package pattern.chain;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class HandlerC extends Handler{

	@Override
	public void handleRequest() {
		System.out.println("I am C , i am the last Handler!");

		if(null != getNextHandler()) {
			getNextHandler().handleRequest();
		}
	}


	public static void main(String[] args) {
		Handler handlerA = new HandlerA();
		Handler handlerB = new HandlerB();
		Handler handlerC = new HandlerC();

		handlerA.setNextHandler(handlerB);
		handlerB.setNextHandler(handlerC);

		handlerA.handleRequest();
	}
}
