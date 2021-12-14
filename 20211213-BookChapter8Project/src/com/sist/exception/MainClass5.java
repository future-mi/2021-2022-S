package com.sist.exception;
/*
 * 423page 멀티블록
 * 
 *  catch(예외처리클래스 a1|예외처리클래스 a2) / 예상되는 에러가 여러개일때 사용 
 *  // 사용빈도는 거의 없다
 *  
 */
import java.util.*;
// 생략이 가능한 패키지 → java.lang.* (Object,String,StringBuffer...)
// java.lang, java.util, java.io, java.net, javax....
import java.io.*;

public interface MainClass5 {
	public static void main(String[] args) {
/*
 * 문자열(next())로 데이터를 받아서  → 정수변환 O
 * 	- NumberFormatException
 * 배열에 저장 → 배열을 벗어 날 수 있다
 *  - ArrayIndexOutOFBoundsException
 * 저장된 데이터를 나눈다 → 0으로 나눌 수 있다.
 *  - ArithmeticException
 * 결과값 출력
 * 
 * → catch 3개 이용
 * → | 로 연결
 * → Exception / RuntimeException 사용
 * 
 */
		try
		{
			//정상수행이 가능한 소스
			Scanner scan=new Scanner(System.in);
			System.out.println("첫번째 정수 입력: ");
			String no1=scan.next(); 	// 1을 입력하면 "1" 이 넘어옴
			System.out.println("두번째 정수 입력: ");
			String no2=scan.next();
			
			// 배열에 저장
			int[] arr=new int[2];
			arr[0]=Integer.parseInt(no1); 		// Integer.parseInt 문자열을 정수형으로 변환
			arr[1]=Integer.parseInt(no2);
			
			int result=arr[0]/arr[1];
			System.out.println(result);
			
			//catch → 예상되는 에러를 처리 → 복구
		}
//		catch(RuntimeException e /*Exception e*/) // ← 제일 많이 씀
//		{	}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) // ← 멀티블록
		{
			e.printStackTrace(); // 실행과정 출력 → 중간에 멈춤(에러줄수)
		}
//		catch(ArrayIndexOutOfBoundsException e)
//		{
//			System.out.println(e.getMessage());
//		}
//		catch(ArithmeticException e)
//		{
//			System.out.println(e.getMessage());
//		}
	}
	/*
	 * catch → 순서
	 * 계층구조는 위로 올라갈수록 에러잡는 범위가 크다
	 * 			Throwable : 에러의 최상의 클래스
	 * 큰 클래스가 밑에 있다(순서가 존재)
	 * 
	 * catch(Exception e){}
	 * catch(RuntimeException e){}
	 * catch(IOException e){}     → 오류
	 * 
	 * 
	 * catch(RuntimeException e){}
	 * catch(IOException e){}
	 * catch(Exception e){} → 정상수행
	 * 
	 * catch(RuntimeException e){}
	 * catch(SQLException e){}
	 * catch(NumberFormatException e){}
	 * catch(Exception e){} → 오류
	 * 
	 * catch(NumberFormatException e){}
	 * catch(RuntimeException e){}
	 * catch(SQLException e){}
	 * catch(Exception e){} → 정상수행
	 * 
	 */
	
}
