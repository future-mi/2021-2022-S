package com.sist.lib;
/*
 * 	���̺귯��(�ڹٿ��� ����, �ܺξ�ü����) �� ������ ���Ǵ� ���̺귯��
 * 	1. �ڹ� ���� 
 * 		1) java.lang : �ڹ� �ڵ��� �Ǵ� ���̺귯�� �� import�� ������ �� �ִ�
 * 			(1) Object : ��� Ŭ������ ����� ����(�ֻ��� Ŭ����)
 * 				- toString() �� ���ڿ� ��ȯ
 * 				- clone() �� ��ü �޸� ����(���ο� �޸𸮰� ����)
 * 				- finalize() �� ��ü �Ҹ�� �ڵ����� ȣ��Ǵ� �޼ҵ�
 * 								������ �÷���(���α׷��� ����� �޸� ����) 
 * 									- ��ü�� null, ��������� �޸�, new, ��������,�Ű����� �� �޸� ��ü ����(����)
 * 
 * 			(2) String
 * 			(3) StringBuffer
 * 			(4) StringBuilder
 * 			(5) Math 
 * 			(6) Wrapper(��ü �⺻ �������� �� Ŭ����)   
 * 			(7) System
 * 
 * 		2) java.util
 * 		3) java.io
 *		4) java.text
 *		5) java.net		�� �ڹٷ� �����ϴ� ��Ű��(JDK1.0)
 *		6) javax.xml
 *		7) javax.http
 * 	2. �ܺξ�ü����(open source) 
 * 		1) ��(MAP)
 * 		2) ũ�Ѹ�
 * 		3) �����ͺ��̽�����
 * 		4) ������
 */

// toString() �� ȣ�� �� ��ü�� ��� �� toString�� ȣ���Ѵ�
class Card
{
	String kind;
	int num;
	// �ʱ�ȭ �� {}�ʱ�ȭ ���, ������()
	
	public Card() // ����Ʈ ������
	{
		kind="��";
		num=1;
	}
	// �����ε� : �ߺ� �޼ҵ� ����
	public Card(String kind,int num)
	{
		this.kind=kind;
		this.num=num;
	}
	// Object�� �������ִ� �޼ҵ带 ������(�������̵�:�޼ҵ� ���Ǹ� ����)
	public String toString()
	{
		return kind+":"+num;
	}
}

public class MainClass {
	public static void main(String[] args) {
		
		Card c1=new Card();
/*
  		kind="��";
		num=1;		
 */
		Card c2=new Card("��",2);
/*
  		kind="��";
  		num=2;
 */
		//���
		System.out.println(c1);		//c1.toString()
		System.out.println(c2);		//c2.toString()
		
		//��Ÿ
		Class c3=c1.getClass();
		System.out.println(c3);
		try
		{
		Class c4=Class.forName("com.sist.lib.Card");
		System.out.println(c4);
		}catch(ClassNotFoundException ex) {}
	}
}
