package com.sist.temp;
/*
 * 네트워크(클라이언트/서버) 
 * 1.클라이언트(front-end) → 사용자 프로그램(USER)
 *  1) 요청 → 목록을 보여준다, 검색, 로그인처리, 회원가입, 글쓰기...
 *  2) 서버로부터 응답을 받아서 화면에 출력(화면 UI)
 *  3) 윈도우(Application)
 * 		웹(브라우저 → 화면UI → HTML,XML) → 화면디자인(CSS)
 * 		모바일(XML로 화면 UI → 자바에서 코틀린)
 * 2.서버(Back-end)
 *  1) 사용자가 요청한 내용을 받아본다
 *  2) 요청에 대한 처리
 * 	- 데이터 검색
 * 	- 삭제
 * 	- 수정
 * 	- 추가
 * 	- 오라클 → DML(데이터 조작언어) → CRUD
 * 		SELECT(데이터검색) / INSERT(추가) / UPDATE(수정) / DELETE(삭제)
 *  3) 처리결과를 응답(클라이언트로 전송)
 *  4) 여러 사용자를 공통으로 관리(데이터가 공유)
 *  
 *  - 네트워크를 이용하는 프로그램 
 *  						클라이언트		    서버
 *  ==================================================
 *  Application				윈도우/도스	 자바 서버 제작
 *  ==================================================
 *  Web Application			브라우저		 아파치(톰캣)
 *  						화면 UI		   요청예상
 *  									 Spring/JSP
 *      - 여러명이 접근가능(같은데이터사용) → 공유(오라클)		
 *  ==================================================
 *  Mobile Application		핸드폰		   웹(http)
 *  ==================================================
 *  
 *  주요클래스
 *    1) URL : 웹서버에 접근시에 시용
 *    2) ServerSocket : 기지국
 *    		- 접속을 받는다
 *    		- 해당 Socket을 연결
 *    3) Socket : 전화 → 클래스
 *    		- 반드시 쓰레드에서 연결(각자 통신을 따로 할 수 있다)
 * 
 *   (1)동작하는 과정
 *   	- 서버실행(구동)
 *   		ss=new ServerSocket(PORT)
 *   		bind() → 핸드폰 개통(유심)
 *  	- listen() : 대기상태
 *  	- accept() : 특이메소드 : 멈춤상태 → 클라이언트가 접속을 했을 때만 호출
 *  				 접속시에 사용자의 정보를 리턴한다
 *  	- Socket accept() : Socket을 받아서 저장을 한다(다시 응답하기 위해 ip기억)
 *  						접속시마다 클라이언트가 각자 통신을 위해서 쓰레드 생성
 *  
 *  [서버 프로그램은 두개의 클래스]
 *  1. 클래스 : 접속을 받아서 정보를 저장 → 대기 소켓
 *  2. 통신만 담당(요청→응답) → 통신소켓
 *  - 한개의 클래스로 통합 : 내부클래스(inner class)
 *  
 *  class Server
 *  {
 *  	정보저장(접속자의 ip/port)
 *  	서버구동
 *  	접속시 처리
 *  	class Client extends Thread
 *  	{
 *  		통신을 담당하는 소스
 *  		→ 정보 저장(접속자의 ip/port를 공유)
 *  	}	
 *  }
 *  
 *  [서버 제작하는 방식]
 *  - 1:n
 *  - P2P → 파일전송/ 화상...게임
 *  - TCP / UDP → Socket(TCP)
 *  	TCP :  스트림을 이용하는 프로그램(메모리에 저장 → 저장된 값을 읽는다)
 *  		   데이터 손실이 거의 없음, 연결지향적 → 연결이 될때까지 데이터 전송(신뢰성이 높음)
 *  	UDP : 속도가 빠르다, 데이터 소실이 있다(게임,멀티미디어)
 */
import java.net.*;	//URL입력
import java.io.*;	//입출력

public class MainClass {
	public static void main(String[] args) {
	/*
	 * CheckException
	 * 
	 * 	CheckException : JVM이 감시(예외처리를 했는지)
	 * - 네트워크(URL,서버IP) → 수정이 가능한 에러 / java.net
	 * - 파일(경로명,파일명) → 수정이 가능한 에러 / java.io
	 * - 쓰레드(동시실행 → 충돌)	/ java.lang
	 * - 오라클연결(SQL문장)	/ java.sql
	 */
		try {
			URL url=new URL("https://wikibook.co.kr/list/");
			//연결
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			//데이터를 메모리에 옮긴다
			if(conn!=null)
			{
				BufferedReader in=new BufferedReader
								(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true)
				{
					String line=in.readLine();
					if(line==null)	// 읽어올 데이터가 없다면
					{
						break; // 종료한다
					}
					System.out.println(line);
				}
				in.close();
				conn.disconnect(); // 종료
			}
			// Document doc=Jsoup.connection("https://wikibook.co.kr/list/");
		} catch (Exception ex)	{
		ex.printStackTrace();	// 에러확인
		}	
	}
}
