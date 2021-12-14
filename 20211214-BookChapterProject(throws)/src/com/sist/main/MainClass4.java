package com.sist.main;
//finally �� close(), ����, ����, �����ͺ��̽�
//try, catch ����� ������� ������ �����ϴ� ����
import java.io.*;

public class MainClass4 {
/*
 	public static void main(String[] args) throws Exception{
		//�����б�
		FileReader fr=new FileReader("M:\\java1\\movie.txt");
		int i=0; // ���������� �� char(ASC)
		while((i=fr.read())!=-1)		// -1(EOF)
		{
			System.out.print((char)i);
		}
		
		fr.close();
	}
*/
/*	
	public static void main(String[] args) {
		FileReader fr=null;		// main��ü���� ���
		try
		{
			fr=new FileReader("M:\\java1\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				System.out.println((char)i); //���� ������ ���
			}
		} catch (FileNotFoundException e){}
		  catch (IOException e){}
			// �� finally�� ���ÿ� ���󵵰� ����(�����ͺ��̽�,��Ʈ��ũ, ���Ͽ� ���)
		finally
		{
			try
			{
				fr.close();
			} catch (IOException e) {}
		}
	}
*/	
		//473page
	public static void main(String[] args) {
		try(FileReader fr=new FileReader("M:\\java1\\movie.txt"))
		{
			int i=0;
			while((i=fr.read())!=-1)
			{
				System.out.print((char)i);
			}
			// try ����� ����� �ڵ����� close()�� ȣ��
		}catch(Exception e) {}
	}
	
	
}
