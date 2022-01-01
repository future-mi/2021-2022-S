package com.sist.io;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

/*
 * 파일에 쓰기
 * FileOutputStream(1byte) → 바이트스트림(한글)
 * FileWriter(2byte) → 문자스트림
 * 
 * 
 * 
 */
public class MainClass5 {
	// 멤버변수는 자동 초기화
	public static void main(String[] args) {
		FileOutputStream fos=null;	//메소드(지역변수→반드시초기화)
		FileInputStream fis=null;
		try
		{
			// 1.폴더만들기
			File dir=new File("c:\\java_data");
			if(!dir.exists())
			{
				dir.mkdir();
				System.out.println("폴더생성완료");
			}
			// 2.파일만들기
			File file=new File("c:\\java_data\\student");
			if(!file.exists())
			{
				file.createNewFile();
				System.out.println("파일생성완료");
			}
			// 3.파일쓰기
			fos=new FileOutputStream(file, true);
		//	String hong="심청이|70|80|90\r\n";
		//	fos.write(hong.getBytes());	
			Scanner scan=new Scanner(System.in);
			String name=scan.next();
			System.out.println("국어입력:");
			int kor=scan.nextInt();
			System.out.println("영어입력: ");
			int eng=scan.nextInt();
			System.out.println("수학입력: ");
			int math=scan.nextInt();
			
			String data=name+"|"+kor+"|"+eng+"|"+math+"\n";
			fos.write(data.getBytes());
			System.out.println("등록완료");
			// 4.파일읽기
			FileReader fr=new FileReader(file);
			int i=0;
			String msg="";
			// 데이터 전체읽기
			while((i=fr.read())!=-1)
			{
				msg+=String.valueOf((char)i);
			}
			 System.out.println(msg);
			 // 데이터 조절
			 String[] student=msg.split("\n");
			 for(String s:student)
			 {
				 String[] info=s.split("\\|");
				 // 문자열 → 파일읽기
				 // 정수가 필요한 경우에는 반드시 변환해줘야한다
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
