package EOLS;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ������
 * 
 * ����ѧ����Ϣ
 * ɾ��ѧ����Ϣ
 * �޸�ѧ����Ϣ
 * ����ѧ�Ų鿴ѧ����Ϣ
 * �鿴�ɼ����а�
 * �鿴����ɼ��ֲ�
 * �˳�ϵͳ
 * @author Mr.Joker
 */
public class Function {
	//����ѧ����Ϣ
	public static void addInfo() {
		Scanner sc = new Scanner(System.in);
		String s = "";
		
		System.out.println("������ѧ�ţ�");
		s += sc.nextLine();
		s += ",";
		System.out.println("������������");
		s += sc.nextLine();
		s += ",";
		System.out.println("���������֤�ţ�");
		s += sc.nextLine();
		s += ",";
		System.out.println("������רҵ��");
		s += sc.nextLine();
		s += ",";
		System.out.println("������༶��");
		s += sc.nextLine();
		s += ",";
		System.out.println("�����뼮�᣺");
		s += sc.nextLine();
		s += ",";
		System.out.println("�������ͥסַ��");
		s += sc.nextLine();
		s += ",";
		System.out.println("������רҵ�ɼ���");
		s += sc.nextDouble();
		s += ";\n";
		
		try {
			IOClass.testBufferedWriter("D:/StudentInfo.txt", s, true);
			System.out.println("ѧ����Ϣ����ӳɹ��������ʹ���������ܣ�");
			Menu.showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ɾ��ѧ����Ϣ
	public static void deleteInfo() {
		System.out.println("�������ɾ����Ϣѧ����ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			list.removeIf(stu -> stu.getId().equals(id));
			
			s = SLConversion.myToString(list);
			IOClass.testBufferedWriter("D:/StudentInfo.txt", s, false);
			System.out.println("ѧ����Ϣ�ѳɹ�ɾ���������ʹ���������ܣ�");
			Menu.showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//�޸�ѧ����Ϣ
	public static void reviseInfo() {
		Scanner sc = new Scanner(System.in);

		System.out.println("��������޸���Ϣѧ����ѧ�ţ�");
		String id = sc.nextLine();
		
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			int i = 0;
			for(Student stu : list) {
				if(stu.getId().equals(id)) {
					break;
				}
				i++;
			}
			if(i == list.size()) {
				System.out.println("δ�ҵ������Ϣ�����������ʹ�ñ����ܣ�");
				Menu.showMenu();
			}else {
				System.out.println("��ѡ���޸ķ�ʽ��1.�����޸ģ�2.ȫ���޸ģ���");
				
				while(true) {
					
					String way = sc.nextLine();
					
					if(way.equals("1")) {
						System.out.println("������Ҫ�޸ĵľ����");
						System.out.println("1.ѧ��");
						System.out.println("2.����");
						System.out.println("3.���֤��");
						System.out.println("4.רҵ");
						System.out.println("5.�༶");
						System.out.println("6.����");
						System.out.println("7.��ͥסַ");	
						System.out.println("8.רҵ�ɼ�");
						
						boolean flag = true;
						while(true) {
							String choose = sc.next();
							
							System.out.println("�������޸ĺ���Ϣ��");
							
							String newinfo = sc.next();
							
							switch(choose) {
							case "1": 
								list.get(i).setId(newinfo);break;
							case "2":
								list.get(i).setName(newinfo);break;
							case "3":
								list.get(i).setIdentity_number(newinfo);break;
							case "4":
								list.get(i).setMajor(newinfo);break;
							case "5":
								list.get(i).setClasss(newinfo);break;
							case "6":
								list.get(i).setHometown(newinfo);break;
							case "7":
								list.get(i).setAddress(newinfo);break;
							case "8":
								list.get(i).setGrade(Double.parseDouble(newinfo));break;
							default:
								System.out.println("��Ч�����룡�����������벢�������룺");flag = false;
							}
							if(flag) {
								break;
							}
						}
						s = SLConversion.myToString(list);
						IOClass.testBufferedWriter("D:/StudentInfo.txt", s, false);
						System.out.println("�޸���ɣ������ʹ���������ܣ�");
						Menu.showMenu();
						break;
					}else if(way.equals("2")) {
						String newinfo = "";
						System.out.println("������ѧ�ţ�");
						newinfo = sc.nextLine();
						list.get(i).setId(newinfo);
						System.out.println("������������");
						newinfo = sc.nextLine();
						list.get(i).setName(newinfo);
						System.out.println("���������֤�ţ�");
						newinfo = sc.nextLine();
						list.get(i).setIdentity_number(newinfo);
						System.out.println("������רҵ��");
						newinfo = sc.nextLine();
						list.get(i).setMajor(newinfo);
						System.out.println("������༶��");
						newinfo = sc.nextLine();
						list.get(i).setClasss(newinfo);
						System.out.println("�����뼮�᣺");
						newinfo = sc.nextLine();
						list.get(i).setHometown(newinfo);
						System.out.println("�������ͥסַ��");
						newinfo = sc.nextLine();
						list.get(i).setAddress(newinfo);
						System.out.println("������רҵ�ɼ���");
						double newinf = sc.nextDouble();
						list.get(i).setGrade(newinf);
						
						s = SLConversion.myToString(list);
						IOClass.testBufferedWriter("D:/StudentInfo.txt", s, false);
						System.out.println("�޸���ɣ������ʹ���������ܣ�");
						Menu.showMenu();
						break;
					}else {
						System.out.println("��Ч�����룡�����������벢�������룺");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//����ѧ�Ų鿴ѧ����Ϣ
	public static void showInfo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��������鿴��Ϣѧ����ѧ�ţ�");
		
		String id = sc.nextLine();
		
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			int i = 0;
			for(Student stu : list) {
				if(stu.getId().equals(id)) {
					break;
				}
				i++;
			}
			if(i == list.size()) {
				System.out.println("δ�ҵ������Ϣ�����������ʹ�ñ����ܣ�");
				Menu.showMenu();
			}else {
				System.out.println("��ѡ��鿴��ʽ��1.�鿴���2.�鿴ȫ������");
				
				while(true) {
					String way = sc.nextLine();
					
					if(way.equals("1")) {
						System.out.println("������Ҫ�鿴�ľ����");
						System.out.println("1.ѧ��");
						System.out.println("2.����");
						System.out.println("3.���֤��");
						System.out.println("4.רҵ");
						System.out.println("5.�༶");
						System.out.println("6.����");
						System.out.println("7.��ͥסַ");	
						System.out.println("8.רҵ�ɼ�");
						
						boolean flag = true;
						while(true) {
							
							String choose = sc.nextLine();
							
							switch(choose) {
							case "1": 
								System.out.println("ѧ�ţ�" + list.get(i).getId());break;
							case "2":
								System.out.println("������" + list.get(i).getName());break;
							case "3":
								System.out.println("���֤�ţ�" + list.get(i).getIdentity_number());break;
							case "4":
								System.out.println("רҵ��" + list.get(i).getMajor());break;
							case "5":
								System.out.println("�༶��" + list.get(i).getClasss());break;
							case "6":
								System.out.println("���᣺" + list.get(i).getHometown());break;
							case "7":
								System.out.println("��ͥסַ��" + list.get(i).getAddress());break;
							case "8":
								System.out.println("רҵ�ɼ���" + list.get(i).getGrade());break;
							default:
								System.out.println("��Ч�����룡�����������벢�������룺");flag = false;
							}
							if(flag) {
								Menu.showMenu();
								break;
							}
						}
						break;
					}else if(way.equals("2")) {
						System.out.println("ѧ�ţ�" + list.get(i).getId());
						System.out.println("������" + list.get(i).getName());
						System.out.println("���֤�ţ�" + list.get(i).getIdentity_number());
						System.out.println("רҵ��" + list.get(i).getMajor());
						System.out.println("�༶��" + list.get(i).getClasss());
						System.out.println("���᣺" + list.get(i).getHometown());
						System.out.println("��ͥסַ��" + list.get(i).getAddress());
						System.out.println("רҵ�ɼ���" + list.get(i).getGrade());
						
						Menu.showMenu();
						break;
					}else {
						System.out.println("��Ч�����룡�����������벢�������룺");
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//�鿴�ɼ����а�
	public static void gradeRangking() {
		Map<Double, String> map = new TreeMap<Double, String>();
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			//����TreeMap����Ȼ����Գɼ���������
			for(Student stu : list) {
				map.put(stu.getGrade(), stu.getName());
			}
			
			System.out.println("�ɼ�����Ϊ��");
			//��map���򣬴ﵽ���������Ŀ��
			map = ((TreeMap<Double,String>) map).descendingMap();
			int i = 0;
			for(Double key : map.keySet()) {
				++i;
				System.out.println(i + "." + map.get(key) + " " + key);
			}
			System.out.println("");
			Menu.showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�鿴����ɼ��ֲ�
	public static void gradeDistribution() {
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			int grade_a = 0;	//�ɼ���90-100��ѧ������
			int grade_b = 0;	//�ɼ���80-89��ѧ������
			int grade_c = 0;	//�ɼ���70-79��ѧ������
			int grade_d = 0;	//�ɼ���60-69��ѧ������
			int grade_e = 0;	//�ɼ���0-59��ѧ������
			
			for(Student stu : list) {
				if(stu.getGrade() >= 90 && stu.getGrade() <= 100) {
					grade_a++;
				}else if(stu.getGrade() >= 80 && stu.getGrade() <= 89) {
					grade_b++;
				}else if(stu.getGrade() >= 70 && stu.getGrade() <= 79) {
					grade_c++;
				}else if(stu.getGrade() >= 60 && stu.getGrade() <= 69) {
					grade_d++;
				}else {
					grade_e++;
				}
			}
			
			System.out.println("�ɼ���90-100��ѧ������Ϊ" + grade_a);
			System.out.println("�ɼ���80-89��ѧ������Ϊ" + grade_b);
			System.out.println("�ɼ���70-79��ѧ������Ϊ" + grade_c);
			System.out.println("�ɼ���60-69��ѧ������Ϊ" + grade_d);
			System.out.println("�ɼ���0-59��ѧ������Ϊ" + grade_e);
			System.out.println();
			Menu.showMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
