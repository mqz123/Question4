package task;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Data {
	//创建HashMap存储<姓名，工资>
	public static HashMap<String,Integer> money = new HashMap<>();
	//创建HashMap存储<姓名，生日的月份>
	public static HashMap<String,String> birthday = new HashMap<>();
	
	//读入存有员工信息的文本
	public String readFromFile(String filename) {
		 BufferedInputStream bufferedInput = null;
		 byte[] buffer = new byte[1024];
		 try {
			 //创建BufferedInputStream对象
			 bufferedInput = new BufferedInputStream(
					 new FileInputStream(filename));
			 int bytesRead = 0;
			 
			 //从文本中按字节读取内容，到文件尾部时read方法返回-1
			 while((bytesRead = bufferedInput.read(buffer))!=-1) {
				 //将读取的字节转为字符串对象
				 String chunk = new String(buffer,0,bytesRead);
				 return chunk;
			 }
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch(IOException e){
			 e.printStackTrace();
		 }finally {
			 //关闭BufferedInputStream
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
	
	//对文本中的数据进行操作
	public void operateFile(String file) {
		int a = file.indexOf("员工"); //找到"员工"在文本中第一次出现的位置
		int b = file.indexOf("经理"); //找到"经理"在文本中第一次出现的位置
		int c = file.indexOf("股东"); //找到"股东"在文本中第一次出现的位置
		int d = file.length();
		String staff = file.substring(a, b-2);   //将员工信息单独划分出来
		String manager = file.substring(b, c-2); //将经理信息单独划分出来
		String partner = file.substring(c, d-2); //将股东信息单独划分出来
		operateDate(staff);
		operateDate(manager);
		operateDate(partner);
	}
	
	//对单独划分出的字符串进行操作
	public static void operateDate(String string) {
		int a = string.indexOf(" ");    //找到字符串中第一个空格的位置
		int b = string.indexOf(" ",a+1);//找到字符串中第二个空格的位置
		int length0 = string.length();  //字符串的长度
		
		//当不是最后一个员工的时候
		while(b != -1) {
			String string0 = string.substring(a, b); //将每一个员工的信息单独划分出来
			int length = string0.length();   //每一个员工信息字符串的长度
			int c = string0.indexOf(",");    //每一个员工信息中第一个","出现的位置
			int d = string0.indexOf(",",c+1);//每一个员工信息中第二个","出现的位置
			String string1 = string0.substring(1, c);  //员工信息中的姓名
			String string2 = string0.substring(c+1, d);//员工信息中的工资
			Integer number = Integer.parseInt(string2);//将工资字符串转化为整形
			String string3 = string0.substring(d+1, length); //员工信息中的生日月份
			money.put(string1, number);     //将<姓名，工资>放到money中
			birthday.put(string1, string3); //将<姓名，月份>放到birthday中
			//查找下一个员工信息的位置
			a = b;
			b = string.indexOf(" ",a+1);
		}
		//对最后一个员工信息进行划分和存储
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
