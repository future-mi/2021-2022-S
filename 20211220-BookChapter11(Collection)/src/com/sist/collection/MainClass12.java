package com.sist.collection;
/*
 * TreeSet �� ���ڿ�����(�ߺ��� �����ʹ� ������ �ȵȴ�) 
 */
import java.util.*;
public class MainClass12 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		String[] names= {"ȫ�浿","��û��","������","�ڹ���","�̼���",
						"�����","������","��������","������","����"};
		// �迭�� TreeSet���� ����
		for(Object name:names)
		{
			set.add(name);
		}
		System.out.println("====TreeSet�� �����Ͱ� �߰��� ����====");
		System.out.println(set.toString());
		System.out.println("ù��° ������: "+set.first());
		System.out.println("������ ������: "+set.last());
		System.out.println(set.headSet("��"));	// "��"�� ������
		System.out.println(set.tailSet("��")); 	// "��"�� ����
 		
	}
}
