package com.sist.main;
/*
 * 변수(설정),연산자, 제어문, 배열(1차) → 프로그램 언어가 동일 
 * 
 * [객체지향]
 * 	- 캡슐화(사용자 정의 데이터형)
 * 		→ 접근지정어(priavte(은닉화) < default < protected < public(통신))
 * 		→ 통신 : 메소드(클래스와 클래스의 통신(연결) → 메소드)
 *  - 상속 / 포함(많이등장)
 *  	→ 상속 : 예외조건 : static, 생성자, 상속은 기능을 사용하지 못한다(private)
 *  - 오버라이딩(재정의)
 * 스프링 : 다른클래스에 영향이 없게 만드는 과정(기본기조)
 * HTML/CSS : 기능은 없음 → 화면 디자인
 * JavaScript : 메뉴클릭시 이미지회전...(이벤트)/브라우저내에서 동작
 * Java : 데이터관리 → AI,챗봇,데이터분석
 * 오라클 : 데이터를 저장한 장소(영구적 저장) 
 * 
 ** 자바 
 *	- 클래스로 시작해서 클래스로 마무리
 *		→ 객체지향프로그램(6~7장)
 *		→ 클래스를 관리하기위해서 단독으로 사용,묶어서 사용 가능(인터페이스)
 *	- 독립적인 메소드(X), 클래스 내부에 작업
 *	- 변수(데이터를 저장 → 가공해서 사용)
 *	- 사용자 요청에 대해서 동작 → 메소드
 *	- 웹으로 데이터 전송(묶어서 전송 → Collection)
 *	- 데이터 형태소 분석 → 라이브러리(꼬꼬마,코모란...)
 *  - 사용자 요청 구분 → 어노테이션
 *	- 필요하면 외부에서 데이터를 가지고 와서 파일에 저장 → IO
 *	- 사용자 요청에 따라 파일업로드, 파일 다운로드 → IO
 *	- 핵심 : 데이터베이스(오라클 → 연결) 
 *
 *	- 10장 : Date, Calendar, SimpleDateFormat
 *	- 11장 : ArrayList, HashSet, HashMap
 *	- 12장 : 제네닉스, 어노테이션
 *	- 15장 : File
 */
import java.util.*;
interface A
{
	public void display();
	public default void aaa()
	{
		
	}
}
// B < A
class B implements A
{
	public void display()
	{
		
	}
}
// C < A
class C implements A
{
	public void display()
	{
		
	}
}
// D < A
class D implements A
{
	public void display()
	{
		
	}
}

public class MainClass {
	public static void main(String[] args) {
		// 1. ArrayList 사용방법
		// 1-1. 저장공간 생성
		ArrayList list=new ArrayList();	// 제네릭스 필수
		
		// 1-2. 데이터첨부
		list.add("사과");	 	//index=0
		list.add("오렌지");	//index=1
		list.add("수박");		//index=2
		
		// 1-3. 요청 → 관리
		// 1-3-1. 목록(데이터 보여주기)
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.println(f);
		}
		// 1-4 데이터 지우기
		System.out.println("====삭제후====");
		list.remove(1);
		for(Object obj:list)
		{
			System.out.println(obj);	// toString을 생략
			/*
			 * valueOf() → int,double → 문자열 변경
			 */
			
		}
		System.out.println("====데이터 출력====");
		list.forEach(obj-> System.out.println(obj)); //람다식 / {}생략
		// JavaScript → 화살표 함수(ES6)
		
		System.out.println("====전체삭제====");
		list.clear();
		if(list.isEmpty())	// 데이터가 없다면
		{
			System.out.println("데이터가 없습니다.");	// 찾기
		}
		// 2. HashSet 사용방법
		System.out.println("====HashSet====");
		// 2-1. 저장공간 생성 → 중복도니 데이터가 들어가면 추가가 안됨
		HashSet set=new HashSet();
		// 2-2.데이터 추가
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		// 2-3. 데이터를 출력
		//for-each
		System.out.println("====for-each사용====");
		for(Object obj:set)
		{
			System.out.println(obj);
		}
		
		//Iterator
		System.out.println("====Iterator사용====");
		Iterator it=set.iterator();	// 데이터를 접근이 가능하게 it에 연결
		while(it.hasNext()) //접근 가능한 데이터 있는 것까지만 반복을 수행
		{
			// it.next() → 실제 접근된 값을 읽어온다
			int value=(int)it.next();
			// 기본데이터형으로 클래스값을 받는다 : 언박싱
			// Integer i=(Interger)it.net()
			System.out.println(value);
		}
		System.out.println("====삭제====");
		set.remove(2);
		set.forEach((obj)->System.out.println(obj));
		System.out.println(set.toString());
		
		System.out.println("====전체삭제====");
		set.clear();
		if(set.isEmpty())
		{
			System.out.println("데이터가 존재하지 않습니다");
		}
		System.out.println("====HashSet 주로하는 역할====");
		ArrayList list2=new ArrayList();
		list2.add("홍길동");
		list2.add("심청이");
		list2.add("박문수");
		list2.add("홍길동");
		list2.add("박문수");
		// 출력
		for(Object obj:list2)
		{
			System.out.println(obj);
		}
		//중복제거
		System.out.println("====List → Set ====");
		HashSet set2=new HashSet();
		set2.addAll(list2); 	// list2에 있는 모든 데이터를 set2로 이동
		for(Object obj:set2)
		{
			System.out.println(obj);
		}
		
		list2.clear();		// List,Set 갱신할때 → 한번을 전체삭제 → 추가
		list2.addAll(set2);
		for(Object obj:list2)
		{
			System.out.println(obj);
		}
		// Set → 주로 장바구니 할 때 사용
		// 3. HashMap 사용방법 → 클래스관리
		// 3-1. 생성
		System.out.println("====HashMap====");
		HashMap map=new HashMap();
		// 3-2. 데이터 추가 → 값이 두개(키,값)
		map.put("a", "홍길동");
		map.put("b", "심청이");
		map.put("c", "춘향이");
		map.put("dd", "박문수");
		map.put("e", "이순신");
		
//		System.out.println(map.get("b"));
		System.out.println("==전체적으로 출력==");
		
/*
		for(char c='a';c<='e';c++)
		{
			String name=(String)map.get(String.valueOf(c));
			System.out.println(name);
		}
*/
		Set s=map.keySet();	// map에 저장되어있는 키 전체을 읽어온다
		Iterator i=s.iterator();
		while(i.hasNext())
		{
			String key=(String)i.next();
			String name=(String)map.get(key);
			System.out.println(name);
		}
		System.out.println("====삭제====");
		map.remove("dd");	// 키설정
		map.forEach((key,value)->System.out.println(value));
		
		System.out.println("====전체삭제====");
		map.clear();
		if(map.isEmpty())
		{
			System.out.println("데이터가 없습니다");
		}
	}
}
