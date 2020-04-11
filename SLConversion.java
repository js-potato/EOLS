package EOLS;

import java.util.ArrayList;
import java.util.List;


/**
 * List Stringת����
 * 
 * toList()�����յ����ַ���ʵ������Student���󲢴����б���
 * myToString()�����յ����б��ַ�����
 * @author Mr.Joker
 */
public class SLConversion {
	/**
	 * �����յ����ַ���ʵ������Student���󲢴����б���
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
	 * �����յ����б��ַ�����
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
