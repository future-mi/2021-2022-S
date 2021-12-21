package com.sist.collection;
/*
 * TreeSet → 문자열저장(중복된 데이터는 저장이 안된다) 
 */
import java.util.*;
public class MainClass12 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		String[] names= {"홍길동","심청이","춘향이","박문수","이순신",
						"김두한","강감찬","을지문덕","전봉준","세종"};
		// 배열을 TreeSet으로 변경
		for(Object name:names)
		{
			set.add(name);
		}
		System.out.println("====TreeSet에 데이터가 추가된 상태====");
		System.out.println(set.toString());
		System.out.println("첫번째 데이터: "+set.first());
		System.out.println("마지막 데이터: "+set.last());
		System.out.println(set.headSet("박"));	// "박"이 미포함
		System.out.println(set.tailSet("박")); 	// "박"이 포함
 		
	}
}
