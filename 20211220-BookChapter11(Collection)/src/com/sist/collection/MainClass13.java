package com.sist.collection;

import java.util.*;
import java.util.HashMap;

/*
 * Map → 키와 값으로 설정
 * 	- 키는 중복을 허용하지 않음 : ex)ISBN, 우편번호
 * 	- 값은 중복을 허용함 		 : ex)책제목, 실제주소
 * 순서를 가지고 있지 않는다 → Iterator
 * 
 * Map → 인터페이스
 * 	- 구현한 클래스
 * 	- HashMap → Hashtable을 보완한 클래스(스프링,마이바티스,웹)
 * 	- Hashtable 
 */
public class MainClass13 {
	public static void main(String[] args) {
		HashMap map=new HashMap(); // 웹 채팅(저장 → key,값(user정보))
		//map의 키는 중복이 없는 데이터가 필요하다(숫자로 시작하지않는다)
		// 값은 중복 될 수 있다
		// 값을 설정 → put("키","값") → put(String key, Object value)
		// size() → 저장갯수
		map.put("홍길동", "90,70,80");
		map.put("박문수", "98,80,84");
		map.put("심청이", "100,60,85");
		map.put("춘향이", "80,74,77");
		map.put("이순신", "75,84,90");
	
/*		
		// 홍길동의 성적표
		String score=(String)map.get("홍길동");
		String[] ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// 박문수의 성적표
		score=(String)map.get("박문수");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// 심청이의 성적표
		score=(String)map.get("심청이");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// 춘향이의 성적표
		score=(String)map.get("춘향이");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// 이순신의 성적표
		score=(String)map.get("이순신");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
*/
		System.out.println("학생 인원수: "+map.size());
		Set set=map.keySet();	// 키는 중복이 없는 데이터 
		System.out.println(set.toString());
		Iterator it=set.iterator();
		// Map → key를 얻어와서 처리 
		while(it.hasNext())
		{
			String key=(String)it.next();
			String value=(String)map.get(key);
			String[] ss=value.split(",");
			System.out.println(key+" "+ss[0]+" "+ss[1]+" "+ss[2]);			
		}
	}
}




