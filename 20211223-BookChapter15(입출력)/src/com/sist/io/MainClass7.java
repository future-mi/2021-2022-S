package com.sist.io;
/*
 * ���Ͽ� �ִ� ��ü �����͸� �޸𸮿� �ѹ��� ���� �� �д� ���α׷�
 * BufferReader �� ���پ� �о�´�
 */
import java.io.*;

public class MainClass7 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream("c:\\java_data\\news.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			// 1byte�� 2byte�� ����(�ѱ��� ���������� ����)
			while(true)
			{
				String data=br.readLine();
				if(data==null) break; // ���� ���� ��쿡�� ����
				System.out.println(data);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();	// ����ó��
		}
		finally
		{
			try
			{
				fis.close();	// �������ο� ������� ���ϴݱ�
			} catch (Exception ex) {}
		}
	}
}
