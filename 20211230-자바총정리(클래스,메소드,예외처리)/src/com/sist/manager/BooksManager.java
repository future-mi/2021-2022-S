package com.sist.manager;
import java.io.*;
import java.net.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.Books;
import com.sist.dao.BooksDAO;

public class BooksManager {
	// 웹에서 데이터를 읽은 후 → 오라클에 저장
	/*
	 * 1. 오라클에 저장공간 → TABLE
	 * ==== 데이터베이스 설계
	 * 2. 자바에 데이터를 모은다 → BOOKS
	 * 3. 자바에서 오라클 연결 → BOOKsDAO
	 * 4. 웹 데이터 읽기 → DAO로 전송
	 * ==== 데이터 수집 
	 */
	// 오라클연결 → BooksDAO
	// try~catch(예외복구), throws(예외회피 → 선언)
	// 사전에 에러발생을 차단하는 프로그램 → 에러수정 X, 에러난 부분 통과
	
	private BooksDAO dao=new BooksDAO();	// 데이터를 오라클에 추가
	public void booksGetData()
	{
		try
		{
			// 파일읽기 → 저장
			StringBuffer sb=new StringBuffer();		// 양이많으면 StringBuffer 쓰는게 더 빠름
			FileInputStream fis=new FileInputStream("c:\\javaDev\\books.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));
			
			// 파일전체를 읽어서 임시저장
			// UTF-8 → EUC-KR
			while(true)
			{
				String data=br.readLine();
				if(data==null) break;
				sb.append(data);
			}
			//	System.out.println(sb.toString()); 	//메모리에 저장된 데이터를 출력
			// <> → 태그별 데이터 수집 
			// <div id="a"> → div#a
			// <div class="b"> → div.b
			Document doc=Jsoup.parse(sb.toString());
			/*
			 * connect() → 실제 URL을 이용해서 웹 서버에 접근
			 * parse() → HTML문자열, 파일
			 */
			Elements title=doc.select("h4.main-title");
			Elements poster=doc.select("div.book-list-image img");
			Elements content=doc.select("div.sub-title");
			Elements author=doc.select("div.book-info span.author");
			Elements price=doc.select("div.book-info");
			Elements regdate=doc.select("div.book-info span.pub-date");
			Elements isbn=doc.select("div.book-info span.isbn");
			Elements tags=doc.select("div.book-info span.tag");
			/*
			 * <div>값</div> → text()
			 * <img src="값"> → attr("src")
			 */
			for(int i=0;i<title.size();i++)
			{
				String title_data=title.get(i).text();
				String poster_data=poster.get(i).attr("src");

				String author_data=author.get(i).text();
				String regdate_data=regdate.get(i).text()
								.replace("|","");
				String isbn_data=isbn.get(i).text();
				String tags_data=tags.get(i).text();
				
				String cd="";
				try
				{
					String content_data=content.get(i).text();
					cd=content_data;
				}catch(Exception ex) {}
				
				String price_data=price.get(i).text();
				String p="";
				StringTokenizer st=new StringTokenizer(price_data,"|");
				int count=st.countTokens();
				if(count==4)
				{
					String[] ss=price_data.split("\\|");
					p=ss[1];
				}
				else
				{
					String[] ss=price_data.split("\\|");
					p=ss[2];
				}
				System.out.println("번호:"+(i+1));
				System.out.println("저자:"+title_data);
				System.out.println("그림:"+poster_data);
				System.out.println("소개:"+cd);
				System.out.println("가격:"+p);
				System.out.println("등록일:"+regdate_data);
				System.out.println("isbn:"+isbn_data);
				System.out.println("태그:"+tags_data);
				
				// 오라클에 데이터 첨부
				Books book=new Books();
				book.setNo(i+1);
				book.setTitle(title_data);
				book.setPoster(poster_data);
				book.setContent(p);
				book.setRegdate(regdate_data);
				book.setIsbn(isbn_data);
				book.setTags(tags_data);
				
				dao.dbInsert(book);
				// 읽는속도와 오라클저장속도가 안맞을 수 있음
				Thread.sleep(300);
			}
			System.out.println("********오라클 저장 완료!!*********");
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BooksManager bm=new BooksManager();
		bm.booksGetData();
	}
}
