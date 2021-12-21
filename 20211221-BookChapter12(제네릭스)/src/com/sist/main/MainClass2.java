package com.sist.main;
// Collection → 제네릭스 적용
import java.util.*;

public class MainClass2 {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		// ArrayList안에는 String을 저장한다(데이터형을 고정한다)
		list.add("사과");
		list.add("배");
		list.add("수박");
		list.add("오렌지");
		list.add("메론");
	
		// 출력
		for(String s:list)
		{
			System.out.println(s);
		}
		System.out.println(list.toString());
		System.out.println("====Set 사용====");
		HashSet<Integer> set=new HashSet<Integer>();
		//정수만 저장 <클래스형만 첨부할 수 있다> → int double은 오류남
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			set.add(r.nextInt(100)+1); // 1~100
		}
		//for-each
		for(int i:set)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(set.toString());
		
		// → 사용자 정의클래스, String
		System.out.println("====Map====");
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("id", "ban");
		map.put("password", "1234");
		map.put("sex", "남자");
		map.put("age", String.valueOf(27));	//"27" → 사용자가 보내주거나,오라클에서 데이터 읽기
		map.put("addr", "서울");
		map.put("tel", "010-1111-1111");
		
		System.out.println("====회원정보출력====");
		System.out.println("ID:"+map.get("id"));
		System.out.println("Password:"+map.get("password"));
		System.out.println("Sex:"+map.get("sex"));
		System.out.println("Age:"+map.get("age"));
		System.out.println("Addr:"+map.get("addr"));
		System.out.println("Tel:"+map.get("tel"));
	}
}
