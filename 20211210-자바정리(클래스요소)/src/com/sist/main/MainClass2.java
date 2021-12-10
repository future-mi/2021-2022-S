package com.sist.main;

class Swap
{
	// Call By Value → 일반데이터형(int,long,double,boolean...)
	// 특이 → String
	public void callByValue(int x,int y) 
// public void callByValue(int a,int b)로 놓고 비교
	{
		System.out.println("a="+x+",b="+y);
		// a와 b값을 변경
		/*
		 * a=10, b=20
		 * a=b → a=20
		 * b=a → b=20
		 */
		int tmp=x; 	// 임시변수
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
		System.out.println("===========Swap을 호출후===========");
		Swap s=new Swap();
		s.callByValue(a, b);
		System.out.println("호출후: a="+a+",b="+b);
	}
}
 