package EOLS;

/**
 * 菜单类
 * 
 * showMenu()显示菜单
 * @author Mr.Joker
 */
public class Menu {
	/**
	 * 显示菜单
	 */
	public static void showMenu() {
		System.out.println("1：增加学生信息");
		System.out.println("2：删除学生信息");
		System.out.println("3：修改学生信息");
		System.out.println("4：根据学号查看学生信息");
		System.out.println("5：查看成绩排行榜");
		System.out.println("6：查看整体成绩分布");
		System.out.println("0：退出系统");
		System.out.println("请回复序号使用相应功能：");
	}
}
