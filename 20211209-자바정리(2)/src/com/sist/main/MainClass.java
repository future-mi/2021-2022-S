package com.sist.main;

import java.util.Arrays;

public class MainClass {
// 제어문사용
// 메소드
// 객체지향 → 내부클래스
// 오류없는 프로그램(예외처리)
// 1장~8장까지 공부...!
	
/*
 *  단일 조건문
 *  다중 조건문
 * 
 *  1~100까지 → 3배수,5배수,7배수의 합
 *  	- 단일조건문 사용 
 * 
 * 	제어문 → 조건문
 * 	 포함  : && (범위에 포함 됐을 때) → 페이징 할 때 많이 씀
 *   미포함 : || (범위를 벗어나는 경우)  
 *   
 *   [선택정렬]
 *   45,67,90,34,12
 *   == ==
 *   67 45
 *   ==    ==
 *   90    67
 *   ==       ==
 *   90       34
 *   ==          ==
 *   90          12
 *   ===============================1라운드(for문이 1바퀴 돌았음 )
 *   90 45 67 34 12
 *   ==
 *  고정
 *  	45 67 34 12
 *      == ==
 *   	67 45
 *      ==    == 
 *      67    34
 *      ==		 ==
 *      67       12
 *  ===============================2라운드(for문이 2바퀴 돌았음 )
 *   90 45 67 34 12
 *   == ==
 *  고정 고정 
 *  ===============================이런식으로 반복되면서 고정
 *  arr.length-1 까지 돌게됨(갯수에서 1개가 감소한만큼 돌아감)ㄴ
 *   
 * 일차(i) 이차(j)   / m,n or a,b로 쓰는게 더 좋다..i j는 헷갈릴 수 있음
 *   1  →  4 		 i+j=5 → j=5-i
 *   2  →  3
 *   3  →  2
 *   4  →  1
 *   
 */
	public static void main(String[] args) {
		// 정렬 : 선택정렬, 버블정렬 → ORDER BY no DESC
		int[] arr= {45,67,24,90,34,12,55,100,84};
/*
		Arrays.sort(arr); 		// ASC(올림차순),DESC(내림차순)
		for(int i:arr)
		{
			System.out.println(i+" ");
		}

		System.out.println("\nDESC");
		for(int i=arr.length-1;i>=0;i--) 		// length-1하면 역순으로 출력이 된다
		{
			System.out.println(arr[i]+" ");
		}
*/		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])  // ← 내림차순  // 	if(arr[i]>arr[j]) 이건 올림차순
				{ 		
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
