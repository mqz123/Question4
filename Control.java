package task;
import java.util.Scanner;

import task.Data;
import task.Money;

public class Control {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new Data().operateFile(new Data().readFromFile("myFile.txt"));
		System.out.print("���������ڣ�");
		String day = sc.next();
		if(!day.equals("15��")) {
			System.out.println("��û�������ʵ�ʱ�䣡");
			return;
		}
		System.out.print("�������·ݣ�");
		String month = sc.next();
		Money.payOff(day,month);
		
		if(!month.equals("12��")) {
			System.out.println("��û���ɶ��ֺ�ʱ��");
			return;
		}
		Money.receDivi(month);
		
	}

}
