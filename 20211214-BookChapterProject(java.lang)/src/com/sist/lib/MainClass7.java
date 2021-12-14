package com.sist.lib;
/*
 * startWith, endWith �� ã�� ���ڿ��� �����ϴ� ���ڿ����� �����¹��ڿ�����
 * 
 * Java & Spring
 * �ڹٿ� JSP
 * �ڹٿ� ����Ŭ
 * 
 * ���� : public boolean startsWith(String s)
 * 		public boolean endsWith(String s)
 * 
 * 
 */
import java.util.*;
public class MainClass7 {
	public static void main(String[] args) {
		String[] data= {
				"ȥ�ڹ��� �ڹ�",
				"�ڹٿ� ����Ŭ",
				"�ڹٱ���� AWS",
				"����Ŭ ���α׷��� ����",
				"�ڹ����α׷���",
				"JSP AND MVC",
				"Spring Framework",
				"MyBatis���α׷���",
				"�ڹٸ� �̿��� ê��",
				"AWS�� �̿��� ����",
		};
		/*
		 * [�˻��뵵]
		 * ���� ���ڿ� - startsWith
		 * ������ ���ڿ� - endsWith
		 * ���Ե� ���ڿ� - comtains
		 */
		// 2.����� �Է�
		Scanner scan=new Scanner(System.in);
		System.out.println("�˻��� �Է�:");
		String fd=scan.next();
		// 3.�ش繮�ڿ����� ã�Ƽ� ���
		for(String s:data)
		{
			if(s.contains(fd)) 	
			{
				try
				{
					Thread.sleep(1000);
				}catch(Exception ex){}
				System.out.println(s);

			}
		}
	}
}

/*	�ڹ�
 * 	����Ŭ
 * 	HTML/CSS
 *  JavaScript(JQuery,AJAX)
 *  JSP(MVX)
 *	Spring
 *	========================
 *	MyBatis
 *	ReactJS
 *	VueJS
 *	ChatBot
 *	========================
 *	AWS
 *	========================
 *	�ڹ������� 1��(��ü������+8��)
 *	�ڹ������� 2�� - �÷���,���׸���, 10��-SimpleDateFormat
 *			  	11��, 12��
 *				IO(FileReader, FileWriter, BufferReader)
 *
 */

