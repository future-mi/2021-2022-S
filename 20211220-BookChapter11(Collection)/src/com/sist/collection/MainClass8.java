package com.sist.collection;

import java.util.*;
// Set���
public class MainClass8 {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add("���");
		list.add("�׼�");
		list.add("��Ÿ��");
		list.add("�ڹ�");
		list.add("���");
		list.add("�׼�");
		list.add("���");
		// �迭�� ������ ���

		// List �� ������ �ߺ� ���
		System.out.println("======list�� ����======");
	//	System.out.println(list.toString());
		Iterator it=list.iterator();	//list�� �������ִ� ������ ����
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// �ߺ�����
		HashSet set=new HashSet();
		
		for(Object genre:list)
		{
			set.add(genre); // HashSet�� �����͸� ÷�Ρ� �ߺ�����
		}
		System.out.println("=====set�� ����� ������ ���=====");
	//	System.out.println(set.toString());
		it=set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// ArrayList �� �����ϱ� ����
		// ������ �����͸� �ѹ� �����ش�
//		list.clear();
		for(Object genre:set)
		{
			list.add(genre);
		}
		System.out.println("====�ߺ��� ������ ������ ���====");
	//	System.out.println(list.toString());
		it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		// list.toString() �� ������...
		/*
		 * for(Object obj:list)
		 * while(it.hasNext())
		 * {
		 *	 System.out.println(it.next());
		 * }
		 * list�� �����͸� ��Ƽ� �������� ���� 
		 */
	}
	
}
