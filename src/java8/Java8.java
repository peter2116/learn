package java8;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;
import static pub.PubUtil.log;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/9/13
 * @Description:
 * @modifier
 */
public class Java8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {

			String cmd = scan.nextLine();

			switch (cmd) {
				case "0" :
					exit(0);
					break;
				case "1" :
					lambdaMethod();
					break;
				case "2" :
					break;
				case "3" :
					break;
				case "4" :
					break;
				case "5" :
					break;
				default:
					exit(0);
			}
		}

	}

	//1 lambda
	public static void lambdaMethod() {

		Arrays.asList("a","b","c").forEach( (e) -> System.out.println(""));

		String sep = ",";
		Arrays.asList("a","b","c").forEach(e ->
				log(e + sep));

		Arrays.asList(1,2,4).forEach((Integer i) -> log(i));

		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );



	}

}
