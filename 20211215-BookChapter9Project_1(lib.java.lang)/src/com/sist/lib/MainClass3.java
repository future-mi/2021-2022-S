package com.sist.lib;

import java.util.*;
public class MainClass3 {
	public static void main(String[] args) {
		
		String[] data= {"����","����","��"};
		//1.��ǻ��
		int com=(int)(Math.random()*3);
		//2.������Է�
		Scanner scan=new Scanner(System.in);
		System.out.println("0.���� 1.���� 2.��");
		int user=scan.nextInt();
		
		System.out.println("��ǻ��: "+data[com]);
		System.out.println("�����: "+data[user]);
		System.out.println("====���====");
		
		// 3.������
		switch(user-com)
		{
			case -1:
				System.out.println("��ǻ�ͤ���");
				break;
			case -2: case 1:
				System.out.println("player ��");
				break;
			case 0:
				System.out.println("����");
		}
		
	}
}
