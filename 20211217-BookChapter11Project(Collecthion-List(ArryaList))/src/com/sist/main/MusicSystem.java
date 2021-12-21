package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicSystem {
	private static ArrayList list=new ArrayList(); // 뮤직의 전체정보
	// 음악정보는 1개만 사용하면된다(static) → 공동으로 사용하는 데이터
	
	// 1.데이터 초기화(저장) → 오라클
	// 데이터를 읽어서 초기화(구현) → 초기화블록(호출없이 자동처리), 생성자
	// 초기화블록 이용하여 데이터를 메모리에 저장
	static
	{
		try
		{
		// 1. 사이트 연결 → 서버에서 가지고오는 데이터를 저장
		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		// 2. 해당데이터 읽기
		Elements title=doc.select("td.info a.title"); 	//테이블 이름을 잘 보면됨
		Elements singer=doc.select("td.info a.artist");
		Elements album=doc.select("td.info a.albumtitle");
		
		// 3. Music에 저장
		for(int i=0;i<title.size();i++)
		{
			Music music=new Music();
			// 초기값
			music.setTitle(title.get(i).text());
			music.setSinger(singer.get(i).text());
			music.setAlbum(album.get(i).text());
			list.add(music);

		}
		// 4. list에 추가
		
		}catch(Exception ex) {}
	}
	// 목록 출력
	public ArrayList musicListData()
	{
		return list;
	}
	// 찾기 → 제목,가수명,앨범 → contains
	public ArrayList musicFinddata(String fd)
	{
		ArrayList fList=new ArrayList();// 찾은 데이터만 모아서 전송
		for(int i=0;i<list.size();i++)
		{
			Music m=(Music)list.get(i); // 저장되어있는 music을 1개씩 읽어옴
			if(m.getTitle().contains(fd))
			{
				// 노래제목안에 사용자가 보내준 검색어가 포함여부 확인
				fList.add(m);
			}
		}
		return fList;
	}
	// 추가
	
	
	
}
