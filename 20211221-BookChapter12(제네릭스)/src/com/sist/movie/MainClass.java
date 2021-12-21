package com.sist.movie;
// 사용자프로그램(Front)
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		
		MovieSystem ms=new MovieSystem();
		MainClass mc=new MainClass();
		while(true)
		{
			int m=mc.menu();
			switch(m)
			{
			case 1:
			{
				ArrayList<Movie> list=ms.movieAllData();
				// 영화 전체목록을 가지고 온다.
				for(Movie mm:list)
				{
					System.out.println(mm.getNo()+"."+mm.getTitle()+"("+mm.getScore()+")");
				}
			}	
				break;
			case 2:
			{
				Scanner scan=new Scanner(System.in);
				System.out.print("상세히 볼 영화 선택(1~20):");
				int no=scan.nextInt();
				Movie mm=ms.movieDetailData(no);
				System.out.println("순위: "+mm.getNo());
				System.out.println("영화명: "+mm.getTitle());
				System.out.println("평점:"+mm.getScore());
				System.out.println("예매율:"+mm.getReserve());
				System.out.println("개봉일:"+mm.getRegdate());
				System.out.println(mm.getStory());
				
			}
				break;
			case 3:
			{
				Scanner scan=new Scanner(System.in);
				System.out.println("검색어 입력");
				String title=scan.next();
				ArrayList<Movie> list=ms.movieFind(title);
				for(Movie mm:list)
				{
					System.out.println(mm.getTitle());
				}
			}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다");
				System.exit(0);	// 정상종료, break를 쓰면 while문만 나가짐
			}
		}
	}
	
	public int menu()
	{
		System.out.println("======메뉴======");
		System.out.println("1. 영화목록보기");
		System.out.println("2. 영화상세보기");
		System.out.println("3. 영화 찾기");
		System.out.println("4. 종료");
		System.out.println("===============");
		
		Scanner scan=new Scanner(System.in);
		System.out.println("메뉴선택 (1~4):");
		return scan.nextInt();
	}
	
}
