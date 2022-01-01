package com.sist.main;
/*
 * 요청처리 → 사용자 → 결과를 보내주는 역할 → 스프링
 * 데이터를 묶어서 저장
 */
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
// 카테고리 → 파일저장 → 클라이언트 전송(ArrayList → 파일)
// 맛집정보 → 파일저장 → 클라이언트 전송(ArrayList → 파일)
public class FoodSystem {
	public static void main(String[] args) {
		FoodSystem f=new FoodSystem();
	}
	// 1.실행 → 파일에 저장
	// 1-1. 초기화 블록 → 시작과 동시에 수행 가능
	// 1-2. 생성자 → 시작과 동시에 호출
	public FoodSystem()
	{
		try
		{
			Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
			Elements title=doc.select("div.top_list_slide span.title");
			Elements subject=doc.select("div.top_list_slide p.desc");
			StringBuffer sb=new StringBuffer();
			
			
			for(int i=0;i<title.size();i++)
			{
				System.out.println(title.get(i).text());
				System.out.println(subject.get(i).text());
				System.out.println("\n");
				
				String data=(i+1)+"|"+title.get(i).text()+"|"
							+subject.get(i).text();
				sb.append(data);
			}
			File file=new File("c:\\java_data\\category.txt");
			if(file.exists())
			{
				file.createNewFile(); 
				System.out.println("파일생성완료");
			}
			// 파일에 카테고리 저장하기
			FileWriter fw=new FileWriter(file);
			fw.write(sb.toString());
			fw.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}	
	// 2.사용자가 요청 → 파일을 읽어서 ArrayList에 저장 후 전송
}
