package pattern.singleLeton;

import org.junit.Test;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/17
 * @Description:
 * @modifier
 */
public class TestSingleton {

	@Test
	public void test1() {
		Singleleton1 s1_1 = Singleleton1.getNewInstance();
		Singleleton1 s1_2 = Singleleton1.getNewInstance();
		System.out.println(s1_1 == s1_2);
	}

	public void test2() {
	}

}
