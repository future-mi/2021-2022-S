package com.sist.main;
/*
 * 	page 20
 * 	변수 → 한개의 데이트를 메모리 공간
 * 	변수 / 상수
 * 	변수 : 변해서 사용
 * 	상수 : 변경 할 수 없는 값
 * 
 * 	int a=10; 변수
 * 	final int A=10; 상수 → 약속(상수는 대문자)
 * 	======================================  26page
 * 		- 클래스명 첫자 대문자
 * 		- 메소드, 변수는 소문자
 * 		- 상수 모두 대문자
 * 		- 두개의 단어 → 시작하는 단어에 대문자
 * 		  fileName ,  FileName
 * 		  file_name
 * 	======================================
 * 	값을 대입
 * 	int a=10; 10을 a에 대입
 * 	변수가 여러개일때
 * 	int a;
 * 	int b;
 *  int c;
 *  → int a,b,c;
 *  
 *  int a=10;
 *  int b=20;
 *  int c=30;
 * 	→ int a=10,b=20.c=30;
 * 
 * ==========================================================
 * [2장]
 * 	25page 식별자(구분)
 * 	1. 알파벳으로 시작(대소문 구분), 한굴(권장x) → window/linux
 * 		→ AWS(운영체제) → linux
 * 	2. 숫자사용이 가능(앞에 사용X)
 * 	3. 특수문자 사용이 가능( _ , $) → _
 *  4. 키워드는 사용 금지(색상이 빨강색)
 * 
 * 	27page(기본데이터형,참조데이터(클래스,배열))
 * 	28page(기본형) → 도표 → 29page 크기
 *	32page(접미어) : L(1) → long, F(f) → float
 *	
 *	57page(\t, \n, \", \\(경로명))   System.out.println("\"홍길동\""); 이렇게 해야 "홍길동"이 출력
 * 	82-83page(형변환)
 * 	 String  7+""+10.5+""+'A' == "710.5A"
 * 	 byte < char < int < long < float < double < String
 * =========================================================
 * 
 * [3장]
 * 	87page(연산자의 종류)
 * 	 - type → 형변환
 * 	 - ? :  → 삼항연산자
 * 	 - instanceof → 객체크기비교
 * 
 * 	Object obj=new Object();
 * 	String s=new String();
 * 	StringBuffer sb=new StringBuffer();
 * 
 * 	if(s instanceof Object) → is-a(true)
 *  if(obj instanceof String) → false
 *  if(sb instanceof Object) → true
 *  if(obj instanceof StringBuffer) → false
 *  if(s instanceof StringBuffer) → 오류
 *  
 *  *** Object : 모든 클래스의 상위 클래스(모든 데이터형을 받을 수 있다)
 * 		Object a=10
 * 		Object a=10.5
 * 		Object a=10.5f
 * 		Object a='A'
 * 		Object a=new MainClass4()
 * 
 * 	92page(연산처리시 형변환) 
 * 		- int이하(char,byte,short) → 연산결과가 int로 나옴
 * 	93page
 * 		- 증감연산자
 * 		- 전치연산자 : 먼저 증가 후에 다른 연산 수행(++a)
 * 		- 후치연산자 : 다른 연산을 수행 나중에 증가(a++)
 * 	97page
 * 		- 산술연산자 : / → 정수/정수=정수, 0으로 나눌 수 없음
 * 				    % → 결과는 왼쪽편 부호를 따라감
 * 	109page
 * 		- 비교연산자 (==, !=, <, >, <=, >=) → true/false
 * 	114page
 * 		- 논리연산자(&&:직렬, ||:병렬)
 * 		→ 118page 효율적인 연산 / false && / true &&
 * 	130page
 * 		- 삼항연산자 : (조건)?값1:값2
 * 					조건이 true=값1
 * 					조건이 false=값2
 *  133page → =, +=, -= (여러개를 동시에 증가할 때)
 *  		  i++ → 1증가
 *  		  ++i → 1증가
 *  		 i+=2 → 2증가  → i=i+2
 *  		 i+=5 → 5증가  → i=i+5
 *  =========================================================
 * [4장]
 * 	1.제어문
 * 	2.조건문 - 136page if
 * 		   - 140page if ~ else
 * 		   - 141page if ~ else if ~ else 
 * 	3.반복문 - 157page for
 * 		   - 166page for-each
 * 		   - 167page while
 * 	4.break
 * =========================================================
 * [5장] 배열
 * 	182~183page(초기값,선언방법) - 1차배열
 * 
 * =========================================================
 * [6장~8장] 
 * 
 * 
 * 
 */
public class MainClass4 {
	public static void main(String[] args) {
		int a=10;
		int b=9;
		if(a<b && ++b==a)
		{
			System.out.println("처리완료");
		}
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
