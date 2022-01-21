package com.sist.dao;

import java.sql.*;
import java.util.*;
import com.sist.common.DataBase;
/*
 * 대용량 데이터 베이스 : DB2-금융권, 공기업 학교
 * 중형 : Oracle-대기업, MS-SQL-시청 → 실무에서 가장 많이 사용
 * 중소형 : My-SQL-오라클, MariaDB-MySQL에서 나와서 새롭게 만듦
 * 소형 : SQLITE-핸드폰
 * 
 * 클래스 : 대문자시작
 * 변수 : 소문자
 * 상수 : 전체대문자
 * 메소드 : 소문자
 * 괄호 : public void display(){	 
 * 		 }
 */
public class MusicDAO implements DataBase{
	// 연결객체(오라클)
	private Connection conn;	
	// 오라클로 명령어 전송
	private PreparedStatement ps; 
	// 오라클 주소 → 대소문자를 구분하지 않는다 / 키워드는 대문자로 한다
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";	
	
	// 1. 드라이버 등록 : 한번만 수행하려면 생성자 이용
	public  MusicDAO() {
		try
		{
			// 드라이버등록, 서버연결, 쓰레드동작
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {}
	}
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 3. 오라클 해제
	public void disConnection()	{
		try {
			if(ps!=null) ps.close();		// 통신
			if(conn!=null) conn.close();	// 전화기닫기
		} catch (Exception ex) {}
	}
	
	// 4. 기능 (오라클 데이터 추가)
	@Override
	public void dbInsert(Object obj) {
		try {
			Music m=(Music)obj;
			// 1. 연결
			getConnection();
			// 2. 오라클 명령문 전송 SQL
			String sql="INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?,?)";
			// 3. 값을 채워서 실행 명령
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getNo());
			ps.setString(2, m.getTitle());
			ps.setString(3, m.getSinger());
			ps.setString(4, m.getAlbum());
			ps.setInt(5, m.getRank());
			ps.setString(6, m.getState());
			ps.setInt(7, m.getIdcrement());
			ps.setString(8, m.getKey());
			ps.setString(9, m.getPoster());
			
			ps.executeUpdate(); 	// 녹색화살표, 엔터
			// COMMIT → AutoCommit
		} catch (Exception ex) {
			// 에러체크
			ex.printStackTrace();
		}finally {
			// 오라클 종료
			disConnection();
		}
	}
}