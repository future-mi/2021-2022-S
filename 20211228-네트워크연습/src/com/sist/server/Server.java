package com.sist.server;
/*
 * Server : ����ڿ�û �� ó�� �� ���������
 * - ���ӽ� ó�� / ����ڸ��� ���(Thread)
 */
import java.util.*;	//StringTokeizer, ����(���������) 
import com.sist.common.Function;
import java.net.*;	//��Ʈ��ũ ����
import java.io.*;	//�б�(ReadLine),����(Write)

// ���ӽ� ó�� �� ������ Runnable
public class Server implements Runnable{
	// �������� : ServerSocket
	// ������ ���� ���� �� ArrayList
	// ���� �� �����ϴ� ���μ� �� ��Ʈ��ȣ �� ���� ��3355
	private ServerSocket ss;
	private ArrayList<Client> waitVc=new ArrayList<Client>();
	// 1.�������� �� �ѹ������ �� �ѹ��� �����ϴ� �޼ҵ�(������)
	public  Server()
	{
		try {
			ss=new ServerSocket(3355);	// ���� ������ �Ϸ�
			// bind() : ���� �� listen() : ������
			System.out.println("Server Start");
		} catch (Exception ex) {}
	}
	
	// ���ӽ� ó���ϴ� �޼ҵ�(������)
	public void run()
	{
		while(true) 	// �������������� ������ ����
		{
			try
			{
				// Server : Socket �� Client ����
				Socket s=ss.accept();	// ���ӽÿ� ȣ��Ǵ� �޼ҵ� �� ������ Ŭ���̾�Ʈ�� ���� ����
				// Ŭ���̾�Ʈ ����(Ŭ���̾�Ʈ : IP, PORT)
				// Socket �� Thread�� �����ϸ� �� Thread�� �ѻ���� ����� �����ϰ� �ѵ��
				// Client : Socket �� Server ����
				Client client=new Client(s);
				client.start();
			} catch (Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		Server server=new Server();
		new Thread(server).start();
	}
	// ���ӽ� ó�� �� ������(��ȯ)
	// ������ ������ ������ �Ŀ� �� Thread�� �������ִ� ����
	// ��� �� �α���ó��, ä��ó��, ������ ó��
	class Client extends Thread
	{
		// ������ Ȯ��
		private String id;
		private String sex;
		private String name;
		
		// ������ �⺻ ���� �� �α��νÿ� Ŭ���̾�Ʈ�� ����
		// ��ũ��ũ ����
		private OutputStream out; // ��û�ÿ� ó�� ������� �����ִ� ����
		private BufferedReader in; // Ŭ���̾�Ʈ�� ��û���� ������ö� ���
		private Socket s;		  // ��ŵ���
		
		public Client(Socket s)
		{
			// �����ڿ� ����
			try
			{
				// ��ȭ�� �޴´�
				this.s=s;
				// �۽�
				out=s.getOutputStream();
				// ����
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (Exception ex) {}
		}
		// ��Ž��� �� ������ 1�� / Ŭ���̾�Ʈ ������
		// �����ڸ��� �� ����� ������ �� �ְ� �����
		public void run()
		{
			 try
			 {
				while(true)
				{
					// 1.�������� ��û�� �޴´�
					String msg=in.readLine();
					// readLine() �� \n���� �д� �޼ҵ�
					// 100|hong|ȫ�浿|����\n 
					System.out.println("Client �� "+msg);
					StringTokenizer st=new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
						case Function.LOGIN:
						{
							// �α��ο�û �� ���۵����͸� ����
							id=st.nextToken();
							name=st.nextToken();
							sex=st.nextToken();
							
							// ������ ������ ����鿡�� ������ ����
							messageAll(Function.LOGIN+"|"
										+id+"|"+name+"|"+sex);
							
							messageAll(Function.CHAT+"|[ �˸� �� "+name+"���� �����ϼ̽��ϴ� ]");
							
							// �α����� ����� ArrayList�� �߰�
							waitVc.add(this);
							// ȭ�� ����
							messageTo(Function.MYLOG+"|"+name);
							// ������ ������ ������ �α��� �ϴ� ������� ����
							for(Client c:waitVc)
							{
								messageTo(Function.LOGIN+"|"+c.id+"|"
										  +c.name+"|"+c.sex);
							}
						}
						break;
						case Function.CHAT:
						{
							messageAll(Function.CHAT+"|[name] "+st.nextToken());
						}
						break;
						case Function.EXIT:
						{
							
						}
						break;
					}
				}
			} catch (Exception ex) {}
		}
		// ����� ���� 2����
		// 1) �����ڰ� ��ü���� �޼��� ����(������)
		public synchronized void messageAll(String msg)	// ����ȭ����(synchronized)
		{
			for(int i=0;i<waitVc.size();i++) //waitVc�� ������ ��� �����
			{
				try
				{
					Client c=waitVc.get(i);
					c.messageAll(msg);
				} catch (Exception e)
				{
					waitVc.remove(i); // �޼����� ���� �ʴ� ������� ����
				}
			}
		}
		// 2) ������ ������� �޼��� ����(�Ѹ�)
		public void messageTo(String msg)	// �񵿱�ȭ
		{
			try
			{
				out.write((msg+"\n").getBytes()); // byte[]�� ����(���ڵ�)
				// decoding �� InputStreamReader(s.getInputStream()));
			} catch (Exception ex) {}
		}
	}
}
