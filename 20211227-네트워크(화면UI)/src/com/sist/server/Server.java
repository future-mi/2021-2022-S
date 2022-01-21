package com.sist.server;
/*
 * Thread :
 * ���α׷��� ���μ���(���μ����ȿ��� ������ ���α׷��� ���ÿ� ���� ������)
 *  
 * ����� ���ǽÿ� : �����尡 2�� ����
 * 	1) main() �� ������
 *  2) gc() �� ������
 * 
 * 
 * Thread�� �����ֱ�
 * 1)Thread ���� �� Thread ��� �� Thread ����(����)/Dead(���������ᰡ �ɼ�����) �� �Ͻ�����(sleep())
 * 				(Thread ���ۿ� �ʿ��� ������ ����)
 * 
 * �ð��� �����ؼ� �۾��ϴ� ����
 * 
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
	//1.������ Ŭ���̾�Ʈ(����:ip,port) ����
	private Vector<Client> waitVc=new Vector<Client>();
	// 2.��������
	private ServerSocket ss;
	//3.PORT(���ἱ)
	private final int PORT=3355; // 0~65535 ���̿��� ����
	//��������
	//���ӽÿ� ó�� �� waitVc���忡 ����
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
				//���ӽ� - ip,port�� ����
				Socket s=ss.accept(); 	// ��ȭ���� �� �߽��ڹ�ȣ
				// ���������� ������ �ϰ� => ����� �����ض�
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
	// ������ Ŭ���̾�Ʈ�� ���(��û �� ����) �� JSP
	class Client extends Thread
	{
		// ��� �� �����
		// Ŭ���̾�Ʈ�κ��� ��û�� �޴´�
		BufferedReader in;
		// Ŭ���̾�Ʈ�� ���� ����
		OutputStream out;
		// ��ȭ�ޱ�
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
		
		// �������
		public void run() // ������ ������ �ڵ�
		{
			while(true)
			{
				try
				{
					// Ŭ���̾�Ʈ�� ������ ��û���� �д´�
					String msg=in.readLine();
					// ������ ��� ������� ����
					for(Client c:waitVc)
					{
						c.out.write((msg+"\n").getBytes());
						// ��Ʈ��ũ�� ������ 1byte �� ������ 2byte
					}
				} catch (Exception ex) {}
			}
		}
	}
}
