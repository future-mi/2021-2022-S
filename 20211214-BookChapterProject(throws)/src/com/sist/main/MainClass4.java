package com.sist.main;
//finally → close(), 파일, 서버, 데이터베이스
//try, catch 수행과 관계없이 무조건 수행하는 문장
import java.io.*;

public class MainClass4 {
/*
 	public static void main(String[] args) throws Exception{
		//파일읽기
		FileReader fr=new FileReader("M:\\java1\\movie.txt");
		int i=0; // 읽은데이터 → char(ASC)
		while((i=fr.read())!=-1)		// -1(EOF)
		{
			System.out.print((char)i);
		}
		
		fr.close();
	}
*/
/*	
	public static void main(String[] args) {
		FileReader fr=null;		// main전체에서 사용
		try
		{
			fr=new FileReader("M:\\java1\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				System.out.println((char)i); //읽은 파일을 출력
			}
		} catch (FileNotFoundException e){}
		  catch (IOException e){}
			// ↓ finally는 평상시에 사용빈도가 낮다(데이터베이스,네트워크, 파일에 사용)
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
			// try 블록을 벗어나면 자동으로 close()가 호출
		}catch(Exception e) {}
	}
	
	
}
