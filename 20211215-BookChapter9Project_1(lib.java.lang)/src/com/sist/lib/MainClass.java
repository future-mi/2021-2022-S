package com.sist.lib;

import javax.swing.border.MatteBorder;

/*
 * Math �� ���а���
 * 
 * 1. ���� : random()
 * 		 ����) public static double random();
 * 2. �ø� : ceil()
 * 		�� ceil(17/5.0) �� 3.4 �� 4 �� ��������
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		int count=103;	// �� ��������
		int total=103/15;
		if(total%15>0)
		{
			total++;
		}
		System.out.println("��������: "+total);
		
		System.out.println("=====lib�̿�=====");
		int total2=(int)Math.ceil(count/15.0);
		System.out.println("��������: "+total2);
		// �ڹ� �� CBD(�̹� ������� ���̺귯���� ����)
		// ��� �� �˻�(���۸�..)
	}
}
