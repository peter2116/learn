package pattern.chain;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description: 抽象处理者角色
 * @modifier
 */
public abstract class Handler {



	private Handler nextHandler;


	public abstract void handleRequest();


	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}



}
