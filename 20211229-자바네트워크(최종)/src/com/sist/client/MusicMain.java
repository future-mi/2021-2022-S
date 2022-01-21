package com.sist.client;
// ������ �� HTML 
import java.awt.*;
import javax.swing.*;

import com.sist.common.Function;
import java.awt.event.*;
//
import java.io.*;
import java.net.*;
import java.util.*;
public class MusicMain extends JFrame implements Runnable,ActionListener{
	CardLayout card=new CardLayout();
	Login login=new Login();
	MusicView mv=new MusicView();
	Socket s; 	
   
	OutputStream out;
	BufferedReader in;
	public MusicMain()
	{
		setLayout(card);	// BorderLayer ����
		// ȭ�� �� ��Ƶд� 
		/*
		 * login �� ��������
		 * music �� ���Ǹ��, ����ã��
		 */
		add("LOGIN",login);
		add("MV",mv);
		
		// ũ�����
		setSize(800,640);
		// �����츦 �����޶�
		setVisible(true);
		// �����ư Ŭ���� ������ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ��ư Ŭ���� �� ����ؾ� �ڵ� ȣ��
		login.b1.addActionListener(this);	//�α���
		login.b2.addActionListener(this);	//���
		mv.b1.addActionListener(this);		//�˻�
		mv.b2.addActionListener(this);		//���
	}
	public static void main(String[] args) {
		// �����ڸ� ȣ��
		new MusicMain();
	}
	// ��ư Ŭ���� ó��
	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ڿ�û
		if(e.getSource()==login.b1)
		{
			// ������ ����
			// ID�б� �� ������ �Է� �� ��(��ȿ�� �˻�)
			String id=login.tf1.getText();
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this, "���̵� �Է�");
				login.tf1.requestFocus();
				return;
			}
			// �̸��б�
			String name=login.tf2.getText();
			if(name.length()<1)
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է�");
				login.tf2.requestFocus();
				return;
			}
			// ������ ����
			try {
				s=new Socket("localhost",3355);
				// Socket("�����ּ�(IP)",�������� ������ PORT)
				// �ۼ��� ��ġ Ȯ�� 
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				/*
				 *   Ŭ���̾�Ʈ: Socket(��������) �� ���� IP
				 *   ���� : Socket(Ŭ���̾�Ʈ ����) �� Ŭ���̾�Ʈ IP
				 */
				//�α��ο�û
				out.write((Function.LOGIN+"|"+id+"|"+name+"\n").getBytes());
			} catch (Exception ex) {}
			// ID,�̸� �� Login�� ��û
			// �������� ������ �����͸� �޾Ƽ� ����Ѵ�
			new Thread(this).start();
		}
		else if(e.getSource()==login.b2)
		{
			// ��� �� ���α׷�����
			System.exit(0); // 0 �� ��������
		}	
		else if(e.getSource()==mv.b1)
		{
			// �˻��� �о �˻��� ������ã�ƴ޶� ��û
			String ss=mv.tf.getText(); // �Է��� ���ڸ� �о� �´�
			if(ss.length()<1)
			{
				JOptionPane.showMessageDialog(this, "�˻��� �Է�");
				mv.tf.requestFocus();
				return;
			}
			// ������ ����
			 try {
				out.write((Function.FIND+"|"+ss+"\n").getBytes());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			 mv.tf.setText("");
		}
		else if(e.getSource()==mv.b2)
		{
			// ��ü��Ͽ�û
			try {
				out.write((Function.LIST+"|\n").getBytes());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// �������� ������ ������ ���
	@Override
	public void run() {
		try {
			while(true)
			{
				// �����κ��� ������ �ޱ�
				String msg=in.readLine();
				System.out.println("Server ��"+msg);
				// ����
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
					case Function.MYLOG:
					{
						card.show(getContentPane(), "MV");
						setTitle(st.nextToken());
					}
					break;
					case Function.LIST:
					{
						// ���̺����� ����� �ٽ� ä���
						for(int i=mv.model.getRowCount()-1;i>=0;i--)
						{
							mv.model.removeRow(i);
							
						}
						String data=st.nextToken();
						String[] music=data.split("\\^");
						for(String m:music)
						{
							String[] mdata=m.split("\\%");
							mv.model.addRow(mdata);
						}
					}
					break;
					case Function.FIND:
					{
						for(int i=mv.model.getRowCount()-1;i>=0;i--)
						{
							mv.model.removeRow(i);
							
						}
						String data=st.nextToken();
						String[] music=data.split("\\^");
						for(String m:music)
						{
							String[] mdata=m.split("\\%");
							mv.model.addRow(mdata);
						}
					}
					break;
				}
			}
		} catch (Exception ex) {}
	}
}
