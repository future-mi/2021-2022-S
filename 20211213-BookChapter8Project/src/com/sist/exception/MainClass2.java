package com.sist.exception;

public class MainClass2 {
//	String s;
	public static void main(String[] args) {
		System.out.println("1");
		System.out.println("2");
		
		try
		{
//			s.replace("a","b");  → 선언만하고 주소값이 없음
			System.out.println("3");
			System.out.println(10/0);
			System.out.println("5");
		}
		catch(ArrayIndexOutOfBoundsException e) // 배열범위초과
		{
			System.out.println("6");
		}
		catch(ArithmeticException e) 			// 0으로 나눴을 때  
		{
			System.out.println("7");
		}
		catch(NullPointerException e)			// 주소값이 없는 경우  ex) A a;    a.name=""; → 이런경우가 주소값이 없는것
		{
			System.out.println("8");
		}
		catch(ClassCastException e)				// 형변환이 틀린 경우 ex) class A → 컴퓨터 / class B → 냉장고 / A a=new A(); / B b=new B();
		{
			System.out.println("9");
		}
		finally 								// 생략가능
		{
			System.out.println("10");
		}
		System.out.println("11");
	}
	
	/*
	 * 에러가 없으며 그냥 쭉 수행 catch제외
	 * 에러가 있으면 해당에러 catch번호가 들어가고 수행 10,11은 무조건 들어감 
	 */
}
