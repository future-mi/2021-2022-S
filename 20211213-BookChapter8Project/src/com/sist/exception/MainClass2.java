package com.sist.exception;

public class MainClass2 {
//	String s;
	public static void main(String[] args) {
		System.out.println("1");
		System.out.println("2");
		
		try
		{
//			s.replace("a","b");  �� �����ϰ� �ּҰ��� ����
			System.out.println("3");
			System.out.println(10/0);
			System.out.println("5");
		}
		catch(ArrayIndexOutOfBoundsException e) // �迭�����ʰ�
		{
			System.out.println("6");
		}
		catch(ArithmeticException e) 			// 0���� ������ ��  
		{
			System.out.println("7");
		}
		catch(NullPointerException e)			// �ּҰ��� ���� ���  ex) A a;    a.name=""; �� �̷���찡 �ּҰ��� ���°�
		{
			System.out.println("8");
		}
		catch(ClassCastException e)				// ����ȯ�� Ʋ�� ��� ex) class A �� ��ǻ�� / class B �� ����� / A a=new A(); / B b=new B();
		{
			System.out.println("9");
		}
		finally 								// ��������
		{
			System.out.println("10");
		}
		System.out.println("11");
	}
	
	/*
	 * ������ ������ �׳� �� ���� catch����
	 * ������ ������ �ش翡�� catch��ȣ�� ���� ���� 10,11�� ������ �� 
	 */
}
