package com.sist.lib;
/*
 * 	1. 예외처리
 * 		1) 예외복구(try~catch~finally)
 * 		2) 예외회피(throws)
 * 			- 예상되는 에러를 선언 → JVM에 알려준다(통과→컴파일이 가능하게 만들어준다)
 * 			- 사용시에는 반드시 처리를 하고 사용한다
 * 			(1) throws 이용하는 방식
 * 			(2) try~catch 이용하는방식
 * 			(3) 예외가 여러개 선언시에 Exception,Throwable로 통합이 가능
 * 			- try~with~resource
 * 			  try(FileReader fr=new FileReader(""))
 * 				{
 * 					fr는 try블록이 종료가 되면 자동으로 fr.close()호출
 * 				}catch(Exception e){}
 * 		==============================================================	
 * 			[계층구조]
 * 				(CheckException)
 * 				- 파일관련 → IOException
 * 				- 네트워크 관련 → MalformedURLException
 * 				- 오라클 관련 → SQLException
 *				- 클래스 관련 → ClassNotFoundException
 *				(UnCheckException)
 *				- 필요에 따라 예외처리 할 수 없다(자주 에러가 발생하는 부분에서는 사용)
 *		===============================================================
 *
 * 	2. 라이브러리(java.lang) → 9장
 * 		1) Object : 모든 클래스의 상속을 내리는 클래스
 * 			(1) 사용자 정의 클래스(개발자가 만드는 클래스)
 * 			(2) 자바에서 제공하는 클래스(라이브러리)
 * 			(3) 외부에서 제공하는 클래스(Jsoup,Spring,MyBatis) → open source
 * 			
 * 			- Object 클래스가 지원하는 기능(메소드)
 * 				- toString() : 객체를 문자열로 변환(호출이 없어도 자동으로 호출)
 * 				- finalize() : 객체 소멸시에 자동 호출되는 메소드(소멸자)
 * 				- clone() : 객체를 복제(같은 메모리를 복사해서 새로운 메모리를 생성) 
 * 							→ 참조 : 같은 메모리를 제어(별칭) / 클래스,배열
 * 
 * 		2) String : 클래스 / 데이터형 → 값을 주입
 *									String s="값";    ← 가장 많이 사용
 *									String s=new String("값");
 *				- 문자열을 제어하는 클래스
 *				- 문자열을 제어하는 기능(메소드)
 *					1) length() : 문자의 갯수
 *								→ String → char[] / index번호는 0번부터 시작한다
 *					2) charAt() : 원하는 index를 이용하여 문자를 추출 
 *					3) contains() : 문자열 중에 포함된 문자가 있는 경우에 출력
 *					4) startWith() : 시작문자열이 같은지 확인
 *					5) endsWith() : 끝나는 문자열이 같은지 확인
 * 
 * 
 */
public class 정리_20211214 {
	public static void main(String[] args) {
		
	}
}
