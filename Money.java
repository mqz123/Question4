package task;
import task.Data;

public class Money {

	public static void payOff(String day,String month) {
		//�����Ա����Ϣ
		System.out.println("Ա����");
		for(String key:Data.money.keySet()) {
			//�ҳ�Ա�������Ա����Ϣ
			if(Data.money.get(key) > 1000 && Data.money.get(key) <10000) {
				System.out.println("����:"+key+"  ����:"+
						Data.money.get(key));
				for(String key1:Data.birthday.keySet()) {
					//���Ա���������վ͸�Ա��������
					if(Data.birthday.get(key1).equals(month)&&(key.equals(key1)))
						System.out.println("***��"+key1+"������***");
				}
			}
		}
		
		//�����������Ϣ
		System.out.println("����");
		//�ҳ�������Ϣ�����㽱�������������Ϣ
		for(String key:Data.money.keySet()) {
			if(Data.money.get(key) >= 10000) {
				System.out.println("����:"+key+"  ����:"+
					Data.money.get(key)+"  ����"+(int)(5000*Math.random()));
				for(String key1:Data.birthday.keySet()) {
					//������������վ͸���������
					if(Data.birthday.get(key1).equals(month)&&(key.equals(key1)))
						System.out.println("***��"+key1+"������***");
				}
			}
		}
	}
	//�������ɶ���Ϣ
	public static void receDivi(String month) {
		int sum = 0;
		//����Ա���;�����ܹ���
		for(String key:Data.money.keySet()) {
			if(Data.money.get(key) > 100) {
				sum += Data.money.get(key);
			}
		}
		//������Ӫҵ��
		double turnover = Math.random()*50*sum;
		System.out.println("�ɶ���");
		//�ҳ��ɶ�������ֺ�������ɶ���Ϣ
		for(String key:Data.money.keySet()) {
			if(Data.money.get(key) >= 1 && Data.money.get(key) <= 100) {
				System.out.println("������"+key+"  �ɷݣ�"
						+Data.money.get(key)+"  �ֺ�:"
						+(int)(turnover*0.1*Data.money.get(key)*0.01));
			}
		}
	}
}
