package EOLS;

import java.util.ArrayList;
import java.util.List;


/**
 * List String转化类
 * 
 * toList()将接收到的字符串实例化成Student对象并存入列表中
 * myToString()将接收到的列表字符串化
 * @author Mr.Joker
 */
public class SLConversion {
	/**
	 * 将接收到的字符串实例化成Student对象并存入列表中
	 * @param s
	 * @return
	 */
	public static List<Student> toList(String s) {
		
		List<Student> stulist = new ArrayList<Student>();
		
		String[] str = s.split(";");
		for(int i = 0; i < str.length; i++) {
			
			String[] strs = str[i].split(",");
			
			Student stu = new Student();
			stu.setId(strs[0]);
			stu.setName(strs[1]);
			stu.setIdentity_number(strs[2]);
			stu.setMajor(strs[3]);
			stu.setClasss(strs[4]);
			stu.setHometown(strs[5]);
			stu.setAddress(strs[6]);
			stu.setGrade(Double.parseDouble(strs[7]));
			stulist.add(stu);
		}

		return stulist;
	}
	
	/**
	 * 将接收到的列表字符串化
	 * @param list
	 * @return
	 */
	public static String myToString(List<Student> list) {
		String s = "";
		
		for(Student stu : list) {
			s += stu.getId() + ",";
			s += stu.getName() + ",";
			s += stu.getIdentity_number() + ",";
			s += stu.getMajor() + ",";
			s += stu.getClasss() + ",";
			s += stu.getHometown() + ",";
			s += stu.getAddress() + ",";
			s += stu.getGrade();
			s += ";\n";
		}
		
		return s;
	}
}
