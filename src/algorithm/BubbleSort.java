package algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chen_wj
 * @Description:
 * @date 2018/4/22
 * @Description:
 * @modifier
 */
public class BubbleSort {

	/**
	 * @Description:
	 *
	 * @author chen_wj
	 * @date 2018/4/22
	 *
	 * @param arr 要排序的数组
	 * @param orderType 0 降序， 1 升序
	 * @return 0 失败 1 成功
	 */
	public void sort(int[] arr, int orderType) {

		if(null == arr || arr.length == 0) {
			throw new RuntimeException("排序数组为null或为空！");
		}

		for(int i = 0,len = arr.length; i < len; i++) {
			for(int j = 0, end = len - i - 1; j < end; j++){
				/**
				 * 降序排列，相邻两个元素依次对比，若左>右则交换位置，每循环一次会把最小的一个移到末端
				 */
				if(0 == orderType) {
					if(arr[j] > arr[j+1]) {
						int tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j+1] = tmp;
					}
				}
				/**
				 * 升序排列，相邻两个元素依次对比，若左<右则交换位置，每循环一次会把最大的一个移到末端
				 */
				else if (1 == orderType) {
					if(arr[j] < arr[j+1]) {
						int tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j+1] = tmp;
					}
				}
				else {
					throw new RuntimeException("排序类型错误！");
				}
			}
		}
	}



	@Test
	public void sortTest() {

		int[] arr1 = {3,9,5,2,6,8,4};

		sort(arr1,0);

		System.out.println("desc:" + Arrays.toString(arr1));

		sort(arr1,1);

		System.out.println("asc:" + Arrays.toString(arr1));

	}

	/************* output *********************************
	 *
	 * desc:[2, 3, 4, 5, 6, 8, 9]
	 * asc:[9, 8, 6, 5, 4, 3, 2]
	 */

}
