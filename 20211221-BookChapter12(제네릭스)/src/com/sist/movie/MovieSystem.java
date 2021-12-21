package com.sist.movie;
/*
 * Back-End
 */
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class MovieSystem {
	// 1.영화의 모든 정보를 가지고 있음
	// 2.모든 클라이언트(사용자) → 같은 데이터를 사용 → 공유
	// 3.공유 → static(stiatic공간 → 메모리공간이 1개)
	// 4.static → 모든데이터를 공유할 수 있는내용 →오라클
	// 5.영화 1개에 대한 정보 → Movie → 여러개(저장) 
	// → 배열 / Collection
	// 배열 → 영화갯수확인(고정), Collection → 가변 
	
	private static ArrayList<Movie> list=new ArrayList<Movie>();
	// list=null → size=0 → 초기화
	/*
	 * 명시적 초기화 → X 일반데이터만 처리
	 * 초기화 블록 → 외부 데이터를 읽어서 대입
	 * 			→ 클래스가 로드되었을 때 자동으로 수행하는 명령(초기화블록이 수행)ㄴ
	 * 생성자 → 외부에서 데이터를 읽어서 대입
	 */
	static
	{
		// 데이터 읽기
		// 1. 사이트에 연결(네트워크 → CheckException) / 반드시 예외처리
		// 1.IO(파일입출력) 2.쓰레드 3.네트워크 4.SQL(데이터베이스)
		try
		{
			//사이트연결 → 데이터를 읽어서 출력(Document : 문서저장)
			Document doc=Jsoup.connect("https://movie.daum.net/ranking/reservation").get();
			Elements title=doc.select("strong.tit_item a.link_txt");
			// Element  → 태그 한개를 모아준다
			// Elements → 같은 태그 여러개를 모아준다
			Elements score=doc.select("span.txt_grade");
			Elements reserve=doc.select("span.info_txt span.txt_num");
			Elements story=doc.select("a.link_story");
			Elements regdate=doc.select("span.txt_info span.txt_num");
			for(int i=0;i<title.size();i++)
			{
				System.out.println(title.get(i).text());
				System.out.println(score.get(i).text());
				System.out.println(reserve.get(i).text());
				System.out.println(regdate.get(i).text());
				System.out.println(story.get(i).text());
				System.out.println("=============================");
			
				Movie m=new Movie();
				m.setNo(i+1);
				m.setTitle(title.get(i).text());
				m.setStory(story.get(i).text());
				m.setReserve(reserve.get(i).text());
				m.setRegdate(regdate.get(i).text());
				m.setScore(Double.parseDouble(score.get(i).text()));
				// 한개의 영화정보 → 20개
				list.add(m);
				//변수(여러개) → 클래스 묶는다 → 여러개 → Collection
			}
		}catch(Exception ex)
		{
			//System.out.println(ex.getMessage()); // 오류메세지 출력
			ex.printStackTrace(); 		// 어디서 오류가 났는지 확인
		}
	}
	// 1. 종류별목록
	// ArrayList<Movie> → 영화정보 전체
	// Movie → 영화 한개
	public ArrayList<Movie> movieAllData()
	{
		return list;
	}
	// 2. 상세보기(영화한개에 대한 정보를 본다)
	public Movie movieDetailData(int no)
	{
		Movie m=new Movie();
		for(Movie mm:list)
		{
			if(mm.getNo()==no)
			{
				m=mm;
				break;
			}
		}
		return m;
	}
	// 3. 찾기 → 영화가 여러개 있는 경우도 있다
	public ArrayList<Movie> movieFind(String title)
	{
		ArrayList<Movie> mList=new ArrayList<Movie>();
		// mList에 찾은 영화 모아서 넘겨준다
		for(Movie m:list)
		{
			if(m.getTitle().contains(title))
			{
				mList.add(m);
			}
		}
		return mList;
	}
}



