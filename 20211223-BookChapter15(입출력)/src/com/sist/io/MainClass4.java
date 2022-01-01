package com.sist.io;
/*
 * 파일 입출력 → 영구적인 저장
 * 
 * - FileInputStream(읽기) / FileOutputStream(쓰기) → 영문,숫자
 * - FileReader(읽기) / FileWriter(쓰기) → 한글 저장
 * 
 * 파일쓰기 → 모드(w,a)
 * 	- w : create (파일을 덮어쓴다) → 기존에 있는 데이터를 지우고 새로운 파일 생성
 *  - a : append → 기존에 있는 데이터를 그대로둔 상태에서 데이터 추가
 *  [한글저장]
 * 		FileWriter fw=new FileWriter("경로명") → w
 * 		FileWriter fw=new FileWriter("경로명",true) → a
 * 	[파일복사,업로드]
 * 		FileOutputStream fis=new FileOutputStream("경로명") → w
 * 		FileOutputStream fis=new FileOutputStream("경로명",true) → a
 */

// 파일읽기 → InputStream, Reader
import java.io.*;
public class MainClass4 {
	public static void main(String[] args) {
//		FileInputStream fis=null; 	// 1byte씩 읽어오는 클래스
		FileReader fis=null; 	// 한글까지 읽을 수 있음
		// 그림파일, zip파일
		// 한글은 기본 2byte → 문자스트림
		try
		{
			// 자바에서는 경로설정시 반드시 \\로 설정
//			fis=new FileInputStream("M:\\java1\\20211223-BookChapter15(입출력)\\src\\com\\sist\\io\\MainClass.java");
			fis=new FileReader("D:\\java1\\20211223-BookChapter15(입출력)\\src\\com\\sist\\io\\MainClass.java");
			// 1byte로 읽는다 → 한글자씩 읽어온다 → int(문자의 번호)
			// A → 65
			int i=0; 	// 문자 한개를 받아서 저장할 변수
			// 파일의 끝까지 읽는다(EOF → End of File) → -1
			while((i=fis.read())!=-1)	// 모든 데이터를 읽어와라
				{
					System.out.print((char)i);
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// 서버닫기, 파일닫기, 오라클닫기
			try
			{
			fis.close();	// 예외처리가 필요
			}
			catch(Exception ex) {}
		}
	}
}
