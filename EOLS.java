package EOLS;

import java.util.Scanner;

/**
 * ��ϵͳ��
 * @author Mr.Joker
 *
 */
public class EOLS {
	public static void main(String[] args) {
		System.out.println("��ӭʹ�����߽�ѧϵͳ����ϵͳ֧�����¹��ܣ�");
		//��ʾ�˵�
		Menu.showMenu();
		
		Scanner sc = new Scanner(System.in);
		
		/**
		 * ����������Ž�����Ӧ����
		 * 1������ѧ����Ϣ
		 * 2��ɾ��ѧ����Ϣ
		 * 3���޸�ѧ����Ϣ
		 * 4������ѧ�Ų鿴ѧ����Ϣ
		 * 5���鿴�ɼ����а�
		 * 6���鿴����ɼ��ֲ�
		 * 0���˳�ϵͳ
		 */
		while(true) {
			String choose = sc.next();
			switch(choose) {
			
			case "0": 
				System.out.println("���˳�����ӭ�´�ʹ�ã�");break;
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
				System.out.println("��Ч�����룡�����������벢�������룺");break;
			}
			if(choose.equals("0")) {
				break;
			}
		}				
	}
}
