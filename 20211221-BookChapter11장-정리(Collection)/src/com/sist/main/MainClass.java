package com.sist.main;
/*
 * ����(����),������, ���, �迭(1��) �� ���α׷� �� ���� 
 * 
 * [��ü����]
 * 	- ĸ��ȭ(����� ���� ��������)
 * 		�� ����������(priavte(����ȭ) < default < protected < public(���))
 * 		�� ��� : �޼ҵ�(Ŭ������ Ŭ������ ���(����) �� �޼ҵ�)
 *  - ��� / ����(���̵���)
 *  	�� ��� : �������� : static, ������, ����� ����� ������� ���Ѵ�(private)
 *  - �������̵�(������)
 * ������ : �ٸ�Ŭ������ ������ ���� ����� ����(�⺻����)
 * HTML/CSS : ����� ���� �� ȭ�� ������
 * JavaScript : �޴�Ŭ���� �̹���ȸ��...(�̺�Ʈ)/������������ ����
 * Java : �����Ͱ��� �� AI,ê��,�����ͺм�
 * ����Ŭ : �����͸� ������ ���(������ ����) 
 * 
 ** �ڹ� 
 *	- Ŭ������ �����ؼ� Ŭ������ ������
 *		�� ��ü�������α׷�(6~7��)
 *		�� Ŭ������ �����ϱ����ؼ� �ܵ����� ���,��� ��� ����(�������̽�)
 *	- �������� �޼ҵ�(X), Ŭ���� ���ο� �۾�
 *	- ����(�����͸� ���� �� �����ؼ� ���)
 *	- ����� ��û�� ���ؼ� ���� �� �޼ҵ�
 *	- ������ ������ ����(��� ���� �� Collection)
 *	- ������ ���¼� �м� �� ���̺귯��(������,�ڸ��...)
 *  - ����� ��û ���� �� ������̼�
 *	- �ʿ��ϸ� �ܺο��� �����͸� ������ �ͼ� ���Ͽ� ���� �� IO
 *	- ����� ��û�� ���� ���Ͼ��ε�, ���� �ٿ�ε� �� IO
 *	- �ٽ� : �����ͺ��̽�(����Ŭ �� ����) 
 *
 *	- 10�� : Date, Calendar, SimpleDateFormat
 *	- 11�� : ArrayList, HashSet, HashMap
 *	- 12�� : ���״н�, ������̼�
 *	- 15�� : File
 */
import java.util.*;
interface A
{
	public void display();
	public default void aaa()
	{
		
	}
}
// B < A
class B implements A
{
	public void display()
	{
		
	}
}
// C < A
class C implements A
{
	public void display()
	{
		
	}
}
// D < A
class D implements A
{
	public void display()
	{
		
	}
}

public class MainClass {
	public static void main(String[] args) {
		// 1. ArrayList �����
		// 1-1. ������� ����
		ArrayList list=new ArrayList();	// ���׸��� �ʼ�
		
		// 1-2. ������÷��
		list.add("���");	 	//index=0
		list.add("������");	//index=1
		list.add("����");		//index=2
		
		// 1-3. ��û �� ����
		// 1-3-1. ���(������ �����ֱ�)
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.println(f);
		}
		// 1-4 ������ �����
		System.out.println("====������====");
		list.remove(1);
		for(Object obj:list)
		{
			System.out.println(obj);	// toString�� ����
			/*
			 * valueOf() �� int,double �� ���ڿ� ����
			 */
			
		}
		System.out.println("====������ ���====");
		list.forEach(obj-> System.out.println(obj)); //���ٽ� / {}����
		// JavaScript �� ȭ��ǥ �Լ�(ES6)
		
		System.out.println("====��ü����====");
		list.clear();
		if(list.isEmpty())	// �����Ͱ� ���ٸ�
		{
			System.out.println("�����Ͱ� �����ϴ�.");	// ã��
		}
		// 2. HashSet �����
		System.out.println("====HashSet====");
		// 2-1. ������� ���� �� �ߺ����� �����Ͱ� ���� �߰��� �ȵ�
		HashSet set=new HashSet();
		// 2-2.������ �߰�
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		// 2-3. �����͸� ���
		//for-each
		System.out.println("====for-each���====");
		for(Object obj:set)
		{
			System.out.println(obj);
		}
		
		//Iterator
		System.out.println("====Iterator���====");
		Iterator it=set.iterator();	// �����͸� ������ �����ϰ� it�� ����
		while(it.hasNext()) //���� ������ ������ �ִ� �ͱ����� �ݺ��� ����
		{
			// it.next() �� ���� ���ٵ� ���� �о�´�
			int value=(int)it.next();
			// �⺻������������ Ŭ�������� �޴´� : ��ڽ�
			// Integer i=(Interger)it.net()
			System.out.println(value);
		}
		System.out.println("====����====");
		set.remove(2);
		set.forEach((obj)->System.out.println(obj));
		System.out.println(set.toString());
		
		System.out.println("====��ü����====");
		set.clear();
		if(set.isEmpty())
		{
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�");
		}
		System.out.println("====HashSet �ַ��ϴ� ����====");
		ArrayList list2=new ArrayList();
		list2.add("ȫ�浿");
		list2.add("��û��");
		list2.add("�ڹ���");
		list2.add("ȫ�浿");
		list2.add("�ڹ���");
		// ���
		for(Object obj:list2)
		{
			System.out.println(obj);
		}
		//�ߺ�����
		System.out.println("====List �� Set ====");
		HashSet set2=new HashSet();
		set2.addAll(list2); 	// list2�� �ִ� ��� �����͸� set2�� �̵�
		for(Object obj:set2)
		{
			System.out.println(obj);
		}
		
		list2.clear();		// List,Set �����Ҷ� �� �ѹ��� ��ü���� �� �߰�
		list2.addAll(set2);
		for(Object obj:list2)
		{
			System.out.println(obj);
		}
		// Set �� �ַ� ��ٱ��� �� �� ���
		// 3. HashMap ����� �� Ŭ��������
		// 3-1. ����
		System.out.println("====HashMap====");
		HashMap map=new HashMap();
		// 3-2. ������ �߰� �� ���� �ΰ�(Ű,��)
		map.put("a", "ȫ�浿");
		map.put("b", "��û��");
		map.put("c", "������");
		map.put("dd", "�ڹ���");
		map.put("e", "�̼���");
		
//		System.out.println(map.get("b"));
		System.out.println("==��ü������ ���==");
		
/*
		for(char c='a';c<='e';c++)
		{
			String name=(String)map.get(String.valueOf(c));
			System.out.println(name);
		}
*/
		Set s=map.keySet();	// map�� ����Ǿ��ִ� Ű ��ü�� �о�´�
		Iterator i=s.iterator();
		while(i.hasNext())
		{
			String key=(String)i.next();
			String name=(String)map.get(key);
			System.out.println(name);
		}
		System.out.println("====����====");
		map.remove("dd");	// Ű����
		map.forEach((key,value)->System.out.println(value));
		
		System.out.println("====��ü����====");
		map.clear();
		if(map.isEmpty())
		{
			System.out.println("�����Ͱ� �����ϴ�");
		}
	}
}
