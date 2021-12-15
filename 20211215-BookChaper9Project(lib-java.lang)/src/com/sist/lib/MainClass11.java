package com.sist.lib;
/*
 * StringBuffer : 동기화
 * StringBuilder : 비동기화
 * 데이터 수집 → 나머지는 String
 */
import java.io.*;
public class MainClass11 {
	public void stringuse()
	{
		String movie="";
		long start=System.currentTimeMillis(); 	// log파일
		// 파일읽기
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
		System.out.println("수행시간: "+(end-start));
	}
	
	// 문자열 결합의 최적화는 StringBuffer 사용
	
	public void StringBufferUse()
	{
		StringBuffer sb=new StringBuffer();
		long start=System.currentTimeMillis(); 	// log파일
		// 파일읽기
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
		System.out.println("수행시간: "+(end-start));
	}
	
	public void StringBilderUse()
	{
		StringBuilder sb=new StringBuilder();
		long start=System.currentTimeMillis(); 	// log파일
		// 파일읽기
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
		System.out.println("수행시간: "+(end-start));
	}
	
	public static void main(String[] args) {
		MainClass11 m=new MainClass11();
//		m.stringuse();		 // 수행시간 70227
//		m.StringBufferUse(); // 수행시간 820
		m.StringBilderUse(); // 수행시간 899
		
	}
}
