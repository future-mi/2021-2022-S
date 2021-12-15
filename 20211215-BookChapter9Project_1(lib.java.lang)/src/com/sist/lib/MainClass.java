package com.sist.lib;

import javax.swing.border.MatteBorder;

/*
 * Math → 수학관련
 * 
 * 1. 난수 : random()
 * 		 원형) public static double random();
 * 2. 올림 : ceil()
 * 		→ ceil(17/5.0) → 3.4 → 4 → 총페이지
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		int count=103;	// 총 페이지수
		int total=103/15;
		if(total%15>0)
		{
			total++;
		}
		System.out.println("총페이지: "+total);
		
		System.out.println("=====lib이용=====");
		int total2=(int)Math.ceil(count/15.0);
		System.out.println("총페이지: "+total2);
		// 자바 → CBD(이미 만들어진 라이브러리로 조립)
		// 기능 → 검색(구글링..)
	}
}
