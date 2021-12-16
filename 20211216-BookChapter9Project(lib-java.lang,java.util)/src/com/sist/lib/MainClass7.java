package com.sist.lib;
import java.util.*;
import java.text.*;
/*
 * 1. Random() → nextInt(n) : n은 제외
 * 2. StringTokenizer
 * 	- nextToken : 값읽기
 *  - hasMoreTokens : 반복
 *  - countTokens : 갯수
 * 3. Date,Calendar : 달력
 * 4. Format
 * 5. List
 */
public class MainClass7 {
	public static void main(String[] args) {
		//오늘날짜
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// 월은 M 대문자 / 시간의 m은 소문자로 입력해야함 / "yyyy년 MM월 dd일 hh:mm:ss"
		System.out.println(sdf.format(date));
		
		StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		System.out.println(st.nextToken()+"년");
		System.out.print(st.nextToken()+"월");
		System.out.print(st.nextToken()+"일");
		
		// 달력을 만들때는 MM이 아닌 yyyy-M-dd로 입력해야함
		// MM dd → 01, 01 / 09, 10 
		// → 08과 09는 앞에 0이 붙어있으면 8진법으로 인식해서 오류날 수 있음
		// System.out.println(0b1111); // → 0b를 붙이면 15가 출력됨
	}
}
