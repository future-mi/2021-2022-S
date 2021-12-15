package com.sist.lib;
/*
 * length() → 문자의 갯수 확인
 */
public class MainClass5 {
	public static void main(String[] args) {
		String[] movie= {
				"밥정",
				"그린 북",
				"가버나움",
				"디지몬 어드벤처 라스트 에볼루션 : 인연",
				"원더",
				"베일리 어게인",
				"아일라",
				"극장판 바이올렛 에버가든",
				"당갈",
				"먼 훗날 우리"
		};
		// 1.전체목록
		for(String title:movie)
		{
			System.out.println(title);
		}
		System.out.println("========================");
		// length는 갯수확인시에 사용
		for(String title:movie)
		{
			if(title.length()>7)
			{
				title=title.substring(0,7)+"...";
			}
			System.out.println(title);
		}
	}
}
