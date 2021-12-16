package com.sist.lib;

import java.util.*;

// UPDOWN 게임 → 숫자야구게임
public class MainClass4 {
	public static void main(String[] args) {
		int count=0;
		// 1.임의의 수 저장 → 난수(Random) 1~100
		Random r=new Random();
		int com=r.nextInt(100)+1; 	
		
		// 2.사용자가 입력해서 정답
		System.out.println("게임 Start!");
		
		Scanner scan=new Scanner(System.in);
		while(true)	//반복 횟수를 모를 때 사용 → 무한루프
		{
			//사용자입력
			System.out.println("1~100사이의 정수 입력");
			int user=scan.nextInt();
			// 1~100사이가 아닌 경우
			if(user<1 || user>100)
			{
				System.out.println("잘못된 입력입니다");	
				continue; 		//	 → while에서는 조건식으로 이동
								//	 → for문이면 증가식으로 이동
			}
			count++;
			//힌트
			if(user<com)
			{
				System.out.println("입력값보다 높은 숫자를 입력하세요");
			}
			else if(user>com)
			{
				System.out.println("입력값보다 낮은 숫자를 입력하세요");
			}
			else 	// 같은경우
			{
				System.out.println("정답입니다");
				System.out.println("입력횟수: "+count);
				break; 	//while문 종료
			}
			//정답여부 → 종료
		}	
	}
}
