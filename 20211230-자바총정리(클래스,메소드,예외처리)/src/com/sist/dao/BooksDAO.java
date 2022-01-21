package com.sist.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.common.DataBase;

public class BooksDAO implements DataBase{
	
	//필요한 클래스를 가지고 온다 → 포함클래스
	private Connection conn;	// 오라클연결
	private PreparedStatement ps; //SQL문장을 전송
	private final String url="jdbc:oracle:thin:@localhost:1521:XE";	//오라클주소
	
	/*
	 * 드라이버 
	 * 	- thin : 연결만하는 역할(무료)
	 * 	- oci : 드라이버 오라클 정보를 다 가지고 있다(유료)
	 * 
	 * 	언어-자바, 드라이버-thin, MySQL(MariaDB)
	 * 	aws → JSP(1차), Spring(2차)
	 * 	데이터베이스(폴더) / 테이블(파일)
	 * 
	 * 데이터형 클래스 : 데이터를 모아서 저장 → 캡슐화
	 * 데이터베이스 연결처리
	 * 외부에서 데이터 읽기
	 * 		→ 브라우저에서 호환
	 */
	
	// 드라이버 연결 → 한번만 설정
	public BooksDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// → 클래스명으로 메모리 할당을 한다
		} catch (Exception ex) {
			ex.printStackTrace();
			// getMessage() : 에러메세지만 출력
			// printStackTrace() → 실행되는 과정을 출력(에러위치 확인가능)
			// 에러 → 소스비교 x, output창을 본다
		}
	}
	/*
	 * 반복이 많다(메소드화)
	 * 한개의 기능을 수행 → 재사용이 가능
	 * 반복을 제거
	 * 구조화된 프로그램(단락)
	 */
	// 오라클 연결
	public void getConnection()
	{
		//오라클연결, 파일연결, 네트워크연결 → CheckException
		try
		{
			conn=DriverManager.getConnection(url,"hr","happy");	
			// conn hr/happy 와 동일
		}catch(Exception ex)
		{
			ex.printStackTrace(); // username, password
		}
	}
	// 오라클 연결 해제
	public void disConnection()
	{
		try {
			// 입출력 → PreparedStatement : OutputStream, BufferedReader가 들어가있음
			// 소켓 → Connection : Socket 연결
			if(ps!=null) ps.close();		// 통신
			if(conn!=null) conn.close();	// 전화기닫기
			// ps!=null → ps가 사용중이면
		} catch (Exception ex) {}
	}
	
	/*
	 * 메소드
	 * 1. 선언부 → 리턴형 / 매개변수
	 * 2. 구현부 → {}
	 * 
	 * 		리턴형		매개변수
	 * 		 O			  O
	 * 	→ String(→결과값) substring(int s,int e → 사용자요청) 
	 * 		 O			  X
	 *  → String(→결과값,좌우에 공백) trim()
	 * 		 X			  O
	 *  → void println(String s)
	 * 		 X			  X
	 *  → System.out.println() : 다음줄에 출력
	 * 
	 * 리턴형은 한개만 존재
	 * 	- 데이터가 여러개(배열,클래스,컬렉션)
	 *  - 1개 기본데이터형
	 * 매개변수는 3개이상 초과하지 않는다
	 * 	- 배열,클래스
	 * 모든 데이터를 받기 위해서는 Object
	 * 매개변수의 갯수를 알 수 없다 : 가변 매개변수 이용
	 * 
	 */
	
	@Override
	public void dbInsert(Object obj) throws Exception {
		try
		{
			// → 형변환
			Books b=(Books)obj;
			// 1.오라클연결
			getConnection();
			// 2.오라클에 명령어 전송
			String sql="INSERT INTO books VALUES(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql); 	//전송객체를 생성
			// 3. ?에 값을 채운다 → ?의 순서가 1번부터 시작
			ps.setInt(1, b.getNo());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getPoster());
			ps.setString(4, b.getContent());
			ps.setString(5, b.getAuthor());
			ps.setString(6, b.getPrice());
			ps.setString(7, b.getRegdate());
			ps.setString(8, b.getIsbn());
			ps.setString(9, b.getTags());
			
			// 4. 오라클 → 실행 명령을 전송한다
			ps.executeUpdate();	 // commit이 포함 → autocommit → 자동저장
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// 닫기
			disConnection();
		}
	}
}
