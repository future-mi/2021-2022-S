package com.sist.server;
import java.net.*;
import java.io.*;
// Runnalbe �� ������
// �������� �� ServerSocket
// ������ �� listen()
// Ŭ���̾�Ʈ ���� �� accept() �� Ŭ������ ���� Ȯ��(ip,port)
// Ŭ���̾�Ʈ�� ��û�� �޴´� �� ��ûó�� �� ������� �����ش�

public class Server implements Runnable {
	// Socket
	private ServerSocket ss=null;
	private final int PORT=3355;
	// 1521,8080,3000,1433,4000
	
	// ��������
	public Server()
	{
		try {
			// ���� ������ �ι��Ұ���(�ѹ��� ���డ��)
			ss=new ServerSocket(PORT); //����Ʈ�� 50������� ����
			// Socket(��ȭ) / ServerSocket(������)
			// 1. bind - ip,port ���� - �ڵ�������(����)
			// 			 ip-��ȭ��ȣ / port-��ȭ��
			// 2. listen - ���
			// 	  socket - ��ȭ
			System.out.println("���������Ϸ�");
		} catch (Exception ex) {}
	}
	public void run()
	{
		//�������� �� ���ӽ� ó��
		while(true)	// ���������� ��������� ����
		{
			try
			{
			Socket s=ss.accept(); // ������ �� ����
			// Ȯ�� - ��ǻ���� ip�� ���
			System.out.println(s.getInetAddress().getHostAddress());
			System.out.println(s.getPort());	// � ���μ��� ���ؼ� �����ߴ���
			}
			catch(Exception ex) {}
		}
		
	}
	public static void main(String[] args) {
		Server s=new Server();
		new Thread(s).start(); //��������
	}
}
