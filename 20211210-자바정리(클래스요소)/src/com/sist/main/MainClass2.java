package com.sist.main;

class Swap
{
	// Call By Value �� �Ϲݵ�������(int,long,double,boolean...)
	// Ư�� �� String
	public void callByValue(int x,int y) 
// public void callByValue(int a,int b)�� ���� ��
	{
		System.out.println("a="+x+",b="+y);
		// a�� b���� ����
		/*
		 * a=10, b=20
		 * a=b �� a=20
		 * b=a �� b=20
		 */
		int tmp=x; 	// �ӽú���
		x=y;
		y=tmp;
		System.out.println("x="+x+",y="+y);
	}
}

public class MainClass2 {
	public static void main(String[] args) {
		int a=100;
		int b=200;
		System.out.println("a="+a+",b="+b);
		System.out.println("===========Swap�� ȣ����===========");
		Swap s=new Swap();
		s.callByValue(a, b);
		System.out.println("ȣ����: a="+a+",b="+b);
	}
}
 