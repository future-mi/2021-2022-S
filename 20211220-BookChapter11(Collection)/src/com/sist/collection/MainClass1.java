package com.sist.collection;
/*
 * Collection : 데이터그룹(데이터를 모아서 관리)
 * 	- CollectoionFramework : 표준화
 *  - 저장방법에 따라 분류 : List(가장많이사용), Set, Map
 *  	
 *  			 Collection
 *  				  |
 *  		-----------------------
 *			|		  |			  |  
 * 		 1.List	     Set		 Map → 인터페이스
 *		→ 순서를 가지고 있음(인덱스 순서 구분)
 *		→ 중복데이터를 허용
 *		→ 라이브러리에서 제공하는 기능(CURD)
 *		1)추가 : add(Object) → 어떤 데이터형이든 상관없이 추가
 *			→ 데이터가 여러종류를 첨부하면 제어하기 어려움(반복문수행 어려움)
 *			→ 같은 데이터형 처리(String,Integer,사용자정의 클래스)
 *			→ 데이터 저장 공간 생성
 *		2)삭제 : remove(int index)
 *		3)수정 : set(int index, Object o)
 *		4)읽기 : get(int index)
 *		5)저장갯수 : size()
 *		6)데이터유무 : isEmpty() (boolean)
 *		7)전체삭제 : clear()
 *          |
 *  1)ArrayList : 가장많이사용 → 데이터베이스 연결
 *     				- 비동기적 / vector를 보완한 클래스
 *  2)Vector : 네트워크 프로그램
 *     				- 기능(동기) → 쓰레드(데드락,스타베이션)
 *     				- 웹에서 등장(실시간)
 *     				- 데이터수집
 *    	(1)추가 : add(Object), addElement(Object) 
 *		(2)삭제 : remove(int index), removeElementAt(int index)
 *		(3)수정 : set(int index)
 *		(4)갯수확인 : size
 *		(5)읽기 : get(int index), elementAt(int index)
 *		(6)전체삭제 : clear()    
 *  3)LinkedList : C언어 호환
 *     	(1)추가 : add(Object) 
 *		(2)삭제 : remove(int index)
 *		(3)수정 : set(int index)
 *		(4)갯수확인 : size
 *		(5)읽기 : get(int index) 
 *     		| 	 
 * 		  Queue
 * 	- 저장 : offer, 읽기 : poll
 * 		  Stack
 *  - 저장 : push, 읽기 : pop
 * 
 * 2. Set : 순서가 없다, 데이터 중복을 허용하지 않는다
 * 	- Interator : 데이터를 모아서 관리
 * 	- HashSet, TreeSet(정렬)
 * 
 * 3. Map : 키와 값을 동시에 저장
 * 			키는 중복없는 데이터, 값은 중복을 허용
 * 	- 스프링,마이바티스,JSP의 내장객체
 * 	- 스프링 : 클래스 등록,클래스 관리시 사용
 * 	- 마이바티스 : 데이터베이스와 관련 → 키,SQL
 * 
 */
// 584page
import java.util.*;

public class MainClass1 {
	public static void main(String[] args) {
		// Collection
		// 1. 메모리 할당(저장할 수 있는 공간 확보)
	//	ArrayList list=new ArrayList();
	//	Vector list=new Vector();
		LinkedList list=new LinkedList();
		
		// 2. 데이터저장
		list.add("사과");
		list.add("포도");
		list.add("바나나");
		list.add("배");
		list.add("수박");
		
		// 3. 확인
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 4. 출력
		// 5. 수정
		list.set(4, "오렌지");
		
		System.out.println("\n====수정 후 출력====");
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 6. 출력
		// 7. 삭제
		list.remove(2);
		System.out.println("\n=====삭제 후 출력=====");
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 8. 출력
		for(Object obj:list)
		{
			System.out.print(obj+" ");
		}
		// 9. 전체삭제
		list.clear();
		// 10. 출력
		if(list.isEmpty())
		{
			System.out.println("\n바구니에 과일이 없습니다");
		}
	}
}







