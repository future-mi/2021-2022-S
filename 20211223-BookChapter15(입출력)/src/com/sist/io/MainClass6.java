package com.sist.io;
// FileWriter �� 2byte�� ���� �� ���� ��Ʈ��
// byte��ȯ ���� �� String�� �״�� ÷�ΰ� ����
// default(w) �� ����ø��� ���ο� ������ ����� �ش�
// a �� new FileWriter("��θ�",true) �� �������߰�
import java.io.*;
public class MainClass6 {
	public static void main(String[] args) {
		FileWriter fw=null;
		try
		{
			// ��������� �����ϰ� �����
			File file=new File("c:\\java_data\\news.txt");
			if(!file.exists())
			{
				// ������ ������ ������ ������
				// ��ǻ�Ϳ� ���
				file.createNewFile();
				System.out.println("���ϻ��� �Ϸ�");
			}
			// ���Ͽ� ������ �Է�
			/*
			fw=new FileWriter(file,true);	// ��� �Է��ϰڴ�
			String news="�ǰ��� ǻ�ľ��� �ʹ��� ��Ű�� ���µ�\n";
			fw.write(news);
			System.out.println("������ �Է� �Ϸ�");
			*/
			FileReader fr=new FileReader(file);
			int i=0;
			String msg="";
			while((i=fr.read())!=-1);
			{
				msg+=String.valueOf((char)i);
				
			}
			System.out.println(msg);
			fr.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fw.close();
			} catch (Exception ex) {}
		}
	}
}