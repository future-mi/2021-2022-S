package com.sist.io;
// FileWriter → 2byte로 저장 → 문자 스트림
// byte변환 없이 → String을 그대로 첨부가 가능
// default(w) → 실행시마다 새로운 파일을 만들어 준다
// a → new FileWriter("경로명",true) → 데이터추가
import java.io.*;
public class MainClass6 {
	public static void main(String[] args) {
		FileWriter fw=null;
		try
		{
			// 정상수행이 가능하게 만든다
			File file=new File("c:\\java_data\\news.txt");
			if(!file.exists())
			{
				// 파일이 없으면 파일을 만들어라
				// 컴퓨터에 명령
				file.createNewFile();
				System.out.println("파일생성 완료");
			}
			// 파일에 데이터 입력
			/*
			fw=new FileWriter(file,true);	// 계속 입력하겠다
			String news="피곤한 퓨쳐양은 초밥을 시키고 마는데\n";
			fw.write(news);
			System.out.println("데이터 입력 완료");
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