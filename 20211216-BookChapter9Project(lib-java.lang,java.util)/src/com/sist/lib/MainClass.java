package com.sist.lib;
/*
 * 1. 웹개발자(자바)
 * 	1) 변수,연산자(증감,부정,산술,비교,논리,대입),제어문(if,for,while,break),메소드,클래스,인터페이스
 * 	2) 예외처리(예외복구(try~catch),예외회피(throws)
 * 	3) 라이브러리 
 * 		(1) java.lang
 * 			- String,StringBuffer,Wrapper(데이터형 → 클래스화),Math	
 * 		(2) java.util
 * 			- StringTokenizer, Calendar, Date, List, Map
 * 		(3) java.io
 * 			- FileInputStream, FileOutputStream, BufferReader, File
 * 		(4) java.text
 * 			- SimpleDateFormat
 * 		(5) java.net
 * 			- URL, URLEncoding, Socket, ServerSocket
 * 		(6) java.sql(오라클)
 * 			- Connection, Statement, ResultSet
 * 
 * 2. 디자인패턴
 * 3. 알고리즘
 * 
 * [490page]
 * 레퍼클래스(Wrapper)
 * 	- 일반 데이터형을 클래스화 시켜서 쉽게 제어할 수 있게 만들어 준다
 * 	1. 데이터형 (**는 자주쓰는편)
 * 		1)정수형 
 * 			- byte(1byte) → 네트워크, 파일입출력 / -128~127
 * 			- short(2byte) → c언어 호환 / -32768~32767
 * 			- int(4byte)** → 클래스명 : Integer
 * 			- long(8byte)
 * 		2)문자형(Unicode vs ASC)
 * 			- char(2byte) → 클래스명 : Character
 * 		3)실수형
 * 			- float(4byte) → f(소수점이하 6자리)
 * 			- double(8byte)** → d(생략가능, 소수점이하 15자리)
 * 		4)논리형 
 * 			- boolean(1byte)** → true/false
 * 
 * [오토박싱 & 언박싱]
 * - 오토박싱 
 *	  Integer i=10; → 클래스안에 내가 원하는 값을 집어넣는것
 * - 언박싱
 *    Integer i=new Integer(10);
 * 	  int j=i; 
 * 
 * [Object의 장점]
 * 	- 모든 데이터형을 표현 할 수 있다
 * Object o=10;
 * Object o=10.0
 * Object o="오브젝트"
 * Object o='a'
 * Object o=true
 * Object o=new A()
 * 
 * [웹(문자열) → 원하는 데이터형으로 변경]
 * 	"10", "10.5", "true"
 * 	- 문자열을 정수형으로 변환
 *    int i=Integer.parseInt("10"); 
 *    double d=Double.parseDouble("10.5");
 *    boolean b=Boolean.parseBoolean("true");
 * 
 * 		i=10; / d=10.5; / b=ture;
 * 
 * 	- 문자열로 다시 변환할때는 valueOf 사용
 * 	  String.valueOf(I) → "10"
 * 	  String.valueOf(d) → "10.5"
 * 	  String.valueOf(b) → "true"
 * → String, Object
 * 
 * - 문자열 : String.valueOf() → 모든 데이터형을 문자열로 변환
 * - 일반데이터형 : .parse데이터형() → 문자열을 원하는 데이터형으로 변환
 * 
 */

import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		// 정수 → 문자열(웹)
		// 많이 발생할수 있는 에러 → NumberFormatException
		// 브라우저에서 전송 → list.jsp?page=1 → String page="1";
		Scanner scan=new Scanner(System.in);
		System.out.println("첫번째 문자열 입력: ");
		String num1=scan.next();
		System.out.println("두번째 문자열 입력: ");
		String num2=scan.next();
		
		System.out.println("====더한결과값====");
		
//		System.out.println("num1+num2: "+num1+num2);
//		int i=Integer.parseInt(num1);	
//		int j=Integer.parseInt(num2);
//		System.out.println("====문자열을 정수형으로 변경====");
//		System.out.println(i+j);
		
//		double d1=Double.parseDouble(num1);
//		double d2=Double.parseDouble(num2);
//		System.out.println("====문자열을 실수형으로 변경====");
//		System.out.println(d1+d2);
		
		boolean b1=Boolean.parseBoolean(num1);
		boolean b2=Boolean.parseBoolean(num2);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(b1);
		System.out.println(b2);

	}
}
