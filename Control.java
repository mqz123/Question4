package task;
import java.util.Scanner;

import task.Data;
import task.Money;

public class Control {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new Data().operateFile(new Data().readFromFile("myFile.txt"));
		System.out.print("请输入日期：");
		String day = sc.next();
		if(!day.equals("15号")) {
			System.out.println("还没到发工资的时间！");
			return;
		}
		System.out.print("请输入月份：");
		String month = sc.next();
		Money.payOff(day,month);
		
		if(!month.equals("12月")) {
			System.out.println("还没到股东分红时间");
			return;
		}
		Money.receDivi(month);
		
	}

}
