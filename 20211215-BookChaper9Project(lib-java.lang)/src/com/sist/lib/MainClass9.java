package com.sist.lib;
/*
 * trim(),valueOf(),split()
 * 
 * 1. trim() : 좌우의 공백 제거 / 사용자가 브라우저에서 입력시에
 * 				→ "Hello" , " Hello".trim() 
 * 			  	  " Hello Java!! " → 문자열 가운데 공백은 제거 불가능
 * 2. valueOf() : 모든 데이터형을 문자열로 변환
 * 					 valueOf(1) → "1"
 * 					 valueOf(true) → "true"
 * 					 valueOf(10.5) → "10.5" 
 * 3. split() : 문자를 분리해서 배열에 저장
 * 				String s="admin|1234|홍길동|남자";
 * 				String[] ss=s.split("|");
 * 				ss[0]="admin";
 * 				ss[1]="1234";
 * 				ss[2]="홍길동";
 * 
 */
public class MainClass9 {
	public static void main(String[] args) {
		String data=" Hello Java!! ";
		System.out.println("문자갯수: "+data.length()+"개"); // 14개
		String s=data.trim();
		System.out.println("문자갯수: "+s.length()+"개");	// 12개
	
		int a=100;
		int b=200;
		System.out.println("a+b: "+a+b);
		// static 메소드(클래스명,메소드) → static
		// Math.random()
		String a1=String.valueOf(a);
		String b1=String.valueOf(b);
		System.out.println("a1+b1: "+a1+b1);
		
		System.out.println("=========================");
		
		String data2="홍길동-남자-25-서울-개발";
		String[] info=data2.split("-");
		for(String ss:info)
		{
			System.out.println(ss);
		}
	}
}
