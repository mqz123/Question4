package task;
import task.Data;

public class Money {

	public static void payOff(String day,String month) {
		//先输出员工信息
		System.out.println("员工：");
		for(String key:Data.money.keySet()) {
			//找出员工且输出员工信息
			if(Data.money.get(key) > 1000 && Data.money.get(key) <10000) {
				System.out.println("姓名:"+key+"  工资:"+
						Data.money.get(key));
				for(String key1:Data.birthday.keySet()) {
					//如果员工当月生日就给员工发礼物
					if(Data.birthday.get(key1).equals(month)&&(key.equals(key1)))
						System.out.println("***给"+key1+"发礼物***");
				}
			}
		}
		
		//后输出经理信息
		System.out.println("经理：");
		//找出经理信息，计算奖金且输出经理信息
		for(String key:Data.money.keySet()) {
			if(Data.money.get(key) >= 10000) {
				System.out.println("姓名:"+key+"  工资:"+
					Data.money.get(key)+"  奖金："+(int)(5000*Math.random()));
				for(String key1:Data.birthday.keySet()) {
					//如果经理当月生日就给经理发礼物
					if(Data.birthday.get(key1).equals(month)&&(key.equals(key1)))
						System.out.println("***给"+key1+"发礼物***");
				}
			}
		}
	}
	//最后输出股东信息
	public static void receDivi(String month) {
		int sum = 0;
		//计算员工和经理的总工资
		for(String key:Data.money.keySet()) {
			if(Data.money.get(key) > 100) {
				sum += Data.money.get(key);
			}
		}
		//计算总营业额
		double turnover = Math.random()*50*sum;
		System.out.println("股东：");
		//找出股东，计算分红且输出股东信息
		for(String key:Data.money.keySet()) {
			if(Data.money.get(key) >= 1 && Data.money.get(key) <= 100) {
				System.out.println("姓名："+key+"  股份："
						+Data.money.get(key)+"  分红:"
						+(int)(turnover*0.1*Data.money.get(key)*0.01));
			}
		}
	}
}
