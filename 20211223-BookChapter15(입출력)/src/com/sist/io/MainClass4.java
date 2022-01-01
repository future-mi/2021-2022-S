package com.sist.io;
/*
 * ���� ����� �� �������� ����
 * 
 * - FileInputStream(�б�) / FileOutputStream(����) �� ����,����
 * - FileReader(�б�) / FileWriter(����) �� �ѱ� ����
 * 
 * ���Ͼ��� �� ���(w,a)
 * 	- w : create (������ �����) �� ������ �ִ� �����͸� ����� ���ο� ���� ����
 *  - a : append �� ������ �ִ� �����͸� �״�ε� ���¿��� ������ �߰�
 *  [�ѱ�����]
 * 		FileWriter fw=new FileWriter("��θ�") �� w
 * 		FileWriter fw=new FileWriter("��θ�",true) �� a
 * 	[���Ϻ���,���ε�]
 * 		FileOutputStream fis=new FileOutputStream("��θ�") �� w
 * 		FileOutputStream fis=new FileOutputStream("��θ�",true) �� a
 */

// �����б� �� InputStream, Reader
import java.io.*;
public class MainClass4 {
	public static void main(String[] args) {
//		FileInputStream fis=null; 	// 1byte�� �о���� Ŭ����
		FileReader fis=null; 	// �ѱ۱��� ���� �� ����
		// �׸�����, zip����
		// �ѱ��� �⺻ 2byte �� ���ڽ�Ʈ��
		try
		{
			// �ڹٿ����� ��μ����� �ݵ�� \\�� ����
//			fis=new FileInputStream("M:\\java1\\20211223-BookChapter15(�����)\\src\\com\\sist\\io\\MainClass.java");
			fis=new FileReader("D:\\java1\\20211223-BookChapter15(�����)\\src\\com\\sist\\io\\MainClass.java");
			// 1byte�� �д´� �� �ѱ��ھ� �о�´� �� int(������ ��ȣ)
			// A �� 65
			int i=0; 	// ���� �Ѱ��� �޾Ƽ� ������ ����
			// ������ ������ �д´�(EOF �� End of File) �� -1
			while((i=fis.read())!=-1)	// ��� �����͸� �о�Ͷ�
				{
					System.out.print((char)i);
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// �����ݱ�, ���ϴݱ�, ����Ŭ�ݱ�
			try
			{
			fis.close();	// ����ó���� �ʿ�
			}
			catch(Exception ex) {}
		}
	}
}
