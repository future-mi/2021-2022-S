package com.sist.io;
/*
 * 파일에 있는 전체 데이터를 메모리에 한번에 저장 후 읽는 프로그램
 * BufferReader → 한줄씩 읽어온다
 */
import java.io.*;

public class MainClass7 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream("c:\\java_data\\news.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			// 1byte를 2byte로 변경(한글이 정상적으로 수행)
			while(true)
			{
				String data=br.readLine();
				if(data==null) break; // 값이 없는 경우에는 종료
				System.out.println(data);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();	// 에러처리
		}
		finally
		{
			try
			{
				fis.close();	// 에러여부에 상관없이 파일닫기
			} catch (Exception ex) {}
		}
	}
}
