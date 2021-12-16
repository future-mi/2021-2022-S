package com.sist.lib;
/*
 * StringTokenizer(단어별추출) → split() →[]
 * - java.util 안에있음
 * - 형태소분석시 사용 → 라이브러리(꼬꼬마,코모란) → 챗봇(인공지능)
 * Open API → 카카오, 네이버클로버, 구글
 */
import java.util.*;
public class MainClass6 {
	// <c:forTokens> → 나중에 나올 내용
	public static void main(String[] args) {
		String names="홍길동|심청이|춘향이|김두한|강감찬|을지문덕";
		StringTokenizer st=new StringTokenizer(names,"|");
/*
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
*/
		System.out.println("이름갯수: "+st.countTokens()); // countTokens : 가지고있는 갯수를 확인할 때 사용
		while(st.hasMoreTokens())		// 갯수를 모를때 사용
		{
			System.out.println(st.nextToken());
		}
		/*
		 * new StringTokenizer(names,"|")
		 * st.nextToken() : 실제 자른 데이터 1개
		 * st.countTokens() : 실제 자른 갯수
		 * st.hasMoreTokens() : 가지고있는 갯수(boolean)
		 * 
		 * → 날짜,이미지에 많이 사용
		 * → null값이 있는 경우에는 오류 발생(빈칸이라도 주면 공백으로 생김)
		 * 
		 */
	}
}
