package com.sist.exception;
/*
 *  ���� 
 *  - ����, �޼ҵ�(������+���), Ŭ����, ����ó��
 *  	�� Ȱ��(��:JSP,Spring, Spring-boot,Mybatis)
 *  	�� OpenAPI(īī�����, ����, data.go.kr)
 *  
 *  
 * 	try~catch ����ó�� 
 */
import java.io.*;
// C:\Windows\System32
import java.util.*; //Scanner

public class MainClass3 {
	public static void main(String[] args) {
		// ����ó��
		try
		{
			Scanner scan=new Scanner(System.in); // System.in �� ǥ���Է� �� �Է��� �޴� ��쿡 ��� / Ű����κ��� �Է°��� �޴� ��쿡 �о���� ���
												 // System(Ŭ����) in(InputStream) �� ������ static
												 // Ŭ������.�޼ҵ�, ���� �� static
												 // Math.random()
			System.out.print("1.���� 2.�׸��� 3.�޸��� 4.���ͳ�(whale) 5.���ͳ�(edge) �Է�: ");
			// �Է��� ���� �޾Ƽ� �޸𸮿� ����
			int no=scan.nextInt();
			/*
			 * [CheckException - �ݵ�� ����ó���� �ؾ� ����� �� ����]
			 *  IOException 			�� File ����(��θ�)
			 *  InterrupedException 	�� ������(�浹)
			 *  ClassNotFoundException 
			 *  SQLException 			�� ����Ŭ
			 *  MalformedURLException 	�� ��Ʈ��ũ(WEB�ּ�) 
			 */
			
			// ȭ���� �����ֱ� ����
			// �κи��� ���� �� ��ü������ ����
			if(no==1)
			{
				Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe"); 		// exe ������ �����Ҷ� �� .exec���
			}else if(no==2)
			{
				Runtime.getRuntime().exec("C:\\Windows\\System32\\mspaint.exe");
			}else if(no==3)
			{
				Runtime.getRuntime().exec("C:\\Windows\\System32\\notepad.exe");
			}else if(no==4)
			{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Naver\\Naver Whale\\Application\\whale.exe http://interpark.co.kr");
			}
			else if(no==5)
			{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe http://naver.com");	// ��ĭ ��� ���ϴ� ����Ʈ ���� ����
			}
			else
			{
				System.out.println("�޴� ������ �߸��Ǿ����ϴ�.");
				// ����ó�� �� ������ ������ ����(if) �� try~catch
				// ���� �� ��������
			}
			
		}catch(Exception e)
		{
			System.out.println("�Էµ� ��ΰ� Ʋ���ϴ�.");
		}
	}
}
