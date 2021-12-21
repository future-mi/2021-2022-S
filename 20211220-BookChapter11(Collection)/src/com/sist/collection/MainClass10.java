package com.sist.collection;
// Set �� TreeSet
import java.util.*;
/*
 * ArrayList,HashSet,HashMap �� ��
 */
public class MainClass10 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		//������ �߰�
		set.add(80);
		set.add(100);
		set.add(70);
		set.add(85);
		set.add(99);
		set.add(83);
		set.add(87);
		set.add(92);

		System.out.println("���� ���� ����: ");
		int min=100;	// ���� ������ �� ���ؼ� ����
		for(Object score:set)
		{
			int a=(int)score;
			if(min>a)
			{
				a=min;
			}
		}
		System.out.println(min);
		System.out.println("���� ���� ��: "+set.first());
		System.out.println("���� ���� ����: ");
		int max=70;	// ���� ������ �� ���ؼ� ����
		for(Object score:set)
		{
			int a=(int)score;
			if(max<a)
			{
				a=max;
			}
		}
		System.out.println(max);
		System.out.println("���� ���� ��: "+set.last());
		System.out.println(set.lower(90));   //90���� ���� ������ �ִ� ���� ����
		System.out.println(set.higher(90));  //90���� ���� ������ �ִ� ���� ����
		System.out.println(set.floor(98));	 //98�̰ų� �ٷ� �Ʒ�
		System.out.println(set.ceiling(98)); //98�̰ų� �ٷ� ��
		// �������� : DESC
		NavigableSet d=set.descendingSet();
		System.out.println(d.toString()); // [100, 99, 92, 87, 85, 83, 80, 70]
		//�ø����� : ASC
		NavigableSet a=d.descendingSet();
		System.out.println(a.toString()); // [70, 80, 83, 85, 87, 92, 99, 100]
		// ~ORDER BY no DESC|ASC
	}
}



