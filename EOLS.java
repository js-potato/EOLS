package EOLS;

import java.util.Scanner;

/**
 * 主系统类
 * @author Mr.Joker
 *
 */
public class EOLS {
	public static void main(String[] args) {
		System.out.println("欢迎使用在线教学系统，本系统支持如下功能：");
		//显示菜单
		Menu.showMenu();
		
		Scanner sc = new Scanner(System.in);
		
		/**
		 * 根据输入序号进入相应功能
		 * 1：增加学生信息
		 * 2：删除学生信息
		 * 3：修改学生信息
		 * 4：根据学号查看学生信息
		 * 5：查看成绩排行榜
		 * 6：查看整体成绩分布
		 * 0：退出系统
		 */
		while(true) {
			String choose = sc.next();
			switch(choose) {
			
			case "0": 
				System.out.println("已退出，欢迎下次使用！");break;
			case "1":
				Function.addInfo();break;
			case "2":
				Function.deleteInfo();break;
			case "3":
				Function.reviseInfo();break;
			case "4":
				Function.showInfo();break;
			case "5":
				Function.gradeRangking();break;
			case "6":
				Function.gradeDistribution();break;
			default:
				System.out.println("无效的输入！请检查您的输入并重新输入：");break;
			}
			if(choose.equals("0")) {
				break;
			}
		}				
	}
}
