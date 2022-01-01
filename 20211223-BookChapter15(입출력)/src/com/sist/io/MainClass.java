package com.sist.io;
/*
 * 1. 웹 → File관련 
 * 	1) byte stream : 1byte(읽기/쓰기) → 일반파일
 * 				- ~InputStream, ~OutputStream
 * 				- FileInputStream, FileOutputStream
 * 				  ObjectInptStream, ObjectOutputStream
 * 	2) 문자 stream : 1byte(읽기/쓰기)
 * 				- 파일에 있는 데이터(한글이 포함), 한글(2byte)
 * 				- ~Reader, ~Writer
 *  3) 보조stream : Buffered → 데이터를 메모리에 한번에 모았다가 사용
 *  				→ 속도가 빠름
 *  4) 스트림(Stream) : 데이터가 이동하는 통로
 *  			- 단방향통신(읽기/쓰기) → 빨대
 *  			- 네트워크 → 프로그램 2개를 동시에 실행(쓰레드)
 *  =====================================================
 *  
 *  File : 파일/ 디렉토리
 *  	- FileInputStream(읽기) / FileOutputStream(쓰기) → 1byte
 *  	- FileReader(읽기) / FileWriter(쓰기) → 한글(2byte)
 *  	- BufferedReader → 한글에 모아서 처리
 *  	- ObjectInputStream, ObjectOutputStream → 객체단위
 *  	- 시리얼라이즈 → 직렬화 → 역직렬화
 *  	- InputStream Reader → 1byte를 읽어와 2byte로 변환
 *  	  → InputStream(인코딩) Reader(디코딩)
 *  
 *  File : 파일에 정보 / 폴더정보
 *  	→ 기본적인 기능(메소드)
 *  1. 파일정보읽기(생성자)
 *  	File file=new File("c:\\javaDev\\a.txt")
 *  		→ 파일정보읽기(파일명까지 지정)
 *  	File dir=new File("c:\\javaDev")
 *  		→ 디렉토리(폴더정보) 읽기
 *  
 *  2. 파일명 읽기
 *  	- getName() : 실제 파일명만 읽기 : a.txt
 *  	- getPath() : c:\\javaDev\\a.txt
 *  	- getParent : c:\\javaDev
 *  
 *  3. 파일특성
 *  	- 읽기전용 : canRead() → boolean
 *  	- 쓰기전용 : canWrite() → boolean
 *  	- 숨김파일 : isHidden() → boolean
 *  
 *  4. 종류
 *  	- 파일 : isFile()
 *  	- 폴더 : isDirectory()
 *  
 *  5. 생성
 *  	- 파일만들기 : createNewFile()
 *  	- 폴더만들기 : mkdir()
 *  
 *  6. 삭제 : 파일/폴더 → delete()
 *  	- 삭제문제점 : 폴더에 파일이 존재할 경우 → 삭제하지 못함
 *  				→ 폴더안에 있는 모든 파일을 삭제한 후 폴더 삭제
 *  7. listFiles() : 폴더에있는 모든 파일과 폴더를 읽기
 *  8. exists() : 존재여부 확인
 *  9. lastModified() : 수정/날짜
 *  ===================================================
 *  
 *  1. 저장하는 공간
 *  	- 데이터 한개를 저장하는 메모리 공간 : 변수
 *  		10 → a(메모리주소 별칭) → int a=10;
 *  	- 데이터 여러개를 연결적으로 저장 : 배열
 *  		0x100 → arr → int[] arr={10,20,30};
 *  	- 데이터를 병렬로 저장하는 방법 : 클래스
 *  		class A
 *  		{
 *  			int age;
 *  			String name;
 *  			String
 *  		}
 *  			→ 0x100 → a → A a=new A(); 다른 데이터형을 모아서 처리
 *  	→ 메모리에 저장(프로그램 종료후에 자동으로 사라진다)
 *  - 영구적인 저장장치
 *  - 데이터를 계속 유지
 *  	1) 파일 : 보안에 취약 → RDBMS(오라클)
 *  	2) 관련된 데이터를 모아서 관리하기 어려움 
 *  - 입출력과 관련 → java.io → CheckException(예외처리) 
 */
import java.io.*;
import java.util.*;
import java.text.*;
public class MainClass {
	public static void main(String[] args) {
		try
		{
			// 정상수행문장
			// 1. File에 대한 정보
			// 1-1. 파일가지고오기
				File file=new File("c:\\javaDev\\movie.txt");
			// 본인이 가지고 있는 파일 선택
			// 1. 파일 이름 읽기
				System.out.println("파일명: "+file.getName());
			// 2. 경로를 포함해서 읽기
				System.out.println("경로포함: "+file.getPath());
			// 3. 경로명 읽기
				System.out.println("경로명: "+file.getParent());
			// 4. 수정한 날짜
				Date date=new Date(file.lastModified());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				System.out.println("수정일: "+sdf.format(date)); // → long형으로 보여짐 
			// 5. 파일의 크기
				String temp=file.length()>1024?(file.length()/1024)+"KB":
											(file.length())+"Bytes";
											
				System.out.println("파일크기: "+file.length()+"Bytes");
				System.out.println("파일크기: "+temp);
			// 6. 특성(숨긴파일,읽기전용,쓰기전용)
				System.out.println("숨긴파일: "+file.isHidden());
				System.out.println("읽기전용: "+file.canRead());
				System.out.println("쓰기전용: "+file.canWrite());
			// 7. 파일,디렉토리여부 확인
				System.out.println("파일여부: "+file.isFile());
				System.out.println("디렉토리여부: "+file.isDirectory());
			// 8.기타
				System.out.println("절대경로: "+file.getAbsolutePath());
		}catch(Exception e)
		{
			e.printStackTrace();	//에러처리(확인)
		}
	}	
}
