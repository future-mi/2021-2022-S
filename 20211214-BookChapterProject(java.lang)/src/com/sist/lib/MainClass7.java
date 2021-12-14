package com.sist.lib;
/*
 * startWith, endWith → 찾는 문자열이 시작하는 문자열인지 끝나는문자열인지
 * 
 * Java & Spring
 * 자바와 JSP
 * 자바와 오라클
 * 
 * 원형 : public boolean startsWith(String s)
 * 		public boolean endsWith(String s)
 * 
 * 
 */
import java.util.*;
public class MainClass7 {
	public static void main(String[] args) {
		String[] data= {
				"혼자배우는 자바",
				"자바와 오라클",
				"자바기반의 AWS",
				"오라클 프로그램의 이해",
				"자바프로그래밍",
				"JSP AND MVC",
				"Spring Framework",
				"MyBatis프로그래밍",
				"자바를 이용한 챗봇",
				"AWS를 이용한 배포",
		};
		/*
		 * [검색용도]
		 * 시작 문자열 - startsWith
		 * 끝나는 문자열 - endsWith
		 * 포함된 문자열 - comtains
		 */
		// 2.사용자 입력
		Scanner scan=new Scanner(System.in);
		System.out.println("검색어 입력:");
		String fd=scan.next();
		// 3.해당문자열ㅇ르 찾아서 출력
		for(String s:data)
		{
			if(s.contains(fd)) 	
			{
				try
				{
					Thread.sleep(1000);
				}catch(Exception ex){}
				System.out.println(s);

			}
		}
	}
}

/*	자바
 * 	오라클
 * 	HTML/CSS
 *  JavaScript(JQuery,AJAX)
 *  JSP(MVX)
 *	Spring
 *	========================
 *	MyBatis
 *	ReactJS
 *	VueJS
 *	ChatBot
 *	========================
 *	AWS
 *	========================
 *	자바의정석 1권(전체적으로+8장)
 *	자바의정석 2권 - 컬렉션,제네릭스, 10장-SimpleDateFormat
 *			  	11장, 12장
 *				IO(FileReader, FileWriter, BufferReader)
 *
 */

