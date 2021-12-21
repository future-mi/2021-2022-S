package com.sist.collection;
/*
 * LinkedList
 * 
 * 				 읽기		추가/삭제		  비고
 * ============================================
 * ArrayList	빠르다	 느리다	  순차적인 경우에는
 * 							     추가,삭제 속도가 빠름
 * ============================================
 * LinkedList	느리다	 빠르다	  데이터가 많을수록
 * 								  접근성이 떨어짐
 * ============================================
 * 
 * → List인터페이스를 구현한 클래스
 * 
 * 
 * 
 */
import java.util.*;
public class MainClass3 {
	public static void main(String[] args) {
		// 1. 데이터 저장공간
		LinkedList list=new LinkedList();
		// Vector, ArrayList
		// 2. 데이터추가
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		// 추가하는 순서로 인덱스 번호가 자동으로 설정
		
		System.out.println("추가된 데이터 갯수: "+list.size());
		/*
		 * Integer i=10; 오토박싱
		 * int i=new Integer(10); 언박싱 
		 */
		
		// 추가된 데이터 출력
		for(int i=0;i<list.size();i++)
		{
			int num=(int)list.get(i);
			// 사용하기 쉽기
			// int num=(int)list.get(i)
			System.out.println(i+" → "+num);
		}
		// 3.데이터삭제
		System.out.println("=====데이터 삭제후=====");
		list.remove(3);
		System.out.println("삭제의 데이터 갯수: "+list.size());
		//삭제된 데이터 출력
		for(int i=0;i<list.size();i++)
		{
			int num=(int)list.get(i);
			System.out.println(i+" → "+num);
		}
		// 반복적인 부분 → 메소드 처리
		
		// 수정
		System.out.println("====데이터 수정후====");
		list.set(2, 3000);
		// 수정 후에 데이터 출력
		for(int i=0;i<list.size();i++)
		{
			int num=(int)list.get(i);
			System.out.println(i+" → "+num);
		}
		// 전체삭제
		list.clear();
		System.out.println("현재 데이터 갯수 확인: "+list.size());
		if(list.isEmpty())	// 데이터가 존재 false, 데이터가없으면 true
		{
			System.out.println("데이터가 존재하지 않습니다");
		}
		// isXxx → 리턴형(boolean)
		// ArrayList=Vector=LinkedList
		/*
		 * add() : 데이터추가
		 * remove() : 데이터삭제
		 * set() : 데이터 수정
		 * size() : 저장된 갯수
		 * get() : 저장된 데이터 한개 읽기
		 * isEmpty() : 데이터 유무
		 * clear() : 빈공간으로 만든다
		 * 
		 * → 584page ~ 603page
		 */
	}
}
