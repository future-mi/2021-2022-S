package com.sist.io;
// �������� �� ���� ��� �����б�
import java.io.*;
import java.util.*;
public class Mainclass2 {
	public static void main(String[] args) {
		try
		{
			File dir=new File("C:\\java_data");
			System.out.println("������: "+dir.getName());
			System.out.println("��θ�: "+dir.getPath());
			System.out.println("ũ��: "+dir.length());
			System.out.println("������: "+dir.lastModified());
			System.out.println("=====�����ȿ� �ִ� ��� ���� �б�=====");
			
			File[] files=dir.listFiles(); 	// ���ε��Ҷ� ���� ������ �ö�ü�����
			//	 ���� �����ȿ��� ���� ���ϸ��� �ø� ������
			HashSet<String> set=new HashSet<String>();
			for(File f:files)
			{
				if(f.isFile())	// ������ ��쿡�� ���
				{
					// System.out.println(f.getName());
					// Ȯ���ڸ� ���
					String name=f.getName();
					String ext=name.substring(name.lastIndexOf(".")+1);
					System.out.println(ext);
					set.add(ext);
				}
			}
			// �ߺ��� ���� Ȯ���ڸ� ��� �� HashSet
			// �ߺ��� ���� Ȯ���ڸ� ���
			System.out.println("====�ߺ����� Ȯ���� ���====");
			for(String s:set)
			{
				System.out.println(s);
			}
			/*
			 * ������ �б� �� ���������� �б�
			 * 	�� �ߺ����� ���� : HashSet
			 */
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}