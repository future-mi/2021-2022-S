package com.sist.lib;
/*
 * 	라이브러리(자바에서 지원, 외부업체지원) → 웹에서 사용되는 라이브러리
 * 	1. 자바 지원 
 * 		1) java.lang : 자바 코딩이 되는 라이브러리 → import를 생략할 수 있다
 * 			(1) Object : 모든 클래스에 상속을 내림(최상위 클래스)
 * 				- toString() → 문자열 변환
 * 				- clone() → 객체 메모리 복제(새로운 메모리가 생성)
 * 				- finalize() → 객체 소멸시 자동으로 호출되는 메소드
 * 								가비지 컬렉션(프로그램이 종료시 메모리 제거) 
 * 									- 객체가 null, 힙에저장된 메모리, new, 지역변수,매개변수 → 메모리 자체 관리(스텍)
 * 
 * 			(2) String
 * 			(3) StringBuffer
 * 			(4) StringBuilder
 * 			(5) Math 
 * 			(6) Wrapper(전체 기본 데이터형 → 클래스)   
 * 			(7) System
 * 
 * 		2) java.util
 * 		3) java.io
 *		4) java.text
 *		5) java.net		→ 자바로 시작하는 패키지(JDK1.0)
 *		6) javax.xml
 *		7) javax.http
 * 	2. 외부업체지원(open source) 
 * 		1) 맵(MAP)
 * 		2) 크롤링
 * 		3) 데이터베이스연결
 * 		4) 스프링
 */

// toString() → 호출 → 객체를 출력 → toString을 호출한다
class Card
{
	String kind;
	int num;
	// 초기화 → {}초기화 블록, 생성자()
	
	public Card() // 디폴트 생성자
	{
		kind="★";
		num=1;
	}
	// 오버로딩 : 중복 메소드 정의
	public Card(String kind,int num)
	{
		this.kind=kind;
		this.num=num;
	}
	// Object가 가지고있는 메소드를 재정의(오버라이딩:메소드 정의를 변경)
	public String toString()
	{
		return kind+":"+num;
	}
}

public class MainClass {
	public static void main(String[] args) {
		
		Card c1=new Card();
/*
  		kind="★";
		num=1;		
 */
		Card c2=new Card("♠",2);
/*
  		kind="♠";
  		num=2;
 */
		//출력
		System.out.println(c1);		//c1.toString()
		System.out.println(c2);		//c2.toString()
		
		//기타
		Class c3=c1.getClass();
		System.out.println(c3);
		try
		{
		Class c4=Class.forName("com.sist.lib.Card");
		System.out.println(c4);
		}catch(ClassNotFoundException ex) {}
	}
}
