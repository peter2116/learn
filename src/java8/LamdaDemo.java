package java8;

import static pub.PubUtil.log;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/9/13
 * @Description:
 * @modifier
 */
public class LamdaDemo {


	public static void main(String[] args) {

		MathOperation add = (a,b) -> a + b;

		MathOperation multi = (a,b) -> a * b;

		log("add---1+2 : " + operate(1,2,add));

		log("multi---2*3 : " + operate(2,3,multi));

		GreetingService greetingService = (message) -> "Hello World " + message;

		log("greet1---" + greetingService.say("Peter"));

		Printinterface printinterface1 = () -> {
			System.out.println("printinterface1--- no parameter");
		};

		printinterface1.print();

		parentPrint(() -> log("传入lamda函数"));

	}


	@FunctionalInterface
	interface MathOperation {

		int operation(int a, int b);

//		int anotherOperation(int a, int b, int c);

	}

	@FunctionalInterface
	interface GreetingService {
		String say(String message);

	}

	interface Printinterface{
		void print();
	}


	private static void parentPrint(Printinterface printinterface) {
		printinterface.print();
	}


	private static int operate(int a, int b, MathOperation mathOperation) {

		return mathOperation.operation(a,b);
	}

}
