package com.sist.exception;
/*
 *  문법 
 *  - 변수, 메소드(연산자+제어문), 클래스, 예외처리
 *  	→ 활용(웹:JSP,Spring, Spring-boot,Mybatis)
 *  	→ OpenAPI(카카오→맵, 뉴스, data.go.kr)
 *  
 *  
 * 	try~catch 예외처리 
 */
import java.io.*;
// C:\Windows\System32
import java.util.*; //Scanner

public class MainClass3 {
	public static void main(String[] args) {
		// 예외처리
		try
		{
			Scanner scan=new Scanner(System.in); // System.in → 표준입력 → 입력을 받는 경우에 사용 / 키보드로부터 입력값을 받는 경우에 읽어오는 기능
												 // System(클래스) in(InputStream) → 변수는 static
												 // 클래스명.메소드, 변수 → static
												 // Math.random()
			System.out.print("1.계산기 2.그림판 3.메모장 4.인터넷(whale) 5.인터넷(edge) 입력: ");
			// 입력한 값을 받아서 메모리에 저장
			int no=scan.nextInt();
			/*
			 * [CheckException - 반드시 예외처리를 해야 사용할 수 있음]
			 *  IOException 			→ File 관련(경로명)
			 *  InterrupedException 	→ 쓰레드(충돌)
			 *  ClassNotFoundException 
			 *  SQLException 			→ 오라클
			 *  MalformedURLException 	→ 네트워크(WEB주소) 
			 */
			
			// 화면을 보여주기 시작
			// 부분마다 가능 → 전체적으로 가능
			if(no==1)
			{
				Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe"); 		// exe 파일을 실행할때 → .exec사용
			}else if(no==2)
			{
				Runtime.getRuntime().exec("C:\\Windows\\System32\\mspaint.exe");
			}else if(no==3)
			{
				Runtime.getRuntime().exec("C:\\Windows\\System32\\notepad.exe");
			}else if(no==4)
			{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Naver\\Naver Whale\\Application\\whale.exe http://interpark.co.kr");
			}
			else if(no==5)
			{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe http://naver.com");	// 한칸 띄고 원하는 사이트 지정 가능
			}
			else
			{
				System.out.println("메뉴 선택이 잘못되었습니다.");
				// 예외처리 → 에러를 사전에 방지(if) → try~catch
				// 코테 → 오류방지
			}
			
		}catch(Exception e)
		{
			System.out.println("입력된 경로가 틀립니다.");
		}
	}
}
