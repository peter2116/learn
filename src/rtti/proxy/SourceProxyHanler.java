package rtti.proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/30
 * @Description:
 * @modifier
 */
public class SourceProxyHanler implements InvocationHandler {

	private Source source;

	public SourceProxyHanler(Source source) {
		this.source = source;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		String methodName = method.getName();

		System.out.println("before ====== " + methodName);

		method.invoke(source,args);

		System.out.println("end =======" + methodName);

		return null;
	}


	public static void main(String[] args) {

		Source target = new SourceImpl();

		SourceProxyHanler sourceProxyHanler = new SourceProxyHanler(target);

		Source source = (Source) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),sourceProxyHanler);

		source.method();

		source.method2();

	}

}
