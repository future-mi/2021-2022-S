package com.sist.jsoup;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;

public class MainClass {
	
/*
 	public static void main(String[] args) throws IOException{
		try
		{
			//정상적으로 실행되는 문장
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		//	System.out.println(doc.toString());
			Elements title=doc.select("a.title");
			for(int i=0;i<title.size();i++)
			{
				System.out.println((i+1)+"."+title.get(i).text());
			}
		} catch (Exception ex)
		{
			ex.printStackTrace(); 	// 에러확인
		}
	}
	
*/	
	//  catch → 복구 가능
	//  throws → 복구는 할 수 없고 에러확인만 가능
	
	public static void main(String[] args) throws Exception {
		//정상적으로 실행되는 문장
		org.jsoup.nodes.Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		org.jsoup.select.Elements title=doc.select("a.title");
		for(int i=0;i<title.size();i++)
		{
			System.out.println((i+1)+"."+title.get(i).text());
		}	
	}
}
