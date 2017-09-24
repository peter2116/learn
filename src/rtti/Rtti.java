package rtti;

import static pub.PubUtil.log;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/9/7
 * @Description:
 * @modifier
 */



class candy{
	static {
		log("loadin ... candy ...");
	}
}

class Gum{

	public static String ACC = "aaa";

	static {
		log("static area in Gum");
	}
}

class Cookie {
	static {
		log("load --- cookie -- ");
	}
}

public class Rtti {

	public static void main(String[] args) {

		log("in --- main -- ");

		new candy();

		log("after --- load candy");

		String acc = Gum.ACC;

		log("after --- load Gum");

		try {
			Class.forName("rtti.Cookie");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}




