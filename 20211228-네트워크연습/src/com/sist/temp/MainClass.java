package com.sist.temp;
/*
 * ��Ʈ��ũ(Ŭ���̾�Ʈ/����) 
 * 1.Ŭ���̾�Ʈ(front-end) �� ����� ���α׷�(USER)
 *  1) ��û �� ����� �����ش�, �˻�, �α���ó��, ȸ������, �۾���...
 *  2) �����κ��� ������ �޾Ƽ� ȭ�鿡 ���(ȭ�� UI)
 *  3) ������(Application)
 * 		��(������ �� ȭ��UI �� HTML,XML) �� ȭ�������(CSS)
 * 		�����(XML�� ȭ�� UI �� �ڹٿ��� ��Ʋ��)
 * 2.����(Back-end)
 *  1) ����ڰ� ��û�� ������ �޾ƺ���
 *  2) ��û�� ���� ó��
 * 	- ������ �˻�
 * 	- ����
 * 	- ����
 * 	- �߰�
 * 	- ����Ŭ �� DML(������ ���۾��) �� CRUD
 * 		SELECT(�����Ͱ˻�) / INSERT(�߰�) / UPDATE(����) / DELETE(����)
 *  3) ó������� ����(Ŭ���̾�Ʈ�� ����)
 *  4) ���� ����ڸ� �������� ����(�����Ͱ� ����)
 *  
 *  - ��Ʈ��ũ�� �̿��ϴ� ���α׷� 
 *  						Ŭ���̾�Ʈ		    ����
 *  ==================================================
 *  Application				������/����	 �ڹ� ���� ����
 *  ==================================================
 *  Web Application			������		 ����ġ(��Ĺ)
 *  						ȭ�� UI		   ��û����
 *  									 Spring/JSP
 *      - �������� ���ٰ���(���������ͻ��) �� ����(����Ŭ)		
 *  ==================================================
 *  Mobile Application		�ڵ���		   ��(http)
 *  ==================================================
 *  
 *  �ֿ�Ŭ����
 *    1) URL : �������� ���ٽÿ� �ÿ�
 *    2) ServerSocket : ������
 *    		- ������ �޴´�
 *    		- �ش� Socket�� ����
 *    3) Socket : ��ȭ �� Ŭ����
 *    		- �ݵ�� �����忡�� ����(���� ����� ���� �� �� �ִ�)
 * 
 *   (1)�����ϴ� ����
 *   	- ��������(����)
 *   		ss=new ServerSocket(PORT)
 *   		bind() �� �ڵ��� ����(����)
 *  	- listen() : ������
 *  	- accept() : Ư�̸޼ҵ� : ������� �� Ŭ���̾�Ʈ�� ������ ���� ���� ȣ��
 *  				 ���ӽÿ� ������� ������ �����Ѵ�
 *  	- Socket accept() : Socket�� �޾Ƽ� ������ �Ѵ�(�ٽ� �����ϱ� ���� ip���)
 *  						���ӽø��� Ŭ���̾�Ʈ�� ���� ����� ���ؼ� ������ ����
 *  
 *  [���� ���α׷��� �ΰ��� Ŭ����]
 *  1. Ŭ���� : ������ �޾Ƽ� ������ ���� �� ��� ����
 *  2. ��Ÿ� ���(��û������) �� ��ż���
 *  - �Ѱ��� Ŭ������ ���� : ����Ŭ����(inner class)
 *  
 *  class Server
 *  {
 *  	��������(�������� ip/port)
 *  	��������
 *  	���ӽ� ó��
 *  	class Client extends Thread
 *  	{
 *  		����� ����ϴ� �ҽ�
 *  		�� ���� ����(�������� ip/port�� ����)
 *  	}	
 *  }
 *  
 *  [���� �����ϴ� ���]
 *  - 1:n
 *  - P2P �� ��������/ ȭ��...����
 *  - TCP / UDP �� Socket(TCP)
 *  	TCP :  ��Ʈ���� �̿��ϴ� ���α׷�(�޸𸮿� ���� �� ����� ���� �д´�)
 *  		   ������ �ս��� ���� ����, ���������� �� ������ �ɶ����� ������ ����(�ŷڼ��� ����)
 *  	UDP : �ӵ��� ������, ������ �ҽ��� �ִ�(����,��Ƽ�̵��)
 */
import java.net.*;	//URL�Է�
import java.io.*;	//�����

public class MainClass {
	public static void main(String[] args) {
	/*
	 * CheckException
	 * 
	 * 	CheckException : JVM�� ����(����ó���� �ߴ���)
	 * - ��Ʈ��ũ(URL,����IP) �� ������ ������ ���� / java.net
	 * - ����(��θ�,���ϸ�) �� ������ ������ ���� / java.io
	 * - ������(���ý��� �� �浹)	/ java.lang
	 * - ����Ŭ����(SQL����)	/ java.sql
	 */
		try {
			URL url=new URL("https://wikibook.co.kr/list/");
			//����
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			//�����͸� �޸𸮿� �ű��
			if(conn!=null)
			{
				BufferedReader in=new BufferedReader
								(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true)
				{
					String line=in.readLine();
					if(line==null)	// �о�� �����Ͱ� ���ٸ�
					{
						break; // �����Ѵ�
					}
					System.out.println(line);
				}
				in.close();
				conn.disconnect(); // ����
			}
			// Document doc=Jsoup.connection("https://wikibook.co.kr/list/");
		} catch (Exception ex)	{
		ex.printStackTrace();	// ����Ȯ��
		}	
	}
}
