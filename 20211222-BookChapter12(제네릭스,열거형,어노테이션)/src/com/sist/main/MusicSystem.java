package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MusicSystem {
	// Music 전체 데이터를 공유 → static(오라클 : static)
	private static ArrayList<Music> list=new ArrayList<Music>();
	
	// 프로그램 시작과 동시에 데이터를 모아둔다(초기화)
	static
	{
		// 웹 연결(네트워크) → CkeckException
		try
		{
			// 서버연결 후 읽어온 데이터를 저장
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			 Elements title=doc.select("tr.list a.title");
			 Elements singer=doc.select("tr.list a.artist");
			 Elements album=doc.select("tr.list a.albumtitle");
			for(int i=0;i<title.size();i++)
			{
				System.out.println("순위:"+(i+1));
				System.out.println(title.get(i).text());
				System.out.println(singer.get(i).text());
				System.out.println(album.get(i).text());
				System.out.println("==================================");
				
				// ArrayList에 데이터 저장
				// 1. 데이터 클래스에 저장
				Music m=new Music();
				m.setRank(i+1);
				m.setTitle(title.get(i).text());
				m.setSinger(singer.get(i).text());
				m.setAlbum(album.get(i).text());
				
				// 2. 저장된클래스 → ArrayList에 저장
				list.add(m);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 기능
	// 전체 목록
	public ArrayList<Music> musicAllData()
	{
		return list;
	}
	// 찾기
	public ArrayList<Music> musicFindData(String ss)
	{
		// ss → searchString
		// 찾은 데이터를 다시 모아서 전송
		ArrayList<Music> mList=new ArrayList<Music>();
		for(Music m:list)
		{
			if(m.getTitle().contains(ss))
			{
				mList.add(m);
			}
		}
		return mList;
	}
	// 중복없는 가수 출력 → HashSet
	public ArrayList<String> singerData()
	{
		ArrayList<String> sList=new ArrayList<String>();
		HashSet<String> set=new HashSet<String>();
		for(Music m:list)
		{
			set.add(m.getTitle()); // 중복된 가수명은 제거
		}
		sList.addAll(set);
		return sList;
	}
}
