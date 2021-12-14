package com.sist.lib;
// contains() → 문자열중에 포함되었는지 여부 / LIKE
/*
 * 	원형 : public boolean contains(String word) → 자바스크립트(SearchBar)
 */
import java.util.*;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
// 영화추천, 블로그, 카페에서 입력글을 읽는다 → 실시간(트위터)

/*	<div class="wrap_song_info">
<div class="ellipsis rank01"><span>
<a href="javascript:melon.play.playSong('1000002721',34298499);" title="리무진 (Feat. MINO) (Prod. GRAY) 재생">리무진 (Feat. MINO) (Prod. GRAY)</a>
</span></div><br>    */
public class MainClass6 {

	public static void main(String[] args) {
		//1. 사용자입력
		Scanner scan=new Scanner(System.in);
		System.out.println("검색어 입력: ");
		String fd=scan.next();
		
		//2.찾기 → contains
		try
		{
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();	
			//사이트에 접근해서 모든 데이터를 읽어와라
			org.jsoup.select.Elements elem=doc.select("div.wrap_song_info a");
			for(int i=0;i<elem.size();i++)
			{
				String ss=elem.get(i).attr("title"); 
				if(ss.contains(fd))
				{
					System.out.println(ss);
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();	// 에러확인
		}
		//3.찾은결과를 보여준다
		
	}
	
}
