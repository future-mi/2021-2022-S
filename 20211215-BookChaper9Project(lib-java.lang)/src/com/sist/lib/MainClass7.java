package com.sist.lib;
/*
 * ��ȯ
 *	�� toUpperCase() : �ҹ��� �� �빮�ڷ� ��ȯ 
 *	�� toLowerCase() : �빮�� �� �ҹ��ڷ� ��ȯ
 * 
 * 
 * 
 */
import java.util.*;

public class MainClass7 {
	public static void main(String[] args) {
		// ���� (����Ŭ�� ����� ������ �� ��ҹ��ڸ� ����)
		// Admin �� Admin,ADMIN,admin
		
		// 1.�Է�(���ĺ�) �� ��ҹ����Է�
		Scanner scan=new Scanner(System.in);
		System.out.println("���ĺ��Է�: ");
		String s=scan.nextLine();
				
		/*
		 *  nextLine() : ������ �����Ͽ� �Ѱ��� ������ �б� / admin 1234 �� �Ѱ��� ������
		 *  next() : ������ ������ �ٸ� ���ڿ� / admin 1234 �� �ΰ��� ������
		 */
		System.out.println("����������: "+s);
		// 2. �Էµ� ���ĺ��� �빮�ڷ� ����
		System.out.println("��ü�빮��: "+s.toUpperCase());
		// 3. �Էµ� ���ĺ��� �ҹ��ڷ� ����
		System.out.println("��ü�ҹ���: "+s.toLowerCase());
		
		
		
	}
}
