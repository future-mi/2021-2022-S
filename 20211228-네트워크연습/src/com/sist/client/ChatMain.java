package com.sist.client;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// ��Ʈ��ũ ����
import java.io.*;
import java.net.*;
import com.sist.common.*;
/*
 * ���߱���(���) : implements Runnable,ActionListener
 * - �������̽������� ����� ����
 * - ���δٸ� �O�������� �����ؼ� ���
 * - ���õ� Ŭ������ ��� �Ѱ��� �̸����� ����
 * 
 * interface A
 * {	
 * 		/public static final/ int a=10;
 * 		/public abstract/ void display();
 * }
 * 
 * ���� �� �����
 * �޼ҵ�� ������ public 
 * 
 *  - Ŭ��������(Ŭ���������� �� ������(�������̽�))
 *  - �� �� �������̽��� �̿��ؼ� ����
 * 
 */

public class ChatMain extends JFrame implements Runnable,ActionListener{
	Login login=new Login();
	WaitRoom wr=new WaitRoom();
	CardLayout card=new CardLayout();
	// ȭ�� UI	
	// ��Ʈ��ũ�� ���õ� Ŭ����
	// ���ᵵ��
	Socket s;
	// ����� �� �����۽�, ��������
	OutputStream out;	// �۽�
	BufferedReader in;	// ���� �� ������(�ǽð�)
	// ������� ���� �� �ܹ���
	// id����
	String id;
	
	public ChatMain()
	{
		setLayout(card);
		add("LOGIN",login);
		add("WR",wr);
		setSize(1000,750);
		setVisible(true);
		
		// �α��� ��ư ó�� �� ���(�̺�Ʈ��� �� �ݹ��Լ�)
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		wr.tf.addActionListener(this);
	}
	public static void main(String[] args) {
		new ChatMain();
	}
	
	// ��û �� ��ưŬ����
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login.b2)	
		{
			// e.getSouce() �� Ŭ���� ��ư�� ���� Ȯ��
			System.exit(0);	// �����ض�
		}
		else if(e.getSource()==login.b1)	// �α��� ��ư�� Ŭ���ߴٸ�
		{
			// 1.�Է��� ���� �д´�
			// 1-1. ID�б�
			String id=login.tf1.getText();
			// ��ȿ���˻�
			if(id.length()<1) // id �Է��� ���°��
			{
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
				login.tf1.requestFocus();
				return;
			}
			
			// 1-2. �̸��б�
			String name=login.tf2.getText();
			if(name.length()<1) // id�Է��� ���� ���
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���");
				login.tf2.requestFocus();
				return;
			}
			// 1-3. ����
			String sex="";
			if(login.rb1.isSelected())
			{
				sex="����";
			}
			else
			{
				sex="����";
			}
			//���������ؼ� �����͸� ���� �� �����
			try
			{
				//1. ��ȭ�� ���� �� ����
				s=new Socket("localhost",3355);
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// �������� �����ִ� ������ �д� ��ü ��
				out=s.getOutputStream();
				// ������ �����͸� ���� ��
				
				out.write((Function.LOGIN+"|"
						+id+"|"+name+"|"+sex+"\n").getBytes());
			} catch (Exception ex) { ex.printStackTrace(); }
			// ������� �о�Ͷ�
			new Thread(this).start();
			// �� chatMain�� �ִ� run()�� ȣ��
		}
		// ä��
		else if(e.getSource()==wr.tf)
		{
			try
			{
				// 1-1�Էµ� ä�� ���ڿ� �б�
				String msg=wr.tf.getText();
				if(msg.length()<1)
				{
					// �Է��� �ȵ� ���
					wr.tf.requestFocus();
					return;
				}
				// �Է��� �� ��쿡�� ������ ���� �� ������ ��ü�� ���� ����
				out.write((Function.CHAT+"|"+msg+"\n").getBytes());
				// �Էµ� ���� �����ش�
				wr.tf.setText("");
			} catch (Exception ex) {}
		}
	}
	// �������� ���䰪�� �޾Ƽ� ���
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				//1. �������� ���� �����͸� �д´�
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
						wr.model.addRow(data);	// ���̺� ���
					}
					break;
					case Function.MYLOG:
					{
						// ȭ���̵� �� �α���â �� ���Ƿ� ����
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
