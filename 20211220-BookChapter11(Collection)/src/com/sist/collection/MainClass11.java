package com.sist.collection;
// TreeSet �� headSet(������), tailSet(ū��) 
/*
 * 1)add : �߰�
 * 2)remove : ����
 * 3)clear : ��ü����
 * 4)isEmpty : ����������
 * 5)first : ���� ������
 * 6)last : ���� ������
 * 7)headSet : ~���� ������
 * 8)tailSet : ~���� ������
 * 
 */
import java.util.*;
public class MainClass11 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		int[] score=new int[10];
		// �迭�ʱ�ȭ
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			score[i]=r.nextInt(101);
		}
		System.out.println(Arrays.toString(score));
		
		// ������ 60�̻��� �����͸� ���
		System.out.println("====60�̻� ������ ���====");
		for(int jumsu:score)
		{
			if(jumsu>=60)
			{
				System.out.println(jumsu);
			}
		}
		
		System.out.println("====60�̸� ������ ���====");
		for(int jumsu:score)
		{
			if(jumsu<60)
			{
				System.out.println(jumsu);
			}
		}
		
		// TreeSet�� ������ ÷��
		System.out.println("=====TreeSet�� ������ ÷��=====");
		for(int jumsu:score)
		{
			set.add(jumsu);
		}
		System.out.println(set.toString());
		
		System.out.println("====TreeSet�� 50���� ū��====");
		System.out.println(set.tailSet(50));
		
		System.out.println("====TreeSet�� 50���� ������====");
		System.out.println(set.headSet(50));
		
		
	}
}
