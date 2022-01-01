package com.sist.main;
import java.util.*;

enum 사이트
{
	DAUM("www.daum.net"),
	NAVER("www.naver.com"),
	GOOGLE("www.google.co.kr"),
	SIST("www.sist.co.kr"),
	NATE("www.nate.com");
	
	private String site;
	
	사이트(String site)
	{
		this.site=site;
	}
	
	public String getSite()
	{
		return site;
	}
}

// "C:\Program Files\Google\Chrome\Application\chrome.exe"
public class MainClass3 {
	public static void main(String[] args) {
		// 사용자로부터 값을 받는다
		Scanner scan=new Scanner(System.in);
		System.out.println("방문할 사이트 입력:");
		String s=scan.next();
		
		// 사이트찾기
		for(사이트 site:사이트.values())
		{
			if(site.name().equalsIgnoreCase(s))
			{
				String ss=site.getSite();
				try
				{
					// exe파일 실행시에 사용 → CheckException 드시 예외처리 하고 사용
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+ss);
				}catch(Exception ex) {}
			}
		}
	}
}
