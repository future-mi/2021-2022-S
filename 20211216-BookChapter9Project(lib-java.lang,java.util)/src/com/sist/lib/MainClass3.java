package com.sist.lib;
/*
 * 1. java.lang
 * 2. java.util
 * 	 - 프로그램에서 유용하게 사용되는 클래스 집합
 * 	1) 난수 : Random → 500page
 * 	2) 문자열분리 : StringTokenizer → 513page
 * 	3) 날짜 : Date,Calendar
 *  4) 변환 : SimpleDateFormat, MessageFormat
 *  5) 집합(데이터수집)
 *  			Collection
 *  				|
 *  	 =======================
 *  	|			|			|
 *     List		   Set		   Map
 *    	|			|			|
 * 	ArrayList	 TreeSet	 Hashtable
 *  Vector  	 HashSet	 HashMap → 주로 코테에 나옴
 *  LinkedList
 *  Stack
 * 
 *  6) 입력값 : Scanner
 */
import java.util.*;	// *은 모든 클래스를 불러오는 것 → util을 많이쓸 때는 *사용	
					// java.util.Scanner; 이런식으로 하는것을 권장
public class MainClass3 {
	public static void main(String[] args) {
		// 난수 → nextInt(30) → 0~29까지 발생
		Random r=new Random();
		//int i=r.nextInt(); //int범위에서 발생
		//System.out.println(i);
		int i=r.nextInt(100); //0~99까지 발생
		//nextInt(n) → 0~n은 제외
		System.out.println(i);
		//실수 : nextDouble → 0.0~0.99
	}
}
