package com.sist.main;
// 사용자정의 예외처리(자바에서 지원하지 않는 예외가 발생시에 직접 만들어서 처리)
// 439page(사용빈도는 거의 없음)
class MyException extends Exception
{
	public MyException(String msg)
	{
		super(msg);	//Exception클래스의 생성자
		// this → MyException클래스의 객체 
	}
}
/*
 * 		class A
 * 		{
 * 		}
 * 
 * 		1. 클래스 저장 - A a=new A();  // 리플렉션 Class.forName();
 * 					→ JVM → this=a; → 객체저장 주소를 기억하고 있음
 *		2. 상속 (속도가 저하 → JOIN(Subquery) → 최적화
 *			메모리할당 → 상속 내리는 클래스 메모리 할당
 *					  상속 받는 클래스 메모리 할당 
 * 		
 */
public class MainClass5 {
	public static void main(String[] args) {
		// 사용자정의 예외처리는 자동으로 찾을 수 없다(직접호출)
		// 이미 자바에 지정된 예외처리만 자동 호출이 가능
/*
 *		1. 생성자 호출 : new 생성자()
 *		2. 예외처리 호출 : throw new 생성자() → 예외던지기(예외처리를 찾는다)
 *
 *		break, continue, return, throw 밑에는 소스코딩이 불가능
 */
		try
		{
			int a=11;
			if(a%2==0)
			{
				throw new MyException("짝수입니다");
				// throw 밑에는 소스코딩을 할 수 없다.(위는 상관없음)
			}
			else
			{
				throw new MyException("홀수입니다");
			}
		} catch (MyException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
