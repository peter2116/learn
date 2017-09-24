package java7;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static pub.PubUtil.log;

/**
 * @author chen_wj
 * @Description:
 * @date 2017/9/12
 * @Description:
 * @modifier
 */
public class Java7 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {

			log("input the cmd number to excute the certernly method: \n");

			String cmd = scan.nextLine();

			switch (cmd) {
				case "0" :
					exit(0);
					break;
				case "1" :
					number_new();
					break;
				case "2" :
					colectionSup();
					break;
				case "3" :
					releaseResource();
					break;
				case "4" :
					betterPath();
					break;
				case "5" :
					fileAround();
					break;
				default:
					exit(0);
			}
		}

	}


	//1
	public static void number_new() {

		int one_million = 1_000_000;

		int binary = 0b1001_1001;

		byte b = (byte)binary;
		short s = (short)binary;

		System.out.println(b + " | " + s);


	}


	//2 集合语言支持
	public static void colectionSup() {

//		List<String> list = ["item"];
//		String item = list[0];
//
//		Set<String> set = {"item"};
//
//		Map<String, Integer> map = {"key" : 1};
//		int value = map["key"];
	}

	//3 自动资源管理
	public static void releaseResource(){

		try (FileOutputStream fos = new FileOutputStream("movies.txt");

			 DataOutputStream dos = new DataOutputStream(fos)) {

			dos.writeUTF("Java 7 Block Buster");
			log("releaseResource---in");

		} catch (IOException e) {
			log("releaseResource---" + e.getMessage());
		}
	}

	//4 文件管理增强
	public static void betterPath(){

		Path path = Paths.get("/Users/peter/Desktop");

		System.out.println("Number of Nodes:" + path.getNameCount());

		System.out.println("File Name:" + path.getFileName());

		System.out.println("File Root:" + path.getRoot());

		System.out.println("File Parent:" + path.getParent());

		try {
			Files.deleteIfExists(Paths.get("/Users/peter/Desktop/0912mrtdm.log"));
		} catch (IOException e) {
			log("betterPath----" + e.getMessage());
		}

	}


	//5 文件改变事件通知 不大好用
	public static void fileAround() {

		//init
		Path path = Paths.get("/Users/peter/Desktop/重庆搬家");

		WatchService watchService = null;
		try{
			 watchService = FileSystems.getDefault().newWatchService();
			 path.register(watchService,ENTRY_CREATE, ENTRY_DELETE,ENTRY_MODIFY);
		}
		catch (IOException e) {
			log("fileAround1---" + e.getMessage());
			throw new RuntimeException(e);
		}

		//doAround
		WatchKey key = null;
		while(true) {

			try{

				key = watchService.take();

				for(WatchEvent event : key.pollEvents()) {
					WatchEvent.Kind kind = event.kind();
					log("Event on " + event.context().toString() + " is " + kind);
				}

			}
			catch (InterruptedException e) {
				log("fileAround2---InterruptedException---" + e.getMessage());
			}

		}

	}

}
