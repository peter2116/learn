package rtti;

import static pub.PubUtil.log;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/9/14
 * @Description:
 * @modifier
 */
public class ClassDemo {

	public static void main(String[] args) {

		Class c = null;

		try {
			c = Class.forName("rtti.Fancy");
		} catch (ClassNotFoundException e) {
			log("ClassDemo---" + e.getMessage());
		}

		printInfo(c);

		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}

		Class up = c.getSuperclass();

		Object o = null;

		try {
			o = up.newInstance(); //需要默认构造器
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		printInfo(o.getClass());

	}

	static void printInfo(Class cc) {
		log("Class Name:" + cc.getName() + " is interface?[" + cc.isInterface() + "]" + " simpleName: " + cc.getSimpleName()
		+ " canonicalName: " + cc.getCanonicalName()
		);
	}


}

class Toy {

	Toy() {};

	Toy(int i) {

	}

}

class Fancy extends  Toy implements HasBateries, Waterproof, Shoots {

	Fancy(){super(1);};
}

interface HasBateries{}

interface Waterproof{}

interface Shoots{}
