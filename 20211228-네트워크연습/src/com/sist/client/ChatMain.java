package com.sist.client;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 네트워크 관련
import java.io.*;
import java.net.*;
import com.sist.common.*;
/*
 * 다중구형(상속) : implements Runnable,ActionListener
 * - 인터페이스에서만 사용이 가능
 * - 서로다른 긐ㄹ래스를 연결해서 사용
 * - 관련된 클래스를 묶어서 한개의 이름으로 관리
 * 
 * interface A
 * {	
 * 		/public static final/ int a=10;
 * 		/public abstract/ void display();
 * }
 * 
 * 변수 → 상수형
 * 메소드는 무조건 public 
 * 
 *  - 클래스관리(클래스관리자 → 스프링(인터페이스))
 *  - 웹 → 인터페이스를 이용해서 구현
 * 
 */

public class ChatMain extends JFrame implements Runnable,ActionListener{
	Login login=new Login();
	WaitRoom wr=new WaitRoom();
	CardLayout card=new CardLayout();
	// 화면 UI	
	// 네트워크와 관련된 클래스
	// 연결도구
	Socket s;
	// 입출력 → 서버송신, 서버수신
	OutputStream out;	// 송신
	BufferedReader in;	// 수신 → 쓰레드(실시간)
	// 입출력의 단점 → 단방향
	// id저장
	String id;
	
	public ChatMain()
	{
		setLayout(card);
		add("LOGIN",login);
		add("WR",wr);
		setSize(1000,750);
		setVisible(true);
		
		// 로그인 버튼 처리 → 등록(이벤트등록 → 콜백함수)
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		wr.tf.addActionListener(this);
	}
	public static void main(String[] args) {
		new ChatMain();
	}
	
	// 요청 → 버튼클릭시
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login.b2)	
		{
			// e.getSouce() → 클릭한 버튼이 뭔지 확인
			System.exit(0);	// 종료해라
		}
		else if(e.getSource()==login.b1)	// 로그인 버튼을 클릭했다면
		{
			// 1.입력한 값을 읽는다
			// 1-1. ID읽기
			String id=login.tf1.getText();
			// 유효성검사
			if(id.length()<1) // id 입력이 없는경우
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				login.tf1.requestFocus();
				return;
			}
			
			// 1-2. 이름읽기
			String name=login.tf2.getText();
			if(name.length()<1) // id입력이 없는 경우
			{
				JOptionPane.showMessageDialog(this, "이름를 입력하세요");
				login.tf2.requestFocus();
				return;
			}
			// 1-3. 성별
			String sex="";
			if(login.rb1.isSelected())
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			//서버연결해서 데이터를 전송 → 결과값
			try
			{
				//1. 전화기 연결 → 서버
				s=new Socket("localhost",3355);
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 서버에서 보내주는 데이터 읽는 객체 ↑
				out=s.getOutputStream();
				// 서버로 데이터를 보냄 ↑
				
				out.write((Function.LOGIN+"|"
						+id+"|"+name+"|"+sex+"\n").getBytes());
			} catch (Exception ex) { ex.printStackTrace(); }
			// 결과값을 읽어와라
			new Thread(this).start();
			// → chatMain에 있는 run()을 호출
		}
		// 채팅
		else if(e.getSource()==wr.tf)
		{
			try
			{
				// 1-1입력된 채팅 문자열 읽기
				String msg=wr.tf.getText();
				if(msg.length()<1)
				{
					// 입력이 안된 경우
					wr.tf.requestFocus();
					return;
				}
				// 입력이 된 경우에는 서버로 전송 → 접속자 전체에 값을 전송
				out.write((Function.CHAT+"|"+msg+"\n").getBytes());
				// 입력된 값을 지워준다
				wr.tf.setText("");
			} catch (Exception ex) {}
		}
	}
	// 서버에서 응답값을 받아서 출력
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				//1. 서버에서 들어온 데이터를 읽는다
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protoco=Integer.parseInt(st.nextToken());
				switch(protoco)
				{
					case Function.LOGIN:
					{
						String[] data= {st.nextToken(),
										st.nextToken(),
										st.nextToken()
										};
						wr.model.addRow(data);	// 테이블에 출력
					}
					break;
					case Function.MYLOG:
					{
						// 화면이동 → 로그인창 → 대기실로 변경
						card.show(getContentPane(),"WR");
						setTitle(st.nextToken());
					}
					break;
					case Function.CHAT:
					{
						wr.ta.append(st.nextToken()+"\n");
					}
					break;
				}
			}
		} catch (Exception ex) {}
	}
}
