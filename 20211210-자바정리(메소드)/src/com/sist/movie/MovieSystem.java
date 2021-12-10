package com.sist.movie;
/*
 * 영화시스템 → 메소드
 * 1. 데이터를 수집 → 공통으로 사용(static)
 * 2. 
 */

import java.util.*;
import java.io.*;	// 

public class MovieSystem {
	
	// 1. 공유할 데이터 선언
	private static MovieVO[] movie_data=new MovieVO[1938];
	// 사용자정의 클래스 → 일반 데이터형과 동일하게 사용함
	// class → 데이터를 모아서 관리
	// 클래스배열, String[] → 객체배열
	// movie_data → 값을 첨부
	static
	{
		//초기화 블록
		try {
			FileReader fr=new FileReader("M:\\java1\\movie.txt");
			// 파일읽기
			StringBuffer sb=new StringBuffer();
			// String totalFile="";
			int i=0;
			// 'A' → 65, 'a' → 97
			while((i=fr.read())!=-1)  // -1(EOF → end of file)
			{
				// totalFile+=String.valueOf((char)i);
				sb.append(String.valueOf((char)i));
			}
			
			// System.out.println(sb.toString());
			String movie=sb.toString();
			String[] m=movie.split("\n");
			System.out.println("총 영화수:"+m.length+"편");
			for(int j=0;j<m.length;j++)
			{
				String[] rm=m[j].split("\\|");
				// Split → 정규식(^ $ + * | .)
				// AI(형태분석)
				MovieVO vo=new MovieVO();
				vo.setNo(Integer.parseInt(rm[0])); // String → int
				// Integer.parseInt → Wrapper(각 데이터형별로 클래스가 만들어져있다)
				 vo.setTitle(rm[1]);
				 vo.setGenre(rm[2]);
				 vo.setPoster(rm[3]);
				 vo.setActor(rm[4]);
				 vo.setRegdate(rm[5]);
				 vo.setGrade(rm[6]);
				 vo.setDirector(rm[7]);
				movie_data[j]=vo;

			}
		}catch(Exception ex) {}
	}
	// 메소드(영화관련)
	// 1. 찾기(제목,출연,장르) → 결과값을 받아서 출력, 메소드 안에 출력
	public void titleFind(String title)
	{
		for(MovieVO vo:movie_data)
		{
			if(vo.getTitle().contains(title))
			{
				// contains(title) → () 단어를 포함한다 → 오라클(LIKE)
				System.out.println(vo.getTitle());
			}
		}
	}
	public void actorFind(String name)
	{
		for(MovieVO vo:movie_data)
		{
			if(vo.getActor().contains(name))
			{
				System.out.println(vo.getTitle()+"("+vo.getActor()+")");
			}
		}
	}
	public void genreFind(String genre)
	{
		for(MovieVO vo:movie_data)
		{
			if(vo.getGenre().contains(genre))
			{
				System.out.println(vo.getTitle()+"("+vo.getGenre()+")");
			}
		}
	}
	public static void main(String[] args) {
		MovieSystem ms=new MovieSystem();
		Scanner scan=new Scanner(System.in);
		System.out.println("영화제목 입력:");
		String title=scan.next();
		ms.titleFind(title);
		
		System.out.println("==============================");
		
		System.out.println("주인공 이름 입력:");
		String actor=scan.next();
		ms.actorFind(actor);		// 사용자가 입력하는건 매개변수로 들어온다?
		
		System.out.println("==============================");
		
		System.out.println("장르 입력:");
		String genre=scan.next();
		ms.genreFind(genre);
	}
/*	
 * public static void main(String[] args) {
			MovieSystem ms=new MovieSystem();
		for(MovieVO vo:MovieSystem.movie_data)
		{
			System.out.println("제목:"+vo.getTitle());
			System.out.println("장르:"+vo.getGenre());
			System.out.println("===============================");
		}
	}
*/
}
