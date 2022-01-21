package com.sist.main;
import java.sql.*;
// 오라클 → 계정 생성 
/*
 *    1. 계정 생성 
 *    2. 권한 부여  → session,resource,connect → users 
 *    3. 시스템 → 사용자 계정으로 변경 
 *    4. 데이터를 저장 → 저장된 명칭(테이블:파일)
 *    
 *    [ 오라클 셋팅 ]
 *    1. 검색 (Sql plus) → 관리자 권한으로 실행 
 * 		 사용자 명 : system / 비밀번호 : happy 
 * 	  2. 사용자 계정 생성 
 * 		 alter session set "_ORACLE_SCRIPT"=true;
 * 	     create user hr identified by happy;   // hr은 아이디, happy는 비밀번호
 * 	  3. 권한 부여
 * 		 grant create session to hr;
 * 		 grant connect,resource to hr;
 * 		 alter user hr default tablespace users quota unlimited on users;
 * 	  4. 접속 
 * 		 conn hr/happy
 * 		 @c:\oracleDev\emp.sql
 * 	=============================
 * 	  5. 확인 → 파일(테이블)
 * 		     → EMP : 사원 정보 
 * 		     → SALGRADE : 등급(호봉)
 * 		       SELECT * FROM dept;
 */
// 편집기 → SQLDeveloper
// 자바로 오라클 연결 → ojdbc8.jar 사용
public class MainClass {

	public static void main(String[] args) {
        try
        {
        	//1. Driver 등록 
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	//2. 오라클 연결
        	String url="jdbc:oracle:thin:@localhost:1521:XE";
        	Connection conn=DriverManager.getConnection(url,"hr","happy");
        	//3. 오라클 명령어 전송 
        	PreparedStatement ps=conn.prepareStatement("SELECT * FROM dept");
        	//4. 실행 결과값을 가지고 온다  
        	ResultSet rs=ps.executeQuery();
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "
        	              +rs.getString(2)+" "
        	              +rs.getString(3)); // → 브라우저로 전송 (웹 프로그램)
        	}
        }catch(Exception ex){}
	}

}
