package com.sist.collection;
/*
 * Vector : ArrayList�� ������ ���� ���� ���� �÷��� 
 * 			�����带 �̿��ؼ� ������ ����(����)
 * 			��Ʈ��ũ ������ ����� ������ ����(ip,port)
 * 			List �������̽��� ���� / �޼ҵ�� ArrayList�� ����
 * 		(1)�߰� : add(Object), addElement(Object) 
 *		(2)���� : remove(int index), removeElementAt(int index)
 *		(3)���� : set(int index)
 *		(4)����Ȯ�� : size()
 *		(5)�б� : get(int index), elementAt(int index)
 *		(6)��ü���� : clear()
 *		(7)����������Ȯ�� : isEmpty()  
 * 
 */
import java.util.*;
public class MainClass2 {
	public static void main(String[] args) {
	// ������� ����(�ڷᱸ�� �� �޸𸮿� �����͸� �����ϰ� ����)
	// Stack(LIFO) / Queue(FIFO)�� ������ - ����	
	// �� index=0,    �� index=langth-1
	Vector vec=new Vector();
	// Vector waitVc=new Vector();	// ����
	// Vector roomVc=new Vector();	// ������
	// Vector userVc=new Vector();	// ��ȿ����� ���
	
		// ������ �߰�
		vec.add("ȫ�浿");
		vec.addElement("��û��");
		vec.add("�ڹ���");
		vec.addElement("�̼���");
		vec.add("������");
	
		// �߰��� ������ ���
		System.out.println("����� �� ����: "+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			//Object elementAt(int index), get(int index)
			System.out.println(i+". "+name);
		}
		System.out.println("=====���� ��=====");
		vec.removeElementAt(0); //vec.remoive(1)
		System.out.println("����� �ο���: "+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			System.out.println(i+". "+name);
		}
		System.out.println("=====������=====");
		vec.set(3, "��������");
		System.out.println("����� �ο���: "+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			System.out.println(i+". "+name);
		}
		System.out.println("====��ü����====");
		vec.clear();
		System.out.println("����� �ο���:"+vec.size());
		if(vec.isEmpty())
		{
			System.out.println("����� �ο��� �����ϴ�!!");
		}
	}
}
