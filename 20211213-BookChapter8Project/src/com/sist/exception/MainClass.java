package com.sist.exception;
/*
 * 프로그램 : 오류발생
 * 		1)에러(Error) → 소스상에서 해결 할 수 없는 에러
 * 			ex)메모리부족, 이클립스상에서 오류
 * 		2)예외(Exception) → 소스상에서 해결이 가능한 가벼운 에러
 * 			ex)1.사용자 입력값이 잘못됐을 경우(유효성검사)
 * 				- 나누기 → 10/0 → 0으로 나눌 수 없다 라는 메세지 날리는 것
 * 			   2.프로그래머의 실수
 * 				- 배열의 범위가 초과 : int[] arr=new int[2];
 * 								  arr[2]=100;  → 배열범위를 초과
 *				- 네트워크, 데이터베이스 → ip가 틀려서 연결이 안되는 경우 
 * 				- File의 경로명을 잘못입력했을 경우 
 * 				- SQL문장 실수(오라클)
 * 		- 자바 → 실행(2번)
 * 			A.java ------------→ A.class ----------→ 실행
 * 				   컴파일(javac)			 한줄씩 읽어서 번역(인터프리터)-java
 * 
 * 			- A.java(원시소스) : 프로그래머만 알고있는 소스 
 * 			- A.class(바이트코드) : 컴퓨터가 알 수 있는 언어
 * 			
 * 			(1) 컴파일에러 : 문법에러 → CheckException
 * 					- 반드시 예외처리를 사용(필수)
 * 					- java.net(네트워크)
 * 					- java.io(파입 입출력)
 * 					- java.sql(오라클 연결)
 * 			(2) 런타임에러 : 실행시 에러 → UnCheckException
 * 					- 필요시에 따라 예외처리 사용(필수가 아님)
 * 					- NumberFormatException → 문자열을 정수형으로 변경
 * 						→ 웹,윈도우(정수가 없음 → 문자열)
 * 						- Integer.parseInt("10");
 * 					  	  Integer.parseInt("10");
 *  				  	  list.jsp?page=1 → "1", "1"
 * 					class A
 * 					{
 * 						public void display(){}
 * 					}
 * 					A a;
 * 					a.display(); → NullPointerException
 * 
 * 				→ int[] arr=new int[2];
 * 				  arr[2]=100;  →  ArrayIndexOutOfBoundsException
 * 				→ 10/0 → ArithmeticException
 * ===================================================================== 416page
 * 			- 예외처리 → 순서가 있다
 * 			  예외처리의 계층구조
 * 				     Object
 * 					    |
 * 					Throwalbe
 * 						|
 * 				================
 * 				|				|
 *			Error            Exception(모든 예외처리)
 *	   	(처리불가능에러)						|
 *						  =========================================
 * 						 |                                        | 
 * 			CheckException		                         	UnCheckException
 *				|												  |
 *			IOException → 파일,메모리,네트워크					RuntimeException(↓밑에있는걸 동시에 처리)	
 *			URLMalformedException →사이트주소 틀린경우				  | (↓한개씩 처리)
 *			SQLException → 오라클 관련							NumberFormatException
 *			ClassNOtFoundException 							NullpointerException
 * 															ArithmeticException
 * 															ArrayOutOfBoundsException
 * 
 * 			
 * 			[예외처리 방법]
 * 			1)예외 복구 (try~catch) : 가장 많이 사용
 * 					→ 직접처리
 * 			2)예외 회피 (throws)
 * 					→ 간접처리
 * 			3)예외 만들기 (throw)
 * 					→ 예외던지기(배포)
 * 			4)사용자 정의 예외(자바에서 완벽하게 예외처리를 지원하지 않는다)
 * 			 		→ class MyException extends Exception
 * 
 * 
 * 	[예외처리]
 * 	1. 목적 : 비정상 종료를 방지하고 정상 수행이 가능하게 만드는 것
 * 	2. 정의 : 사전에 예상되는 에러를 방지하기 위한 방법론
 * 
 * 	요구사항분석(사이트) → 데이터베이스 설계(오라클) → 데이터 수집 →
 *  화면 UI(HTML/CSS) → 구현(JAVA/JS) → 테스팅(Spring) → 배포(발표-AWS)
 * 
 * 	요구사항 분석 → 어떤 에러가 발생할지 예상
 * 
 * 	[예외처리 사용법]
 *  1.직접처리(예외복구) → try~catch~finally(생략가능)
 *  	try
 *  	{
 *  		정상수행이 가능한 소스(지금까지 코딩한 내용)
 * 			→ 에러발생(프로그래머 실수,사용자 실수)
 *  	}catch(예외처리의 종류) → 여러번 사용이 가능(예상되는 에러)  
 *  	{
 *  		→ 에러처리 → 복구
 *  	}
 *  	finally
 *  	{
 *  		→ 정상수행, 비정상 수행 → 무조건 실행(네트워크 서버 해제, 오라클 연결 해제)
 *  	}
 *  	문장(수행여부)
 *  
 *  
 *  	try
 *  	{
 *  		1. 사용자의 입력값 받기(정수2개)
 *  		2. 두개의 정수를 배열에 저장(배열 범위 초과)
 *  			→ 에러발생
 *  	=============================================
 *  		3. 배열에 등록된 정수를 나누기(0으로 나눌 수 있다)
 *  		4. 결과값을 출력
 *  	}catch(배열범위 초과)
 *  	{
 *  		처리	→ 처리(원상복구)가 된 후 제일 아래 문장으로 빠져나감(try~catch밖에 문장)
 *  	}catch(0으로 나눴을 경우)
 *  	{
 *  		처리
 *  	}
 *  	finally
 *  	{
 *  		try,catch와 관계없이 무조건 수행하는 문장
 *  	}
 *  		|
 *  	밖에 있는 문장
 *  	
 *  	public static void main(String[] arg)
 *  	{											1-2-3-6-8-9-10(수행) → 정상종료
 *  		1)문장 → 1수행
 *  		2)문장 → 2수행
 *  		try
 *  		{
 *  			3)문장 → 3수행
 *  			4)문장  → (예외처리 종류1 발생) → catch로 이동 
 *  			5)문장  
 *  		}catch(예외처리종류1)
 *  		{
 *  			6)문장 → 4수행
 *  		}catch(예외처리종류2)
 *  		{
 *  			7)문장
 *  		}
 *  		finally
 *  		{
 *				8)문장  → 5수행(무조건수행 → 생략이 가능)
 *  		}
 *  		9)문장 → 6수행
 * 			10)문장 → 7수행
 * 		} 
 * 
 */

