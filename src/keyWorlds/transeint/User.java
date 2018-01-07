package keyWorlds.transeint;

import java.io.*;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/11/27
 * @Description:
 * @modifier
 */
public class User implements Serializable{

	private String userName;


	/**
	 * 	transient 修饰后不会被序列化
	 * 	transient关键字只能伴随Serializable使用，虽然Externalizable对象中使用transient关键字也不报错，但不起任何作用
	 * 	Externalizable通过writeExternal方法中进行手工指定所要序列化的变量
	 */
	transient private String pwd;

	private String address;

	//一个静态变量不管是否被transient修饰，均不能被序列化。
	static public String tag = "tag";


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObj();

		readObj();
	}

	public static void writeObj() throws IOException {
		User user = new User();
		user.setAddress("inspur");
		user.setUserName("peter");
		user.setPwd("123");
		user.setTag("dep");

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt"));
		out.writeObject(user);
		out.flush();
		out.close();
	}

	public static void readObj() throws IOException, ClassNotFoundException {
		User.tag = "changeStaticTag";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.txt"));
		User user1 = (User)in.readObject();
		System.out.println(user1.toString());
	}

	@Override
	public String toString() {
		return "\nuserName:" + userName
				+ "\npwd:" + pwd
				+ "\naddress:" + address
				+ "\ntag:" + tag;
	}


}
