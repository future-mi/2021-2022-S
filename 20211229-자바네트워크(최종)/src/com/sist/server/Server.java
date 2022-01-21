package com.sist.server;
/*
 * [사용클래스]
 * 1. 서버구동 → ServerSocket
 * 2. 접속자정보 저장 → ArrayList
 * 3. 음악정보 저장 → ArrayList
 * 4. 통신
 * 	- 송신 : 결과값 → OutputStream
 * 	- 수신 : 요청을 받는다 → BufferedReader
 * ========================================
 * 1. 서버구동
 * 	1) 소켓을 생성
 *  2) 대기상태
 * 2. 접속자 접속대기
 * 	1) 접속자의 정보를 받는다
 * 	2) 접속자마다 따로 통신이 가능하게 만든다(쓰레드 : 프로그램을 별도로 수행)
 * 3. 접속자와 통신(쓰레드)
 * 	- 웹 프로그램 : 파일을 이용한다
 */
// 자바라이브러리
import java.util.*;
import java.io.*;
import java.net.*;
// 사용자정의 라이브러리
import com.sist.music.*;
import com.sist.common.*;

public class Server implements Runnable{
	private static ArrayList<Music> mList=new ArrayList<Music>();
	// 뮤직데이터를 저장할 공간
	private ArrayList<Client> cList=new ArrayList<Client>();
	// 접속자의 정보를 저장한다(ID,NAME,IP,PORT)
	private ServerSocket ss;
	// 기지국 → 접속을 받아서 연결 
	/*
	 *  1. 변수의 초기화
	 * 	- 기본데이터(디폴트 설정) → 멤버변수는 기본 데이터값을 가지고 있다
	 *  - 메소드 안에 선언된 변수를 지역변수 → 초기화가 안되어있음(반드시 초기화 필요) 
	 *  - 명시적인 초기화: 선언과 동시에 값을 부여
	 *  - 초기화 블록 : 명시적으로 초기화를 하지 못하는 경우
	 *  			 클래스 영역에 설정된 변수는 선언만 가능(구현은 불가능)
	 *  - 생성자를 통해서 초기화가 가능
	 */
	static
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("c:\\java_data\\music_object.txt");
			// 읽은 파일을 객체단위로 저장
			ois=new ObjectInputStream(fis);
			// ArrayList에 저장
			mList=(ArrayList<Music>)ois.readObject();
		} catch (Exception ex)
		{
			// 에러처리 → 에러확인
			ex.printStackTrace();
		}
		finally
		{
			// 파일닫기 
			try	{
			fis.close();
			ois.close();
			}catch(Exception ex) {}
		}
	}
	public Server()
	{
		// 호출시에 설정
		// 서버구동
		try
		{
			ss=new ServerSocket(3355);	// port는 반드시 고정시켜야함
			// port → 프로그래머가 만들어서 사용
			// 클라이언트는 시스템에 의해 자동 생성
			// 구동하고있다(알림)
			// bind() → listen()
			System.out.println("Music Server Start...");
		} catch (Exception ex) {}
	}
	// 접속시 처리
	public void run()
	{
		try
		{
			Socket s=ss.accept();	// 접속이 되면 → 사용자의 정보(Socket)
			// Socket → ip/port → 통신이 가능
			// Socket → 쓰레드로 전송해서 접속자마자 통신이 가능하게 만ㄷ
			Client client=new Client(s);
			client.start(); // 소켓을 넘겨주고 해당 접속자와 통신을 시작한다
		} catch (Exception ex) {}
	}
	public static void main(String[] args) {
		//구동
		Server server=new Server();	// 생성자호출(구동)
		new Thread(server).start();	// run() 호출 → 접속자 접속처리
	}
	/*
	 * 통신을 담당하는 클래스 → 반드시(접속자마다 따로 생성) → 프로그램을 별도로 수행
	 * 프로그램(프로세서)안에서 여러개의 다른 프로그램을 수행 → 쓰레드
	 * 쓰레드는 반드시 동작을 할 떄 run() → run()을 호출시에는 반드시 start()
	 *  쓰레드를 이용해서 통신을 시작한다(접속자정보) 
	 *  	→ Server/Client → 내부클래스 이용
	 *  내부클래스 이용 : 윈도우(javax.swing),쓰레드,빅데이터
	 *  익명의클래스 : 상속없이 재정의(오버라이딩)
	 */
	class Client extends Thread // 접속자마자 생성되는 클래스(별도로 동작)
	{
		Socket s;	
		// 입출력 → 통신
		OutputStream out;  // 송신(요청처리 결과를 보내줄때 사용)
		BufferedReader in; // 수신(사용자의 요청을 받는 경우에 사용)
		// 확장(접속자구분)
		String id,name; //로그인할 떄 전송을 받는다
		public Client(Socket s)
		{
			try
			{
				this.s=s;
			// 모든 프로그램언어 → 지역변수(메소드안에 선언된 변수,매개변수) → 우선순위
			// 지역변수 → 멤버변수 
			// 입출력(통신)을 할 수 있게 연결
				//입력
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				//출력
				out=s.getOutputStream();	// 추상클래스
				/*
				 * 추상클래스, 인터페이스(추상클래스의 일종)
				 * 	→ 미완성된 클래스
				 * 사용법 : 반드시 구현된 클래스를 이용해서 메모리 할당을 한다
				 */
			}catch(Exception ex) {}
		}
		// 통신을 한다
		public void run()
		{
			while(true)
			{
				try
				{
					// 1.사용자 요청 
					String msg=in.readLine();
					// readLine() → 맨 마지막에 \n이 반드시 존재해야함
					// 2.기능별 처리 
					StringTokenizer st=new StringTokenizer(msg+"|");
					// 3. 어떤 요청인지? → 상수
					int protocol=Integer.parseInt(st.nextToken());
					// 전송시 반드시 → 100|로그인데이터\n
					switch(protocol)
					{
						case Function.LOGIN:
						{
							// login처리 → 화면변경 → 음악 데이터 전송
							// 데이터 받기
							id=st.nextToken();
							name=st.nextToken();
							// 저장(접속자정보)
							cList.add(this); 	//id,name,s,in,out
							// 2. 로그인 → 음악 화면 변경
							messageTo(Function.MYLOG+"|"+name);
							// 3. 음악데이터를 전송한다
							StringBuffer sb=new StringBuffer();
							for(Music m:mList)
							{
								String music=m.getNo()+"%"
											+m.getTitle()+"%"
											+m.getSinger()+"%"
											+m.getAlbum()+"^";
								sb.append(music);
							}
							messageTo(Function.LIST+"|"+sb.toString());
						}
						break;
						
						case Function.LIST:
						{
							StringBuffer sb=new StringBuffer();
							for(Music m:mList)
							{
									String music=m.getNo()+"%"
												+m.getTitle()+"%"
												+m.getSinger()+"%"
												+m.getAlbum()+"^";
									sb.append(music);
							}
							messageTo(Function.LIST+"|"+sb.toString());
						}
						break;
						
						case Function.FIND:
						{
							// 음악 검색어를 받아서 → 찾은 데이터 전송
							StringBuffer sb=new StringBuffer();
							// 검색어를 받는다
							String ss=st.nextToken();
							// 찾기
							for(Music m:mList)
							{
								if(m.getTitle().contains(ss))
								{
									String music=m.getNo()+"%"
												+m.getTitle()+"%"
												+m.getSinger()+"%"
												+m.getAlbum()+"^";
									sb.append(music);
								}
							}
							// 찾은 내용을 사용자한테 전송
							messageTo(Function.FIND+"|"+sb.toString());
							/*
							 * 서버기능
							 * 1. 데이터 받기 : BufferedReader → readLine()
							 * 2. 데이터 전송 : OutputStream → write()
							 * 3. 데이터 검색 : contains(), equals()
							 * 4. 데이터 추가 : Login, 방만들기
							 * 5. 데이터 수정 : NickName, 방변경
							 * 6. 데이터 삭제 : 나가기
							 * → 오라클, 웹서버
							 */
						}
						break;
					}
				}catch(Exception ex) {}
			}
		}
		// 데이터를 전송
		public void messageTo(String msg)
		{
			try
			{
				// out → 접속자에게 데이터를 전송
				out.write((msg+"\n").getBytes());	//1byte전송 2byte받기
			}catch(Exception ex) {}
		}
		/*
		 *  반복이 많은 경우에는 메소드처리한다
		 * 메소드 : 한개의 기능을 만들어서 재사용할 때
		 * 		  코딩상에서 반복이 많은 경우
		 * 		  가독성이 좋게 만든다(에러가 발생시에 빠른 처리가 가능)
		 */	
	}	
}