public class MainClass {
	
	public static void main(String[] args) {
		try
		{
		int[] arr=new int[2];
	//  arr[0]=Integer.parseInt("10");
		arr[0]=10;
	 	arr[2]=0; 		// 에러출력(배열범위 초과)
	//  arr[1]=0;		// 에러출력(0으로 나눌 수 없음)	
		int result =arr[0]/arr[1]; 	// error → catch 2
		System.out.println(result);

 		}catch(Throwable e)  // Exception → 예외처리의 최상의 클래스 / 모든 에러를 처리 할 수 있다. 
//		  → 더 넓은 범위의 예외처리는 아래로 내려가야함(Exception이 ArrayIndexOutOfBoundsException 등 보다 위로가면 이미 예외처리를 다했기때문에 아래에 나오는 예외처리들은 에러남)
		{
			System.out.println(e.getMessage()); 
		}
		
/*
 		}catch(ArrayIndexOutOfBoundsException e) 		// 배열범위 초과했을 때의 예외처리
		{
			System.out.println(e.getMessage()); 		// 에러메세지 출력 - Index 2 out of bounds for length 2
		}catch(ArithmeticException e)					// 0으로 나눌 수 없을 때의 예외처리
		{
			System.out.println("0으로 나눌 수 없습니다!");
		}
*/
		System.out.println("프로그램 종료");
	}
}
