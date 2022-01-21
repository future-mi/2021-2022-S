package com.sist.server;
import java.net.*;
import java.io.*;
// Runnalbe → 쓰레드
// 서버구동 → ServerSocket
// 대기상태 → listen()
// 클라이언트 접속 → accept() → 클래스의 정보 확인(ip,port)
// 클라이언트의 요청을 받는다 → 요청처리 → 결과값을 보내준다

public class Server implements Runnable {
	// Socket
	private ServerSocket ss=null;
	private final int PORT=3355;
	// 1521,8080,3000,1433,4000
	
	// 서버구동
	public Server()
	{
		try {
			// 서버 구동은 두번불가능(한번만 실행가능)
			ss=new ServerSocket(PORT); //디폴트는 50명까지만 연결
			// Socket(전화) / ServerSocket(기지국)
			// 1. bind - ip,port 연결 - 핸드폰개통(유심)
			// 			 ip-전화번호 / port-전화선
			// 2. listen - 대기
			// 	  socket - 전화
			System.out.println("서버구동완료");
		} catch (Exception ex) {}
	}
	public void run()
	{
		//서버동작 → 접속시 처리
		while(true)	// 서버구동을 계속적으로 수행
		{
			try
			{
			Socket s=ss.accept(); // 접속이 된 상태
			// 확인 - 컴퓨터의 ip를 출력
			System.out.println(s.getInetAddress().getHostAddress());
			System.out.println(s.getPort());	// 어떤 라인선을 통해서 접근했는지
			}
			catch(Exception ex) {}
		}
		
	}
	public static void main(String[] args) {
		Server s=new Server();
		new Thread(s).start(); //서버구동
	}
}
