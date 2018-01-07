package algorithm;

import org.junit.Test;

import static java.lang.System.exit;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/7
 * @Description:
 * @modifier
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] arr1 = {1,2,4,6,8,11,33,44,67,88,99,100};

		int target = 50;

		int searchIndex = search(arr1,target);

		System.out.println(searchIndex);

//		int searchIndex

		exit(0);
	}


	/**
	 * search for target
	 * @param arr
	 * @param target
	 * @return
	 */
	private static int search(int[] arr, int target) {

		int min = 0;
		int max = arr.length - 1;
		int count = 0;
		while(min <= max) {

			int middle = (max + min) / 2;

			System.out.println((++count) + "===>" + min + "|" + max + "|" + middle);

			if(arr[middle] == target) {
				return middle;
			}else if(target > arr[middle]){
					min = middle + 1;
			} else {
					max = middle - 1;
			}
		}

		return -1;
	}


	/**
	 * search for the first key = target
	 * @param arr
	 * @param target
	 * @return
	 */
	private static int search2(int[] arr, int target) {
		int min = 0;
		int max = arr.length - 1;
		int count = 0;
		while(min <= max) {

			int mid =  (max + min) / 2;

			System.out.println((++count) + "===>" + min + "|" + max + "|" + mid);
			if(target > arr[mid]) {
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}

		if(arr[min] == target) {
			return min;
		}

		return -1;
	}
	@Test
	public void testSearch2() {
		int[] arr = {1,1,2,4,5,5,5,6,7,7,8,8,9,9};
		int target = 1;
		int searchIndex = search2(arr,target);
		System.out.println(searchIndex);
	}


	/**
	 * search for the last key = target
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int search3(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		int count =0;
		while(left <= right) {
			mid = (left + right) / 2;
			System.out.println((++count) + "===>" + left + "|" + right + "|" + mid);
			if(target < arr[mid]) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		if(arr[right] == target) {
			return right;
		}

		return -1;
	}
	@Test
	public void testSearch3() {
		int[] arr = {1,1,2,4,5,5,5,6,7,7,8,8,9,9};
		int target = 5;
		int searchIndex = search3(arr,target);
		System.out.println(searchIndex);
	}


	/**
	 * search for the first key > target
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int search4(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		int count = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			System.out.println((++count) + "===>" + left + "|" + right + "|" + mid);
			if(arr[mid] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

//		if(left < arr.length && arr[left] > target) {
//			return  left;
//		}

		return left < arr.length? left : -1;
	}
	@Test
	public void testSearch4() {
		int[] arr = {1,1,2,4,5,5,5,6,7,7,8,8,9,9};
		int target = 10;
		int searchIndex = search4(arr,target);
		System.out.println(searchIndex);
	}



}
