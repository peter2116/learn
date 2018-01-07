package concurrent;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author chen_wj
 * @Description:
 * @date 2018/1/4
 * @Description:
 * @modifier
 */
public class MapDemo {


	@Test
	public void hashTableTest() {

		/**
		 * key不能为null
		 * 线程安全
		 *HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的
		 * */
		Hashtable ht = new Hashtable();

		Map syncMap = Collections.synchronizedMap(new HashMap<>());

	}

}
