package com.sist.io;
/*
 * 1. �� �� File���� 
 * 	1) byte stream : 1byte(�б�/����) �� �Ϲ�����
 * 				- ~InputStream, ~OutputStream
 * 				- FileInputStream, FileOutputStream
 * 				  ObjectInptStream, ObjectOutputStream
 * 	2) ���� stream : 1byte(�б�/����)
 * 				- ���Ͽ� �ִ� ������(�ѱ��� ����), �ѱ�(2byte)
 * 				- ~Reader, ~Writer
 *  3) ����stream : Buffered �� �����͸� �޸𸮿� �ѹ��� ��Ҵٰ� ���
 *  				�� �ӵ��� ����
 *  4) ��Ʈ��(Stream) : �����Ͱ� �̵��ϴ� ���
 *  			- �ܹ������(�б�/����) �� ����
 *  			- ��Ʈ��ũ �� ���α׷� 2���� ���ÿ� ����(������)
 *  =====================================================
 *  
 *  File : ����/ ���丮
 *  	- FileInputStream(�б�) / FileOutputStream(����) �� 1byte
 *  	- FileReader(�б�) / FileWriter(����) �� �ѱ�(2byte)
 *  	- BufferedReader �� �ѱۿ� ��Ƽ� ó��
 *  	- ObjectInputStream, ObjectOutputStream �� ��ü����
 *  	- �ø�������� �� ����ȭ �� ������ȭ
 *  	- InputStream Reader �� 1byte�� �о�� 2byte�� ��ȯ
 *  	  �� InputStream(���ڵ�) Reader(���ڵ�)
 *  
 *  File : ���Ͽ� ���� / ��������
 *  	�� �⺻���� ���(�޼ҵ�)
 *  1. ���������б�(������)
 *  	File file=new File("c:\\javaDev\\a.txt")
 *  		�� ���������б�(���ϸ���� ����)
 *  	File dir=new File("c:\\javaDev")
 *  		�� ���丮(��������) �б�
 *  
 *  2. ���ϸ� �б�
 *  	- getName() : ���� ���ϸ� �б� : a.txt
 *  	- getPath() : c:\\javaDev\\a.txt
 *  	- getParent : c:\\javaDev
 *  
 *  3. ����Ư��
 *  	- �б����� : canRead() �� boolean
 *  	- �������� : canWrite() �� boolean
 *  	- �������� : isHidden() �� boolean
 *  
 *  4. ����
 *  	- ���� : isFile()
 *  	- ���� : isDirectory()
 *  
 *  5. ����
 *  	- ���ϸ���� : createNewFile()
 *  	- ��������� : mkdir()
 *  
 *  6. ���� : ����/���� �� delete()
 *  	- ���������� : ������ ������ ������ ��� �� �������� ����
 *  				�� �����ȿ� �ִ� ��� ������ ������ �� ���� ����
 *  7. listFiles() : �������ִ� ��� ���ϰ� ������ �б�
 *  8. exists() : ���翩�� Ȯ��
 *  9. lastModified() : ����/��¥
 *  ===================================================
 *  
 *  1. �����ϴ� ����
 *  	- ������ �Ѱ��� �����ϴ� �޸� ���� : ����
 *  		10 �� a(�޸��ּ� ��Ī) �� int a=10;
 *  	- ������ �������� ���������� ���� : �迭
 *  		0x100 �� arr �� int[] arr={10,20,30};
 *  	- �����͸� ���ķ� �����ϴ� ��� : Ŭ����
 *  		class A
 *  		{
 *  			int age;
 *  			String name;
 *  			String
 *  		}
 *  			�� 0x100 �� a �� A a=new A(); �ٸ� ���������� ��Ƽ� ó��
 *  	�� �޸𸮿� ����(���α׷� �����Ŀ� �ڵ����� �������)
 *  - �������� ������ġ
 *  - �����͸� ��� ����
 *  	1) ���� : ���ȿ� ��� �� RDBMS(����Ŭ)
 *  	2) ���õ� �����͸� ��Ƽ� �����ϱ� ����� 
 *  - ����°� ���� �� java.io �� CheckException(����ó��) 
 */
import java.io.*;
import java.util.*;
import java.text.*;
public class MainClass {
	public static void main(String[] args) {
		try
		{
			// ������๮��
			// 1. File�� ���� ����
			// 1-1. ���ϰ��������
				File file=new File("c:\\javaDev\\movie.txt");
			// ������ ������ �ִ� ���� ����
			// 1. ���� �̸� �б�
				System.out.println("���ϸ�: "+file.getName());
			// 2. ��θ� �����ؼ� �б�
				System.out.println("�������: "+file.getPath());
			// 3. ��θ� �б�
				System.out.println("��θ�: "+file.getParent());
			// 4. ������ ��¥
				Date date=new Date(file.lastModified());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				System.out.println("������: "+sdf.format(date)); // �� long������ ������ 
			// 5. ������ ũ��
				String temp=file.length()>1024?(file.length()/1024)+"KB":
											(file.length())+"Bytes";
											
				System.out.println("����ũ��: "+file.length()+"Bytes");
				System.out.println("����ũ��: "+temp);
			// 6. Ư��(��������,�б�����,��������)
				System.out.println("��������: "+file.isHidden());
				System.out.println("�б�����: "+file.canRead());
				System.out.println("��������: "+file.canWrite());
			// 7. ����,���丮���� Ȯ��
				System.out.println("���Ͽ���: "+file.isFile());
				System.out.println("���丮����: "+file.isDirectory());
			// 8.��Ÿ
				System.out.println("������: "+file.getAbsolutePath());
		}catch(Exception e)
		{
			e.printStackTrace();	//����ó��(Ȯ��)
		}
	}	
}
