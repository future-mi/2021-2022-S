package com.sist.main;
import java.util.*;

enum ����Ʈ
{
	DAUM("www.daum.net"),
	NAVER("www.naver.com"),
	GOOGLE("www.google.co.kr"),
	SIST("www.sist.co.kr"),
	NATE("www.nate.com");
	
	private String site;
	
	����Ʈ(String site)
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
		// ����ڷκ��� ���� �޴´�
		Scanner scan=new Scanner(System.in);
		System.out.println("�湮�� ����Ʈ �Է�:");
		String s=scan.next();
		
		// ����Ʈã��
		for(����Ʈ site:����Ʈ.values())
		{
			if(site.name().equalsIgnoreCase(s))
			{
				String ss=site.getSite();
				try
				{
					// exe���� ����ÿ� ��� �� CheckException ��� ����ó�� �ϰ� ���
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+ss);
				}catch(Exception ex) {}
			}
		}
	}
}
