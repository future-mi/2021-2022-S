package com.sist.common;
/*
 * 서버/클라이언트 약속(번호)
 * 목록요청
 * 검색요청
 * 상세보기요청(데이터가 없다)
 */
public class Function {
	public static final int LOGIN=100;	// 이미 접속한 사람 처리
	public static final int MYLOG=110; 	// 로그인하는 사람 처리
	public static final int LIST=200;	// 사용자요청시 → 목록을 보여준다
	public static final int FIND=300;	// 사용자요청시 → 검색내용을 보여준다	
}
