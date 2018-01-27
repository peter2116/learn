package concurrent;

import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author chen_wj
 * @Description:
 * @date 2018/1/8
 * @Description:
 * @modifier
 */
public class DelayQueeDemo {


	/**
	 * DelayQuee
	 */
	@Test
	public void testDelayQuee() throws InterruptedException {

		DelayQueue delayQueue = new DelayQueue();

		Delayed e1 = new Delayed() {
			@Override
			public long getDelay(TimeUnit unit) {

				long delayMills = 1000;

				return unit.convert(delayMills , TimeUnit.SECONDS);
			}

			@Override
			public int compareTo(Delayed o) {
				long time = (getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS));
				return (time == 0) ? 0 : ((time < 0) ? -1 : 1);
			}

		};
//		e1.getDelay(TimeUnit.SECONDS);

		delayQueue.add(e1);

		System.out.println("===>" + delayQueue.take());

		TimeUnit.SECONDS.sleep(5);

		System.out.println("end ================== !");
	}

	/***************************************************************************************/

	@Test
	public void testWb() throws InterruptedException {
		try {
			System.out.println("网吧开始营业");
			WangBa siyu = new WangBa();
			Thread shangwang = new Thread(siyu);
			shangwang.start();

			siyu.shangji("路人甲", "123", 1);
			siyu.shangji("路人乙", "234", 2);
			siyu.shangji("路人丙", "345", 1);
		} catch (Exception ex) {

		}

		TimeUnit.SECONDS.sleep(5);
	}


	 class WangBa implements Runnable {

		 private DelayQueue<Wangming> queue = new DelayQueue<Wangming>();
		 public boolean yinye = true;

		 public void shangji(String name, String id, int money) {
			 Wangming man = new Wangming(name, id, 1000 * 60 * money + System.currentTimeMillis());
			 System.out.println("网名" + man.getName() + " 身份证" + man.getId() + "交钱" + money + "块,开始上机...");
			 this.queue.add(man);
		 }

		 public void xiaji(Wangming man) {
			 System.out.println("网名" + man.getName() + " 身份证" + man.getId() + "时间到下机...");
		 }

		 @Override
		 public void run() {
			 // TODO Auto-generated method stub
			 while (yinye) {
				 try {
					 System.out.println("检查ing");
					 Wangming man = queue.take();
					 xiaji(man);
				 } catch (InterruptedException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
				 }
			 }
		 }
	 }

	 class Wangming implements Delayed {

		private String name;
		//身份证
		private String id;
		//截止时间
		private long endTime;

		public Wangming(String name,String id,long endTime){
			this.name=name;
			this.id=id;
			this.endTime=endTime;
		}

		public String getName(){
			return this.name;
		}

		public String getId(){
			return this.id;
		}

		/**
		 * 用来判断是否到了截止时间
		 */
		@Override
		public long getDelay(TimeUnit unit) {
			// TODO Auto-generated method stub
			return endTime-System.currentTimeMillis();
		}

		/**
		 * 相互批较排序用
		 */
		@Override
		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			Wangming jia = (Wangming)o;
			return endTime-jia.endTime>0?1:0;
		}

	}


}
