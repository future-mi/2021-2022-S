package com.sist.lib;

import java.text.SimpleDateFormat;
/*
 * java.util
 * 1. ��¥����
 * 	- Date(����Ŭ ȣȯ), Calendar(����)
 * 2. ��ȯ����
 *  - ��¥��ȯ 
 *  	- SimpleDateFormat
 *  	- ChoiceFormat
 *  	- MessageFormat(SQL)
 * 3. ������ ����
 * 	- Collection(11��,12��)
 * 
 * 1��~8�� �� �ڹٱ���(�ʼ�)
 */
import java.util.*;

public class MainClass8 {
	public static void main(String[] args) {

		// 1.���ó�¥ Date date=new Date(); // �ý����� ��¥ ����(�ð�)
		// 2.��ȯ(���α׷��� �´� �������� ��ȯ)
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-dd");
//		yyyy : 4�ڸ� �⵵ M : �� d : �� �� dd hh : �ð� mm : �� ss : ��
//		String today=sdf.format(date); // System.out.println(today); StringTokenizer
//		st=new StringTokenizer(today,"-"); String strYear=st.nextToken(); String
//		strMonth=st.nextToken(); String strDay=st.nextToken(); 
//		int year=Integer.parseInt(strYear); int month=Integer.parseInt(strMonth); int
//		day=Integer.parseInt(strDay);
//		System.out.println(strYear+"�⵵ "+strMonth+"��");

		System.out.println();
		Scanner scan=new Scanner(System.in);
		System.out.println("�⵵ �Է�:");
		int year=scan.nextInt();
		System.out.println("�� �Է�:");
		int month=scan.nextInt();
		System.out.println(year+"�� "+month+"��");
		
		// �������
		String[] strWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };
		for (String week : strWeek) {
			System.out.print(week + "\t");
		}
		System.out.println();
		/*
		 * List list=new ArrayList() �� interface Calendar c=�޼ҵ�() �� �߻�Ŭ����
		 */
		// Calendar ����
		Calendar cal = Calendar.getInstance(); // �� calendar ��ü ����
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		// ����
		int week = cal.get(Calendar.DAY_OF_WEEK); // week�� 1~7����(1���� ����)
		// System.out.println(strWeek[week-1]);

		// ��������
		int lastday = cal.getActualMaximum(Calendar.DATE);
		// .getMaximum(Calendar.DATE) �״��� ������ ��¥���ϱ�
		// System.out.println(lastday);

		// �޷����
		week = week - 1;
		System.out.println("\n");
		for (int i = 1; i <= lastday; i++) {
			if (i == 1) {
				for (int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++;
			if (week > 6) {
				week = 0;
				System.out.println("\n");
			}
		}
	}
}
