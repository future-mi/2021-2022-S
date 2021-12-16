package com.sist.lib;

import java.text.SimpleDateFormat;
/*
 * java.util
 * 1. 날짜관련
 * 	- Date(오라클 호환), Calendar(제어)
 * 2. 변환관련
 *  - 날짜변환 
 *  	- SimpleDateFormat
 *  	- ChoiceFormat
 *  	- MessageFormat(SQL)
 * 3. 데이터 수집
 * 	- Collection(11장,12장)
 * 
 * 1장~8장 → 자바기초(필수)
 */
import java.util.*;

public class MainClass8 {
	public static void main(String[] args) {

		// 1.오늘날짜 Date date=new Date(); // 시스템의 날짜 정보(시간)
		// 2.변환(프로그램에 맞는 형식으로 변환)
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-dd");
//		yyyy : 4자리 년도 M : 월 d : 일 → dd hh : 시간 mm : 분 ss : 초
//		String today=sdf.format(date); // System.out.println(today); StringTokenizer
//		st=new StringTokenizer(today,"-"); String strYear=st.nextToken(); String
//		strMonth=st.nextToken(); String strDay=st.nextToken(); 
//		int year=Integer.parseInt(strYear); int month=Integer.parseInt(strMonth); int
//		day=Integer.parseInt(strDay);
//		System.out.println(strYear+"년도 "+strMonth+"월");

		System.out.println();
		Scanner scan=new Scanner(System.in);
		System.out.println("년도 입력:");
		int year=scan.nextInt();
		System.out.println("월 입력:");
		int month=scan.nextInt();
		System.out.println(year+"년 "+month+"월");
		
		// 요일출력
		String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
		for (String week : strWeek) {
			System.out.print(week + "\t");
		}
		System.out.println();
		/*
		 * List list=new ArrayList() → interface Calendar c=메소드() → 추상클래스
		 */
		// Calendar 설정
		Calendar cal = Calendar.getInstance(); // ← calendar 객체 생성
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		// 요일
		int week = cal.get(Calendar.DAY_OF_WEEK); // week는 1~7까지(1부터 시작)
		// System.out.println(strWeek[week-1]);

		// 마지막날
		int lastday = cal.getActualMaximum(Calendar.DATE);
		// .getMaximum(Calendar.DATE) 그달의 마지막 날짜구하기
		// System.out.println(lastday);

		// 달력출력
		week = week - 1;
		System.out.println("\n");
		for (int i = 1; i <= lastday; i++) {
			if (i == 1) {
				for (int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++;
			if (week > 6) {
				week = 0;
				System.out.println("\n");
			}
		}
	}
}
