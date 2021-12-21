package com.sist.main;
/*
 * 670page �� 2���ڹ� �� ����Ŭ����(java.sql) �� ��(javax.http)
 * 
 * Generics
 * 1. ����
 * 	- ��üŸ���� �������� ���̰� ����ȯ�� ������� �ʰ� ����� ���α׷�
 * 	- �������� ����. �ڵ尡 ����������
 * 2. ����
 * 	- Ŭ����<Ŭ������>
 * 		 T : Type       
 * 		 E : Elemenet  
 * 			�� ������ Ŭ������ Object�� ����Ѵ�/��� �޼ҵ��� �����Ͱ� ����ȴ�
 * 		 K : Key
 * 		 V : value
 * 3. ����
 * 		ArrayList<String> �� Object get(int index)
 * 						  �� String get(ing index)
 * 
 * 		void add(Object obj) �� void add(String obj)
 * 
 * class Box<T>
 * {
 * 		T item;
 * 		void setItem(T item)
 * 		{
 * 			this.item=item;
 * 		}
 * 		T getItem()
 * 		{
 * 			return item;
 * 		}
 * }
 * 
 * 		Box<String> box=new Box<String>();
 * 
 * class Box<T> �� ������� ������ Object
 * {
 * 		String item;
 * 		void setItem(T item)
 * 		{
 * 			this.item=item;
 * 		}
 * 		String getItem()
 * 		{
 * 			return item;
 * 		}
 * }
 * 
 *    // ����� ���� ���� �� ����ڰ� ������ ������������ ������ �ȴ�
 * 
 */
import java.util.*;
// ���׸��� �� Collection
class Box<T>
{
	T item;	// static�� �ȵ�! �� ���(�ν��Ͻ�)�θ� ����� ����
	public void setItem(T item)
	{
		this.item=item;
	}
	public T getItem()
	{
		return item;
	}
}
public class MainClass {
	// ���������� ���� �� ����ȯ�� �ʿ����
	public static void main(String[] args) {
		Box box=new Box();
		box.setItem("ȫ�浿");
		String name=(String)box.getItem();
		System.out.println(name);
		
		Box<String> box1=new Box<String>();
		box1.setItem("��û��");
		String name2=box1.getItem();
		System.out.println(name2);
		
	}
}
