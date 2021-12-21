package com.sist.collection;
/*
 * Set, Map
 * [Set]
 *	1.HashSet : ArrayList�� �ִ� ������ �߿��� �ߺ��� ���� �� ����
 * 	2.TreeSet
 * 
 * [Map]
 * 	- Ŭ��������(�����̳�), ���� ��κ��� Ŭ������ Map,
 * 	  ������ ���� Ű�� �� �� Cookie�̿�, session �̿�
 * 	1.HashMap : Hashtable�� ������ ���� 
 *  2.Hashtable 
 *  
 *  �� ��½ÿ� Iterator�� �̿��ؼ� ����ϴ� ���α׷��� ����
 */

/*
 *  [Set �� �������̽�]
 *  �����ϰ��ִ� Ŭ���� : HashSet, TreeSet
 *  	- ������ ���� ������ �ߺ��� ������� �ʴ´�(ID)
 *  	- ������ ���� ������ : ����
 *  1. add(Object)
 *  2. remove(Object)
 *  3. clear()
 *  4. size()
 *  5. isEmpty()
 *  	��� : for-each, iterator�̿��ؼ� ó��
 *  
 */
import java.util.*;
public class MainClass7 {
	public static void main(String[] args) {
		// ���� ������ �����
		HashSet set=new HashSet();	// ������ ����� �ߺ����� �����͸� ����
		set.add("�ڹ�");
		set.add("����Ŭ");
		set.add("HTML5");
		set.add("CSS");
		set.add("JavaScript");
		set.add("JSP");
		set.add("Spring");
		set.add("�ű��:Spring-Boot,VueJs,ReactJs,AI");
		set.add("AWS:����,������");
		set.add("CSS");		// �ߺ��� �����ʹ� �������� ����

		System.out.println("====for-each====");
		for(Object obj:set)
		{
			System.out.println(obj); // obj.toString(); ���� �� toString�� ����
		}
		System.out.println("====������====");
		set.remove("�ڹ�");
		for(Object obj:set)
		{
			System.out.println(obj); 
		}
	}
}











