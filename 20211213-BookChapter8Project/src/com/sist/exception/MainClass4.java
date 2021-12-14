package com.sist.exception;

// 전체 try~catch → 메소드 안, 생성자, 초기화블록 / 클래스블록에서는 사용 할 수 없음

public class MainClass4 {
	// 선언만 하는 영역
	
	public static void main(String[] args) {
		// 전체예외처리
	//	try
	//	{
			// 데이터 수집할때도 for문안에 try~catch문 넣어주기
			for(int i=1; i<=10; i++)
			{
				try
				{
				int j=(int)(Math.random()*3); //0,1,2 중에 하나 발생
				int k=i/j;
				System.out.println("k="+k);
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage()); // try~catch문을 for문안에 넣을때 10번을 다 수행함
					i++;
				}
			}
	//	}catch(Exception ex)			//	try~catch문이 밖에있을 때 for문이 돌다가 오류나니까 catch문 찾으려고 중단하고 나감
	//	{
	//		System.out.println(ex.getMessage());
	//	}
		
		/*
		 *  getMessage → 실제 에러메세지만 출력
		 *  printStackTrace → 에러만 부분 체크(줄수)
		 *  
		 */
	}
}
