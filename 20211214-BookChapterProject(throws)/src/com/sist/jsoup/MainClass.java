package com.sist.jsoup;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;

public class MainClass {
	
/*
 	public static void main(String[] args) throws IOException{
		try
		{
			//���������� ����Ǵ� ����
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		//	System.out.println(doc.toString());
			Elements title=doc.select("a.title");
			for(int i=0;i<title.size();i++)
			{
				System.out.println((i+1)+"."+title.get(i).text());
			}
		} catch (Exception ex)
		{
			ex.printStackTrace(); 	// ����Ȯ��
		}
	}
	
*/	
	//  catch �� ���� ����
	//  throws �� ������ �� �� ���� ����Ȯ�θ� ����
	
	public static void main(String[] args) throws Exception {
		//���������� ����Ǵ� ����
		org.jsoup.nodes.Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		org.jsoup.select.Elements title=doc.select("a.title");
		for(int i=0;i<title.size();i++)
		{
			System.out.println((i+1)+"."+title.get(i).text());
		}	
	}
}
