package com.sist.lib;
/*
 * 	�ڹٸ� �� �Ϸ���
 * 	1. ���� (1~8�� : ����, �迭, Ŭ����, ������, ���, �޼ҵ�)
 * 	2. �뵵 
 * 		- Ŭ����(�������̽�,�޼ҵ�(������,�Ű�����)
 * 			�� ����ó��(try~catch, throws)
 * 		- �޼ҵ�
 * 		- ����(�ν��Ͻ�,static)
 * 		
 * 	3. �����ϴ� ���(����� ���� Ŭ����+���̺귯��)
 * 	4. ����(�˰���)
 * 		- �ҽ��� �ϱ� �� ����
 * 		- �ڹٿ��� ���� ���� ���α׷�(��Ʈ��ũ/�����ͺ��̽�) �� ��� �����ڰ� �����ϰ� �ڵ�
 * 		- ������(2�� for) / ������(1�� for)
 * 		- �ݺ� / ��ġȮ�� / CV �� �м�
 * ==================================================================
 * 	java.lang  java.util java.io  java.net  java.sql  java.text
 * 	java.xml	org.w3c.dom		org.w3c.sax		javax.http(JSP)
 * 
 * 	1.java.lang : import�� ���� �� �� �ִ�
 * 		1)Object : ��� Ŭ����(���������,���̺귯��)�� ����� ������ Ŭ����
 * 			Class A(extends Object) ������ �ȴ�
 * 			- toString(��ü�� ���ڿ�ȭ)
 * 			- finalize() : �Ҹ��� �޼ҵ�(��ü�� �޸𸮿��� ����, �ڵ�ȣ��Ǵ� �޼ҵ�)
 * 			- clone() : ���� �� ������(prototype)
 * 		2)String / StringBuffer /StringBuilder
 * 			���̺귯�� : ����, �뵵�� ����ϰ� ����ϱ�
 * 			(1) String(���ڿ��� �����ϴ� �޼ҵ�)
 *	 			- length() : ���ڰ��� ��  ...
 *							 �� ���� : public int length()
 *				- equals() : ���ڿ� ��(==�� ������� ����) / �α���, id�ߺ�üũ�� ��� / ��ҹ��� ����
 *							 �� ���� : public boolean equals(String s)
 *				- equalsIngnoreCase() : ���ڿ� �� / ��ҹ��� ���о��� / �˻��� �� ���
 *							 �� ���� : public boolean equalsIngnoreCase(String s)
 * 				- substring() : ���ϴ� �κи� ���ڿ��� �ڸ��� ����
 * 							 �� ���� : public String substring(int start)
 * 									 public String substring(int start,int end)
 *  			- trim() : �¿� ������ ������ �� ���
 *  						�� ����ڰ� �Ǽ��� space�� ������� �� ���ʿ� ������ ���ܼ� ã�Ⱑ ���� �� ���
 *  						�� ���� : public String trim() �� ���鹮�� ���� �� �ٽ� ����
 *				- indexOf : ���ڸ� ã��(�տ�������)
 *							�� ���� : public int indexOf(String s)
 *									public int indexOF(char c) 
 *				- lastIndexOf : ���ڸ� ã��(�ڿ�������)
 *								�� ���� : public int lastIndeOf(Sting s)
 *										public int lastIndexOf(char c)
 *				- split() : ���ڿ��� �и�
 *							�� ���� : public String[] split(String regex)
 *				- replace() : ���� �� ���� ����
 *							�� ���� : public String replace(char c1,char c2)
 *									public String replace(String s1,String s2)
 *				- replaceAll() : ���� ��ü�� ����(���Խ��� ���)
 *								�� ���� : public String replaceAll(String s1,String s2)
 *										�ѱ� [��-�R]
 *										���� [A-Zz-z]
 *										���� [0-9]
 *				- charAt() : ���ڿ� �߿� ���� �Ѱ��� �ڸ��� ���
 *							�� ���� : public char charAt(int index)
 * =============================================================
 *				- startsWith : ���۹��ڿ��� �ٲ� �� 
 *								�� ���� : public boolean statWith(String s)
 *				- endsWith : ������ ���ڿ��� �ٲ� �� 
 *							�� ���� : public boolean endsWith(Sting s)
 *					�� �ڵ��ϼ���(������Ʈ) �� �˻��⸦ ���鶧 ���, Cookie����
 * =============================================================
 * 				- toUpperCase : �빮�� ��ȯ
 * 								�� ���� : public String toUpperCase()
 * 				- toLowerCase : �ҹ��� ��ȯ
 * 								�� ���� : public String toLowerCase()
 * 				- valueOf() : ��� ���������� ���ڿ��� ��ȯ
 * 							�� ���� : public static String valueOf(int a)
 * 									public static String valueOf(boolean a)
 * 									public static String valueOf(char a) ..... ��
 * 
 * 		3)Math
 * 			- ceil : �ø�
 * 			- ramdom : ����
 * 		4)Wrapper : ��� ���������� Ŭ����ȭ
 * 			- byte �� Byte
 * 			- short �� Short
 * 			- int �� Integer
 * 			- double �� Double
 * 			- float �� Float
 * 			- boolean �� Boolean
 * 		5)System
 *			- System.in
 *			- System.out
 *			- System.gc() �� ��Ƽ�̵��, ȭ�� ���� ����� �� / �ڵ����� �޸� ȸ�� 
 */
class Sawon
{
	private String name;
	public Sawon(String name)
	{
		//������ �� ������ �ʱ�ȭ
		System.out.println("Sawon ��ü �޸𸮿� ����");
		this.name=name;
	}
	// ���
	public void print()
	{
		// ��ü ��� Ȱ��
		System.out.println("�̸�:"+name);
	}
	
	// �޸𸮿� ����
	// ��ü�� �޸𸮿��� ����� �� �ڵ�ȣ�� �Ǵ� �޼ҵ�(�Ҹ���)
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("Sawon ��ü �޸� ����");
	}
	
	@Override
	public String toString() {
		return "Sawon�� �������ִ� �̸��� "+name+"�Դϴ�";
	}
	// Object������ ������(�������̵�) �� toString
}

public class MainClass {
	public static void main(String[] args) {
		// ��� ��� ���
		// 1. �޸� ����
		Sawon s=new Sawon("ȫ�浿");
		System.out.println(s.toString());
		// 2. Ȱ��
		s.print();
		// 3. �޸� ���� s=null(GC)
		s=null; // �� �̻� ������� �ʴ´� 
		// 4. ��������
		System.gc(); // �������÷��� ȣ��(�޸𸮿��� ������� �ʰų�, null�ϋ� ȸ��)
		// finalize()�� ȣ��Ǹ� �޸𸮿��� ����
	
	}
	
}
