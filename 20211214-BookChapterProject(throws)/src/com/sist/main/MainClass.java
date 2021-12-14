package com.sist.main;
/*
 * 예외처리 : 사전에 에러발생에 대한 방지 프로그램
 * 			→ 비정상 종료를 하지않고 정상수행이 가능하게 만들어 준다
 * 			→ 에러가나면 점프후에 에러를 벗어난다
 * 예외처리 : 코드상의 문제가 있는 경우에 수정이 가능한 에러만 처리(가벼운에러)
 * 
 * [에러]
 * 	1.문법상의 에러
 * 		- ;, {}, 파일의 경로명, 서버IP  → 반드시 예외처리 → CheckException
 * 	2.실행시 에러
 * 		- 사용자 입력에서의 문제, 프로그래머 실수 → UnCheckException
 * 
 * [예외처리방법]
 * 1.예외복구 → catch(에러→자주 에러를 출력해서(output) 잡는(수정하는) 연습)
 * 		try	
 * 		{
 * 			정상수행 문장
 * 			→ 에러가 발생할 수 있음
 * 		}catch(예외종류)
 * 		{
 * 			1)에러내용출력(어디서 에러가 발생하는지 확인)
 * 				- getMessage() → 에러내용출력
 * 					◎ 분리(메소드를 세분화) → 단락을 나눈다
 * 				- printStackTrace() → 실행하는 과정을 출력(멈추는상태에서 코드위치 확인) 
 * 			2)예외복구(다시 입력창으로 전송)
 * 				- 데이터수집(Jsoup(정적),셀레니움(동적))
 * 				- 저장(데이터형 클래스) - ~VO
 * 				→ 에러확인(코드수정)
 * 		}
 * 			**catch절은 여러개 사용이 가능(예상되는 예외처리)
 * 			**통합사용 → Exception, Throwalbe
 * 		finally
 * 		 - 서버닫기, 오라클 닫기
 * 		 - 파일닫기
 * 2. 예외회피 (throws → 예외선언하기) → 427page
 * 		→ 직접 처리하는부분이 아니고 이런 에러가 발생할 것 같다고 JVM에 알려주는 상태
 * 		1) 사용법
 * 			- 메소드()throws 예외종류1,예외종류2.... → 순서업이 사용이 가능
 * 		2)처리방법
 * 			- 선언(예외회피)
 * 			- try~catch를 이용해서 처리가 가능
 * 			- 기본은 동일함
 * 				ex) public void display() throws NumberFormatException,ClassCastException
 * 					→ display를 사용하려면 예외처리 하고 사용한다
 * 					상위 : RuntimeException →Exception → Throwalbe
 * 	
 * 				(1)	public void main() throws NumberFormatException,ClassCastException
 * 					{
 * 						display()
 * 					}
 * 				(2)	public void main()
 * 					{
 * 						try
 * 						{
 * 							display()	
 * 						}catch(NumberFormatException e){
 * 						}catch(ClassCastException e){}
 * 					}
 * 				(3)	public void main() throw RuntimeException
 * 					{
 * 						display()	
 * 					}
 * 				(4)	public void main() throw Exception
 *					{
 *						display()
 *					} 
 *  3. 사용자 정의 예외처리
 *  	1)extends Exception
 *  	2)catch절을 사용시에 자동으로 찾지를 못한다
 *  	3)throw → 예외처리 호출
 *  
 */
public class MainClass {
	//예외가 있는 메소드 선언(라이브러리 메소드) → 자바에서 제공, 외부제공
	public static void add(int a,int b)throws Exception
	{
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b); 	// b==0이면 문제발생
	}
	
	public static void main(String[] args) throws Exception {
		add(10,20);
		
		
		
		
	}
}
