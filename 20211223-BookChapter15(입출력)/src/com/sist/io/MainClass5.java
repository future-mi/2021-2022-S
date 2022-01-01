package com.sist.io;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

/*
 * ���Ͽ� ����
 * FileOutputStream(1byte) �� ����Ʈ��Ʈ��(�ѱ�)
 * FileWriter(2byte) �� ���ڽ�Ʈ��
 * 
 * 
 * 
 */
public class MainClass5 {
	// ��������� �ڵ� �ʱ�ȭ
	public static void main(String[] args) {
		FileOutputStream fos=null;	//�޼ҵ�(����������ݵ���ʱ�ȭ)
		FileInputStream fis=null;
		try
		{
			// 1.���������
			File dir=new File("c:\\java_data");
			if(!dir.exists())
			{
				dir.mkdir();
				System.out.println("���������Ϸ�");
			}
			// 2.���ϸ����
			File file=new File("c:\\java_data\\student");
			if(!file.exists())
			{
				file.createNewFile();
				System.out.println("���ϻ����Ϸ�");
			}
			// 3.���Ͼ���
			fos=new FileOutputStream(file, true);
		//	String hong="��û��|70|80|90\r\n";
		//	fos.write(hong.getBytes());	
			Scanner scan=new Scanner(System.in);
			String name=scan.next();
			System.out.println("�����Է�:");
			int kor=scan.nextInt();
			System.out.println("�����Է�: ");
			int eng=scan.nextInt();
			System.out.println("�����Է�: ");
			int math=scan.nextInt();
			
			String data=name+"|"+kor+"|"+eng+"|"+math+"\n";
			fos.write(data.getBytes());
			System.out.println("��ϿϷ�");
			// 4.�����б�
			FileReader fr=new FileReader(file);
			int i=0;
			String msg="";
			// ������ ��ü�б�
			while((i=fr.read())!=-1)
			{
				msg+=String.valueOf((char)i);
			}
			 System.out.println(msg);
			 // ������ ����
			 String[] student=msg.split("\n");
			 for(String s:student)
			 {
				 String[] info=s.split("\\|");
				 // ���ڿ� �� �����б�
				 // ������ �ʿ��� ��쿡�� �ݵ�� ��ȯ������Ѵ�
				 System.out.println(info[0]+" "
				 				+info[1]+" "
				 				+info[2]+" "
				 				+info[3]+" "
				 				+(Integer.parseInt(info[1])
				 				+Integer.parseInt(info[2])
				 				+Integer.parseInt(info[3]))
				 				+" "
				 				+(Integer.parseInt(info[1])
						 		 +Integer.parseInt(info[2])
								 +Integer.parseInt(info[3]))/3);
			 }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {}
		}
	}
}
