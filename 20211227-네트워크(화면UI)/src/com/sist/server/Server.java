package com.sist.server;
/*
 * Thread :
 * 프로그램은 프로세서(프로세서안에는 여러개 프로그램을 동시에 동작 쓰레드)
 *  
 * 사용자 정의시에 : 쓰레드가 2개 동작
 * 	1) main() → 쓰레드
 *  2) gc() → 쓰레드
 * 
 * 
 * Thread의 생명주기
 * 1)Thread 생성 → Thread 대기 → Thread 동작(실행)/Dead(쓰레드종료가 될수있음) ↔ 일시정지(sleep())
 * 				(Thread 동작에 필요한 데이터 수집)
 * 
 * 시간을 분할해서 작업하는 역할
 * 
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
	//1.접속한 클라이언트(정보:ip,port) 저장
	private Vector<Client> waitVc=new Vector<Client>();
	// 2.서버가동
	private ServerSocket ss;
	//3.PORT(연결선)
	private final int PORT=3355; // 0~65535 사이에서 결정
	//서버가동
	//접속시에 처리 → waitVc저장에 저장
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);
			System.out.println("Server Start!!");
		}catch(Exception ex) {}
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				//접속시 - ip,port를 저장
				Socket s=ss.accept(); 	// 전화접속 → 발신자번호
				// 서버에서는 저장을 하고 => 통신을 시작해라
				Client c=new Client(s);
				waitVc.add(c);
				c.start();
			}catch(Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		Server s=new Server();
		new Thread().start();
	}
	// 접속한 클라이언트와 통신(요청 → 응답) → JSP
	class Client extends Thread
	{
		// 통신 → 입출력
		// 클라이언트로부터 요청을 받는다
		BufferedReader in;
		// 클라이언트로 값을 전송
		OutputStream out;
		// 전화받기
		Socket s;
		public Client (Socket s)
		{
			try
			{
				this.s=s;
				in=new BufferedReader(
						new InputStreamReader(
								s.getInputStream()));
				out=s.getOutputStream();
			}catch(Exception ex) {}
		}
		
		// 실제통신
		public void run() // 쓰레드 동작을 코딩
		{
			while(true)
			{
				try
				{
					// 클라이언트가 보내준 요청값을 읽는다
					String msg=in.readLine();
					// 접속한 모든 사람에게 전송
					for(Client c:waitVc)
					{
						c.out.write((msg+"\n").getBytes());
						// 네트워크는 보낼때 1byte → 받을때 2byte
					}
				} catch (Exception ex) {}
			}
		}
	}
}
