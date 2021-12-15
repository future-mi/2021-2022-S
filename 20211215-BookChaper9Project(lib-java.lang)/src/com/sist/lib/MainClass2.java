package com.sist.lib;
/*
 * String 클래스
 * 
 * String → 데이터형, 클래스형(기능)
 * ====== 상속을 내리지 못하는 클래스
 *   원형) public final class String{}
 *   → java.lang → final → 제공한 내용을 사용, 모든 개발자가 동일하게 사용
 *   
 *   1. 데이터형으로 사용
 *   	- String s="";
 *   2. 클래스형으로 사용
 *   	- String s=new String("");
 * 	 3. 기능(제공) → 메소드
 * 		- charAt(int index) → 자바는 인덱스번호 0번부터 / 오라클은 1번부터 
 * 		- contains/stratswith/endswith : 검색용
 * 	 4. 비교(문자열) → 실제 저장되어있는 문자열 자체 / == 주소값을 비교하는 것 
 * 		- equals() : 대소문자를 구분(비밀번호,ID)
 * 		- equalsIgnoreCase() : 대소문자 구분 안함(이름,검색)
 * 			
 * 			** 문자열 ="" / "" → 자체가 주소
 * 	 5. 찾기
 * 		- 원하는 문자의 위치 찾기 → 원하는 부분 추출
 * 		  존재여부확인(-1)이면 존재하지 않는다.
 * 			앞에서 찾기 : indexOf
 * 			뒤에서 찾기 : lastIndexOf(확장자)
 * 			c:\\javaDev\\a.java 	→ a.b
 * 
 * 469~471page
 * 	 원형) public int indexOf(char c)
 * 		  public int indexOf(String s)
 * 
 * 		  public int lastIndexOf(char c)
 * 		  public int lastIndexOf(String s)
 * 
 * 
 * 
 * 
 * 
 */		

// 사용자 입력 → 로그인
import java.util.*;

public class MainClass2 {
	public static void main(String[] args) {
		// 1.입력을 받는다.
		Scanner scan=new Scanner(System.in);
		System.out.println("ID와 Password입력: ");
		String id=scan.next();
		String pwd=scan.next();
		System.out.println("ID:"+id);
		System.out.println("Password:"+pwd);
		
		// 2.ID,PWD비교
		// → 오라클에 저장된 데이터라고 생각해보기
		final String myId="admin";
		final String myPwd="1234";
		
		// 3.결과값을 출력
		// 중첩if
		// equals → 대소문자를 구분해서 비교
		// equalsIgnoreCas → 대소문자 구분 없음
		if(myId.equalsIgnoreCase(id))
		{
			if(myPwd.equals(pwd)) 	// 비밀번호검색
			{
				System.out.println(id+"님 로그인되었습니다.");
			}
			else
			{
				System.out.println("Password가 틀립니다.");
			}
		}
		else
		{
			System.out.println("ID가 존재하지 않습니다.");

		}
		
		
		
		
	}
} 
