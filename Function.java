package EOLS;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 功能类
 * 
 * 增加学生信息
 * 删除学生信息
 * 修改学生信息
 * 根据学号查看学生信息
 * 查看成绩排行榜
 * 查看整体成绩分布
 * 退出系统
 * @author Mr.Joker
 */
public class Function {
	//增加学生信息
	public static void addInfo() {
		Scanner sc = new Scanner(System.in);
		String s = "";
		
		System.out.println("请输入学号：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入姓名：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入身份证号：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入专业：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入班级：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入籍贯：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入家庭住址：");
		s += sc.nextLine();
		s += ",";
		System.out.println("请输入专业成绩：");
		s += sc.nextDouble();
		s += ";\n";
		
		try {
			IOClass.testBufferedWriter("D:/StudentInfo.txt", s, true);
			System.out.println("学生信息已添加成功！请继续使用其他功能：");
			Menu.showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//删除学生信息
	public static void deleteInfo() {
		System.out.println("请输入待删除信息学生的学号：");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			list.removeIf(stu -> stu.getId().equals(id));
			
			s = SLConversion.myToString(list);
			IOClass.testBufferedWriter("D:/StudentInfo.txt", s, false);
			System.out.println("学生信息已成功删除！请继续使用其他功能：");
			Menu.showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//修改学生信息
	public static void reviseInfo() {
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入待修改信息学生的学号：");
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
				System.out.println("未找到相关信息，请检查后重新使用本功能！");
				Menu.showMenu();
			}else {
				System.out.println("请选择修改方式（1.单项修改；2.全部修改）：");
				
				while(true) {
					
					String way = sc.nextLine();
					
					if(way.equals("1")) {
						System.out.println("请输入要修改的具体项：");
						System.out.println("1.学号");
						System.out.println("2.姓名");
						System.out.println("3.身份证号");
						System.out.println("4.专业");
						System.out.println("5.班级");
						System.out.println("6.籍贯");
						System.out.println("7.家庭住址");	
						System.out.println("8.专业成绩");
						
						boolean flag = true;
						while(true) {
							String choose = sc.next();
							
							System.out.println("请输入修改后信息：");
							
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
								System.out.println("无效的输入！请检查您的输入并重新输入：");flag = false;
							}
							if(flag) {
								break;
							}
						}
						s = SLConversion.myToString(list);
						IOClass.testBufferedWriter("D:/StudentInfo.txt", s, false);
						System.out.println("修改完成！请继续使用其他功能：");
						Menu.showMenu();
						break;
					}else if(way.equals("2")) {
						String newinfo = "";
						System.out.println("请输入学号：");
						newinfo = sc.nextLine();
						list.get(i).setId(newinfo);
						System.out.println("请输入姓名：");
						newinfo = sc.nextLine();
						list.get(i).setName(newinfo);
						System.out.println("请输入身份证号：");
						newinfo = sc.nextLine();
						list.get(i).setIdentity_number(newinfo);
						System.out.println("请输入专业：");
						newinfo = sc.nextLine();
						list.get(i).setMajor(newinfo);
						System.out.println("请输入班级：");
						newinfo = sc.nextLine();
						list.get(i).setClasss(newinfo);
						System.out.println("请输入籍贯：");
						newinfo = sc.nextLine();
						list.get(i).setHometown(newinfo);
						System.out.println("请输入家庭住址：");
						newinfo = sc.nextLine();
						list.get(i).setAddress(newinfo);
						System.out.println("请输入专业成绩：");
						double newinf = sc.nextDouble();
						list.get(i).setGrade(newinf);
						
						s = SLConversion.myToString(list);
						IOClass.testBufferedWriter("D:/StudentInfo.txt", s, false);
						System.out.println("修改完成！请继续使用其他功能：");
						Menu.showMenu();
						break;
					}else {
						System.out.println("无效的输入！请检查您的输入并重新输入：");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//根据学号查看学生信息
	public static void showInfo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入待查看信息学生的学号：");
		
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
				System.out.println("未找到相关信息，请检查后重新使用本功能！");
				Menu.showMenu();
			}else {
				System.out.println("请选择查看方式（1.查看单项；2.查看全部）：");
				
				while(true) {
					String way = sc.nextLine();
					
					if(way.equals("1")) {
						System.out.println("请输入要查看的具体项：");
						System.out.println("1.学号");
						System.out.println("2.姓名");
						System.out.println("3.身份证号");
						System.out.println("4.专业");
						System.out.println("5.班级");
						System.out.println("6.籍贯");
						System.out.println("7.家庭住址");	
						System.out.println("8.专业成绩");
						
						boolean flag = true;
						while(true) {
							
							String choose = sc.nextLine();
							
							switch(choose) {
							case "1": 
								System.out.println("学号：" + list.get(i).getId());break;
							case "2":
								System.out.println("姓名：" + list.get(i).getName());break;
							case "3":
								System.out.println("身份证号：" + list.get(i).getIdentity_number());break;
							case "4":
								System.out.println("专业：" + list.get(i).getMajor());break;
							case "5":
								System.out.println("班级：" + list.get(i).getClasss());break;
							case "6":
								System.out.println("籍贯：" + list.get(i).getHometown());break;
							case "7":
								System.out.println("家庭住址：" + list.get(i).getAddress());break;
							case "8":
								System.out.println("专业成绩：" + list.get(i).getGrade());break;
							default:
								System.out.println("无效的输入！请检查您的输入并重新输入：");flag = false;
							}
							if(flag) {
								Menu.showMenu();
								break;
							}
						}
						break;
					}else if(way.equals("2")) {
						System.out.println("学号：" + list.get(i).getId());
						System.out.println("姓名：" + list.get(i).getName());
						System.out.println("身份证号：" + list.get(i).getIdentity_number());
						System.out.println("专业：" + list.get(i).getMajor());
						System.out.println("班级：" + list.get(i).getClasss());
						System.out.println("籍贯：" + list.get(i).getHometown());
						System.out.println("家庭住址：" + list.get(i).getAddress());
						System.out.println("专业成绩：" + list.get(i).getGrade());
						
						Menu.showMenu();
						break;
					}else {
						System.out.println("无效的输入！请检查您的输入并重新输入：");
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//查看成绩排行榜
	public static void gradeRangking() {
		Map<Double, String> map = new TreeMap<Double, String>();
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			//利用TreeMap的自然排序对成绩排序（升序）
			for(Student stu : list) {
				map.put(stu.getGrade(), stu.getName());
			}
			
			System.out.println("成绩排名为：");
			//对map反序，达到降序排序的目的
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
	
	//查看整体成绩分布
	public static void gradeDistribution() {
		try {
			String s = IOClass.testBufferedReader("D:/StudentInfo.txt");
			List<Student> list = SLConversion.toList(s);
			
			int grade_a = 0;	//成绩在90-100的学生人数
			int grade_b = 0;	//成绩在80-89的学生人数
			int grade_c = 0;	//成绩在70-79的学生人数
			int grade_d = 0;	//成绩在60-69的学生人数
			int grade_e = 0;	//成绩在0-59的学生人数
			
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
			
			System.out.println("成绩在90-100的学生人数为" + grade_a);
			System.out.println("成绩在80-89的学生人数为" + grade_b);
			System.out.println("成绩在70-79的学生人数为" + grade_c);
			System.out.println("成绩在60-69的学生人数为" + grade_d);
			System.out.println("成绩在0-59的学生人数为" + grade_e);
			System.out.println();
			Menu.showMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
