package com.sist.exception;
/*
 *  중복없는 난수 발생 → 로또 (1~45) → 6개 → 예외처리
 */
public class MainClass6 {
	public static void main(String[] args) {
		// 난수발생 → 일반
		int[] com=new int[6]; // 결과값 저장 위치
		int su=0; 			  // 난수를 저장하는 변수
		boolean bCheck=false; // 중복여부를 확인
		// true → 중복 / false → 중복이 없음
		for(int i=0;i<6;i++)
		{
			// 1. 중복여부 확인
			bCheck=true;
			while(bCheck)
			{
				// 난수발생
				su=(int)(Math.random()*45)+1; // 1~45난수(임의의 정수)
				// random() → 0.0~0.99 → 45 →0.0~44.9999 → 0~44 +1 → 1~45
				// Random r=new Random() → r.nextInt(45)+1  이렇게 써도 동일한 내용
				// Math → random(), ceil() : 올림(총페이지 구할 때 사용)
				
				// while 종료
				bCheck=false; // 반복문 → default 설정
				for(int j=0;j<i;j++)
				{
					if(com[j]==su) 	// 중복된 숫자가 있는지 확인
					{
						bCheck=true;
						break;
					}
				}
				// 조건 → 중복여부 확인
			}
			// 2. 중복이면 → 난수 재발생
			// 3. 중복이아니면 com배열에 저장
			com[i]=su;
		}
		
		// 결과출력 → 예외처리
		try
		{
			for(int i:com)
			{
				System.out.println(i+" ");
				Thread.sleep(500); 	// 숫자를 바꾸면 출력되는 속도가 다름
			}
		}catch(Exception e)
		{		
		}
	}
}
