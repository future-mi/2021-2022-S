package com.sist.collection;
/*
 * Set, Map
 * [Set]
 *	1.HashSet : ArrayList에 있는 데이터 중에서 중복이 없는 값 추출
 * 	2.TreeSet
 * 
 * [Map]
 * 	- 클래스관리(컨테이너), 웹의 대부분의 클래스는 Map,
 * 	  순서는 없고 키와 값 → Cookie이용, session 이용
 * 	1.HashMap : Hashtable의 단점을 보완 
 *  2.Hashtable 
 *  
 *  → 출력시에 Iterator를 이용해서 출력하는 프로그램이 많음
 */

/*
 *  [Set → 인터페이스]
 *  구현하고있는 클래스 : HashSet, TreeSet
 *  	- 순서가 없고 데이터 중복을 허용하지 않는다(ID)
 *  	- 증복이 없는 데이터 : 정수
 *  1. add(Object)
 *  2. remove(Object)
 *  3. clear()
 *  4. size()
 *  5. isEmpty()
 *  	출력 : for-each, iterator이용해서 처리
 *  
 */
import java.util.*;
public class MainClass7 {
	public static void main(String[] args) {
		// 저장 공간을 만든다
		HashSet set=new HashSet();	// 데이터 저장시 중복없는 데이터만 설정
		set.add("자바");
		set.add("오라클");
		set.add("HTML5");
		set.add("CSS");
		set.add("JavaScript");
		set.add("JSP");
		set.add("Spring");
		set.add("신기술:Spring-Boot,VueJs,ReactJs,AI");
		set.add("AWS:배포,리눅스");
		set.add("CSS");		// 중복된 데이터는 보여주지 않음

		System.out.println("====for-each====");
		for(Object obj:set)
		{
			System.out.println(obj); // obj.toString(); 에서 → toString은 생략
		}
		System.out.println("====삭제후====");
		set.remove("자바");
		for(Object obj:set)
		{
			System.out.println(obj); 
		}
	}
}











