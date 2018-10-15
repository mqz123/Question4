package task;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Data {
	//����HashMap�洢<����������>
	public static HashMap<String,Integer> money = new HashMap<>();
	//����HashMap�洢<���������յ��·�>
	public static HashMap<String,String> birthday = new HashMap<>();
	
	//�������Ա����Ϣ���ı�
	public String readFromFile(String filename) {
		 BufferedInputStream bufferedInput = null;
		 byte[] buffer = new byte[1024];
		 try {
			 //����BufferedInputStream����
			 bufferedInput = new BufferedInputStream(
					 new FileInputStream(filename));
			 int bytesRead = 0;
			 
			 //���ı��а��ֽڶ�ȡ���ݣ����ļ�β��ʱread��������-1
			 while((bytesRead = bufferedInput.read(buffer))!=-1) {
				 //����ȡ���ֽ�תΪ�ַ�������
				 String chunk = new String(buffer,0,bytesRead);
				 return chunk;
			 }
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch(IOException e){
			 e.printStackTrace();
		 }finally {
			 //�ر�BufferedInputStream
			 try {
				 if(bufferedInput != null)
					 bufferedInput.close();
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
		 return null;
	}
	
	/**
	 * 
	 * @param file
	 */
	
	//���ı��е����ݽ��в���
	public void operateFile(String file) {
		int a = file.indexOf("Ա��"); //�ҵ�"Ա��"���ı��е�һ�γ��ֵ�λ��
		int b = file.indexOf("����"); //�ҵ�"����"���ı��е�һ�γ��ֵ�λ��
		int c = file.indexOf("�ɶ�"); //�ҵ�"�ɶ�"���ı��е�һ�γ��ֵ�λ��
		int d = file.length();
		String staff = file.substring(a, b-2);   //��Ա����Ϣ�������ֳ���
		String manager = file.substring(b, c-2); //��������Ϣ�������ֳ���
		String partner = file.substring(c, d-2); //���ɶ���Ϣ�������ֳ���
		operateDate(staff);
		operateDate(manager);
		operateDate(partner);
	}
	
	//�Ե������ֳ����ַ������в���
	public static void operateDate(String string) {
		int a = string.indexOf(" ");    //�ҵ��ַ����е�һ���ո��λ��
		int b = string.indexOf(" ",a+1);//�ҵ��ַ����еڶ����ո��λ��
		int length0 = string.length();  //�ַ����ĳ���
		
		//���������һ��Ա����ʱ��
		while(b != -1) {
			String string0 = string.substring(a, b); //��ÿһ��Ա������Ϣ�������ֳ���
			int length = string0.length();   //ÿһ��Ա����Ϣ�ַ����ĳ���
			int c = string0.indexOf(",");    //ÿһ��Ա����Ϣ�е�һ��","���ֵ�λ��
			int d = string0.indexOf(",",c+1);//ÿһ��Ա����Ϣ�еڶ���","���ֵ�λ��
			String string1 = string0.substring(1, c);  //Ա����Ϣ�е�����
			String string2 = string0.substring(c+1, d);//Ա����Ϣ�еĹ���
			Integer number = Integer.parseInt(string2);//�������ַ���ת��Ϊ����
			String string3 = string0.substring(d+1, length); //Ա����Ϣ�е������·�
			money.put(string1, number);     //��<����������>�ŵ�money��
			birthday.put(string1, string3); //��<�������·�>�ŵ�birthday��
			//������һ��Ա����Ϣ��λ��
			a = b;
			b = string.indexOf(" ",a+1);
		}
		//�����һ��Ա����Ϣ���л��ֺʹ洢
		String string0 = string.substring(a,length0);
		int length = string0.length();
		int c = string0.indexOf(",");
		int d = string0.indexOf(",",c+1);
		String string1 = string0.substring(1, c);
		String string2 = string0.substring(c+1, d);
		Integer number = Integer.parseInt(string2);
		String string3 = string0.substring(d+1, length);
		money.put(string1, number);
		birthday.put(string1, string3);
	}

}
