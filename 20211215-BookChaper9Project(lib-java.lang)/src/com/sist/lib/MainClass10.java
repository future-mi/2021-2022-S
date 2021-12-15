package com.sist.lib;
/*
 * [String(웹에서 자주 사용하는 메소드)]
 * 1.length() : 문자 갯수
 * 2.equals() : 비교(로그인,아이디중복체크)
 * 3.substring() : 원하는 부분의 문자 자르기
 * 4.indexOf(),lastIndexOf() : 위치찾기
 * 5.valueOf() : 웹(문자열) → 다른 데이터형 문자열 변환
 * 6.trim() : 사용자 입력값의 오류방지(공백제거)
 * 7.replace() : 문자변경
 * 8.contains() : 포함 문자열을 찾는경우 
 */

import java.util.StringJoiner;

/*	기타
 *  StringJoiner
 *  Format(MessageFormat,SimpleDateFormat..)
 *  → join(문자열 연결)
 *  
 *  클래스 객체명=new 클래스명();
 *  
 *  List list=new ArrayList() → 인터페이스(List)
 *  Connection conn=DriverManager.getConnection()
 *  
 *  - 객체명.메소드   → 인스턴스 메소드 
 *    클래스명,메소드  → static 메소드    
 */

public class MainClass10 {
	public static void main(String[] args) {
		String name="홍길동,박문수,심청이,이순신,강감찬";
		String[] names=name.split(",");
		//names={"홍길동","박문수","심청이","이순신","강감찬"};
		//출력 
		for(String n:names)
		{
			System.out.println(n);
		}
		
		//		
		System.out.println("====JOIN====");
		String ss=String.join("-",names); 	
		// ↑static 메소드 / join으로 묶어줄수있음 / 메모리할당을 하지 않고 사용
		System.out.println(ss);
		
		StringJoiner sj=new StringJoiner("," , "[" , "]"); // 형식을 만든다
		for(String n:names)
		{
			sj.add(n);
		}
		System.out.println(sj.toString());
	}
}
