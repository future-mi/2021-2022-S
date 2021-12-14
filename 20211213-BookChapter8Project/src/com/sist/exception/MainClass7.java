package com.sist.exception;
// Check Exception → 컴파일러가 감시

import java.io.*; 	// 데이터 읽기
import java.net.*;  // 웹사이트 연결

// → 예외처리를 반드시  

public class MainClass7 {
	public static void main(String[] args) {
		try
		{
			/*
			 * 		URLconnection(상위클래스)
			 * 			|
			 * 		HttpURLConnection(하위클래스) 
			 * 
			 * 		HttpURLConnection conn=(HttpURLConnectio)new URLConnection();  // 형변환 시켜줘야함
			 */
			// 1.웹사이트 연결
			URL url=new URL("https://mabinogi.nexon.com/page/main/index.asp");
			HttpURLConnection conn=(HttpURLConnection) url.openConnection(); 	// 예외처리를 반드시 해야함
			
			if(conn!=null)		// 연결되었다면
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true)
				{
					String s=br.readLine();
					if(s==null) break;
					System.out.println(s);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
