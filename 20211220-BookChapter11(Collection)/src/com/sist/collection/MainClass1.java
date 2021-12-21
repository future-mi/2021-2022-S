package com.sist.collection;
/*
 * Collection : �����ͱ׷�(�����͸� ��Ƽ� ����)
 * 	- CollectoionFramework : ǥ��ȭ
 *  - �������� ���� �з� : List(���帹�̻��), Set, Map
 *  	
 *  			 Collection
 *  				  |
 *  		-----------------------
 *			|		  |			  |  
 * 		 1.List	     Set		 Map �� �������̽�
 *		�� ������ ������ ����(�ε��� ���� ����)
 *		�� �ߺ������͸� ���
 *		�� ���̺귯������ �����ϴ� ���(CURD)
 *		1)�߰� : add(Object) �� � ���������̵� ������� �߰�
 *			�� �����Ͱ� ���������� ÷���ϸ� �����ϱ� �����(�ݺ������� �����)
 *			�� ���� �������� ó��(String,Integer,��������� Ŭ����)
 *			�� ������ ���� ���� ����
 *		2)���� : remove(int index)
 *		3)���� : set(int index, Object o)
 *		4)�б� : get(int index)
 *		5)���尹�� : size()
 *		6)���������� : isEmpty() (boolean)
 *		7)��ü���� : clear()
 *          |
 *  1)ArrayList : ���帹�̻�� �� �����ͺ��̽� ����
 *     				- �񵿱��� / vector�� ������ Ŭ����
 *  2)Vector : ��Ʈ��ũ ���α׷�
 *     				- ���(����) �� ������(�����,��Ÿ���̼�)
 *     				- ������ ����(�ǽð�)
 *     				- �����ͼ���
 *    	(1)�߰� : add(Object), addElement(Object) 
 *		(2)���� : remove(int index), removeElementAt(int index)
 *		(3)���� : set(int index)
 *		(4)����Ȯ�� : size
 *		(5)�б� : get(int index), elementAt(int index)
 *		(6)��ü���� : clear()    
 *  3)LinkedList : C��� ȣȯ
 *     	(1)�߰� : add(Object) 
 *		(2)���� : remove(int index)
 *		(3)���� : set(int index)
 *		(4)����Ȯ�� : size
 *		(5)�б� : get(int index) 
 *     		| 	 
 * 		  Queue
 * 	- ���� : offer, �б� : poll
 * 		  Stack
 *  - ���� : push, �б� : pop
 * 
 * 2. Set : ������ ����, ������ �ߺ��� ������� �ʴ´�
 * 	- Interator : �����͸� ��Ƽ� ����
 * 	- HashSet, TreeSet(����)
 * 
 * 3. Map : Ű�� ���� ���ÿ� ����
 * 			Ű�� �ߺ����� ������, ���� �ߺ��� ���
 * 	- ������,���̹�Ƽ��,JSP�� ���尴ü
 * 	- ������ : Ŭ���� ���,Ŭ���� ������ ���
 * 	- ���̹�Ƽ�� : �����ͺ��̽��� ���� �� Ű,SQL
 * 
 */
// 584page
import java.util.*;

public class MainClass1 {
	public static void main(String[] args) {
		// Collection
		// 1. �޸� �Ҵ�(������ �� �ִ� ���� Ȯ��)
	//	ArrayList list=new ArrayList();
	//	Vector list=new Vector();
		LinkedList list=new LinkedList();
		
		// 2. ����������
		list.add("���");
		list.add("����");
		list.add("�ٳ���");
		list.add("��");
		list.add("����");
		
		// 3. Ȯ��
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 4. ���
		// 5. ����
		list.set(4, "������");
		
		System.out.println("\n====���� �� ���====");
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 6. ���
		// 7. ����
		list.remove(2);
		System.out.println("\n=====���� �� ���=====");
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 8. ���
		for(Object obj:list)
		{
			System.out.print(obj+" ");
		}
		// 9. ��ü����
		list.clear();
		// 10. ���
		if(list.isEmpty())
		{
			System.out.println("\n�ٱ��Ͽ� ������ �����ϴ�");
		}
	}
}







