package rtti;

import static pub.PubUtil.log;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/9/14
 * @Description:
 * @modifier
 */
public class TypeDemo {

	public static void main(String[] args) {
		Class c = Boolean.TYPE;
		Class c1 = boolean.class;

		log(c == c1);
	}

}
