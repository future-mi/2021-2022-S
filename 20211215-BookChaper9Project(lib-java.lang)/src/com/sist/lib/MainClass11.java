package com.sist.lib;
/*
 * StringBuffer : ����ȭ
 * StringBuilder : �񵿱�ȭ
 * ������ ���� �� �������� String
 */
import java.io.*;
public class MainClass11 {
	public void stringuse()
	{
		String movie="";
		long start=System.currentTimeMillis(); 	// log����
		// �����б�
		// IOException  CheckException
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				movie+=String.valueOf((char)i);
			}
			fr.close();
			System.out.println(movie);
		}catch(Exception ex) {}
		long end=System.currentTimeMillis();
		System.out.println("����ð�: "+(end-start));
	}
	
	// ���ڿ� ������ ����ȭ�� StringBuffer ���
	
	public void StringBufferUse()
	{
		StringBuffer sb=new StringBuffer();
		long start=System.currentTimeMillis(); 	// log����
		// �����б�
		// IOException  CheckException
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			System.out.println(sb.toString());
			
		}catch(Exception ex) {}
		long end=System.currentTimeMillis();
		System.out.println("����ð�: "+(end-start));
	}
	
	public void StringBilderUse()
	{
		StringBuilder sb=new StringBuilder();
		long start=System.currentTimeMillis(); 	// log����
		// �����б�
		// IOException  CheckException
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			System.out.println(sb.toString());
			
		}catch(Exception ex) {}
		long end=System.currentTimeMillis();
		System.out.println("����ð�: "+(end-start));
	}
	
	public static void main(String[] args) {
		MainClass11 m=new MainClass11();
//		m.stringuse();		 // ����ð� 70227
//		m.StringBufferUse(); // ����ð� 820
		m.StringBilderUse(); // ����ð� 899
		
	}
}
