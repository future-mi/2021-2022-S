package com.sist.common;
/*
 * 1. 위키북스
 * 2. 망고플레이트
 * 3. 서울여행(명소,자연,호텔)
 * 4. 영화 → 다음,네이버 → 순위
 * 5. 음악 → 지니,멜론,mnet
 * 
 * 1)오라클에 데이터 첨부
 * 2)데이터 읽기
 * 3)상세보기		
 * 
 */
import java.util.*;
public interface DataBase {
	public void dbInsert(Object obj) throws Exception;
	// 클래스를 통일 할 때 Object로 받으면된다 → 형변환
}
