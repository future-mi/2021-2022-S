package com.sist.collection;

import java.util.*;
// Set사용
public class MainClass8 {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add("드라마");
		list.add("액션");
		list.add("판타지");
		list.add("코믹");
		list.add("멜로");
		list.add("액션");
		list.add("드라마");
		// 배열과 사용법이 비슷

		// List → 데이터 중복 허용
		System.out.println("======list의 원본======");
	//	System.out.println(list.toString());
		Iterator it=list.iterator();	//list가 가지고있는 데이터 접근
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// 중복제거
		HashSet set=new HashSet();
		
		for(Object genre:list)
		{
			set.add(genre); // HashSet에 데이터를 첨부→ 중복제거
		}
		System.out.println("=====set에 저장된 데이터 출력=====");
	//	System.out.println(set.toString());
		it=set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// ArrayList → 관리하기 쉬움
		// 기존의 데이터를 한번 지워준다
//		list.clear();
		for(Object genre:set)
		{
			list.add(genre);
		}
		System.out.println("====중복을 제거한 데이터 출력====");
	//	System.out.println(list.toString());
		it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		// list.toString() → 데이터...
		/*
		 * for(Object obj:list)
		 * while(it.hasNext())
		 * {
		 *	 System.out.println(it.next());
		 * }
		 * list에 데이터를 모아서 브라우저로 전송 
		 */
	}
	
}
