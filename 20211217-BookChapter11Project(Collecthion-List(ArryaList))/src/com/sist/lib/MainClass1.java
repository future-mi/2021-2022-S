package com.sist.lib;
/*
 * 9장 : java.lang(자바 프로그램의 기본 라이브러리 → import 생략 가능)
 * 	[Object] 
 * 	- toString() : 문자열 변환
 * 	- clone() : 복제(참조/복제)
 * 			참조 : 같은 메모리를 이용
 * 			복제 : 새로운 메모리 생성
 * 	- finalize() : 소멸자(객체가 메모리에서 사라질 때에 자동으로 호출되는 메소드)
 *  - String / StringBuffer : 문자열을 제어하는 클래스(웹 → 문자열 제어)
 *  		문자열을 저장하는 방법 → String s="Hello"  / 문자열 자체가 메모리 주소
 *  		String s=new String("Hello") 	/ 새로운 메모리 생성
 *  - java.lang에서 지원하는 클래스 대부분이 final클래스
 *  	→ 상속을 받을 수 없음(종단클래스 → 확장해서 사용 금지)
 *  	→ 있는 그대로를 사용
 *  	→ String : char[]을 이용해서 만든 클래스
 *
 *  [메소드 : 문자열을 제어 할 수 있는 주요기능]
 * 	 1. equals() : 실제 메모리에 저장되어 있는 문자열 비교
 * 		→ 로그인(id,password 비교)
 * 		→ 문자열을 == 사용(저장되어있는 주소값)
 * 		→ 대소문자를 구분해서 비교 
 * 
 * 	2. 검색
 * 	  1)starsWith() : 앞에 찾는 문자열이 같은지 여부 확인
 * 			- 오라클에서는 LIKE '검색어%' → 정규식(^검색어)
 * 			- 쿠키, 본인게시물, 서제스트(자동완성기)
 * 	  2)endsWith() : 뒤에 있는 문자열이 같은지 여부 확인
 * 			- 오라클 LIKE '%검색어' → 정규식(검색어$)
 * 	  3)contains() : 검색어 포함여부 확인
 * 			- 오라클 LIKE '%검색어%' → 정규식(.*검색어*.)
 * 	  4)자바 : 역할 → 브라우저(화면에 출력) ↔ 오라클(필요한 데이터를 모아둔곳) 
 * 			- 브라우저에서 오라클을 연결 할 수 없음	
 * 			- 중간에 오라클을 연결하여 브라우저 서버로 전송 (매개역할 → 프로그램언어(자바))
 *  3. 변환
 *    1)toUpperCase() : 대문자 변환(알파벳)
 *    2)toLowerCase() : 소문자 변환(알파벳)
 *    3)replace : 원하는 부분의 문자/문자열을 변경해서 사용
 *    		- 필요없는 부분을 제거
 *    		- 일반 문자/문자열 설정
 *    		- 숫자를 지움 → replace('0',"")
 *    4)replaceAll : 원하는 부분의 문자/문자열을 변경
 *    		- 일반 문자/문자열 설정, 문자열 형태
 *    		- 문자 형태를 가지고 찾는 경우(정규식)
 *    		- replaceAll("[0-9",""]
 *    5)concat : 문자열 결합(사용빈도가 거의 없음) → +
 *    
 *  4. 찾기
 *    1)indexOf() : 지정한 문자/문자열의 위치를 찾는 경우에 사용
 *    		문자열 → index가 0부터 시작
 *    2)lastIndexOf() : 지정한 문자/문자열의 위치를 찾는 경우에 사용
 *    		문자열 → index가 length()-1
 *    
 *  5. 문자제어
 *    1)substring 
 *    		- 오버로딩 : 같은 메소드명으로 여러개의 기능을 만드는 경우
 *    				  매개변수의 갯수나 데이터형이 다른 경우 
 *  					substring(int begin)
 *                    String s="Hello Java!!"
 *                              0123455678910
 *                    s.substring(3) → lo Java!!
 *                    substring(int begin,int end)
 *                    String s="Hello Java!!"
 *                    s.substring(1,5) → ello /  end-1 (제외)
 *    2)split 
 *    		- 구분문자를 이요해서 자르는 역할(StringTokenizer)
 *    		- 자른 문자열을 배열로 모아서 넘겨줌
 *    		- 매개변수 → 정규식
 *    3)length : 문자의 갯수
 * 
 *  6.기타
 * 	  1)trim() : 좌우의 공백 제거
 * 			- 사용자 입력에서의 실수(space)
 *    2)valueOf() : 모든 데이터형을 문자열화 시키는 경우
 *    		- 웹 → 쿠기(저장되는 값이 문자열)
 *    
 *    3)Wrapper : 기본 데이터형을 관리하기 쉽게 클래스화 시킨 클래스의 ㅁ음
 *    		- int → Integer / paresInt("") → 정수형으로 변경
 *    4)Math : 수학과 관련된 메소드
 *    		- random() : 임의의 수 발생(난수) → 0.00~0.99
 *    		- ceil() : 올림
 *    5)System 
 *    		- System.out.println()
 *    		- System.in
 *    		- System.gc() : 메모리를 해제할 때 사용(가비지컬렉션)
 *    
 * 10장 : java.util, java.text
 *  1.Random(난수발생) : 임의의 수를 추출 (게임) → 예약일, 예약시간 
 *    1)nextInt() → int 범위 (-21억 4천 ~ 21억 4천)
 *    2)nextInt(int bound) => bound는 범위 / 예) nextInt(10) → 0~9사이의 정수추출 (마지막번호 제외)
 * 
 *  2.StringTokenizer
 *    	- 문자열 별로 자르는 경우 (split)
 *    	- 생성자 2개 (생성자 오버로딩) 
 *    	- new StringTokenizer(구분할 문자열) → 공백별로 자른다 
 *    	- new StringTokenizer(구분할 문자열,구분자) → 구분자별로 자른다 
 *    1) countTokens() : 자른 문장의 갯수
 *    2) hasMoreTokens() : 자를 문자열이 있는 여부 확인 
 *    3) nextToken() : 자른 문장열 
 *          - 자른 문장열을 읽은 경우에 초과하면 오류가 발생 
 *          → 예     String words="aaa|bbb|ccc";
 *                  StringTokenizer st=new StringTokenizer(words,"|")
 *                  String s1=st.nextToken();
 *                  String s2=st.nextToken();
 *                  String s3=st.nextToken();
 *                  String s4=st.nextToken(); // 초과 (오류발생)
 *        	 → 데이터 수집( | ), 그림이 여러개일 때 사용 
 *  3.Date : 시스템의 날짜,시간을 읽어 온다 (오라클과 호환)
 *         	- Date date=new Date()
 *  4.Calendar : 달력 만들기, 요일 확인, 각 달의 마지막 날을 가지고 오는 경우
 *          - 추상클래스 (인터페이스) → 미완성 클래스 (메모리에 저장이 불가능)
 *                             → 사용자 정의 클래스를 만들어서 미완성된 메소드를 완성해서 사용
 *                             → 하위클래스를 이용해서 메모리 할당 
 *                             → 관련된 클래스를 여러개 묶어서 사용 
 *                             → 메소드가 정의가 없는 부분 (선언)
 *          - 프로그램 : 한개으로 이름으로 여러개를 제어
 *          - 데이터 여러개 : 배열 
 *          - 클래스가 여러개 : 인터페이스 
 *          - 인터페이스 : 서로 다른 클래스를 연결해서 사용, 독립적으로 사용 가능, 표준화가 가능
 *            {참고} 기술면접 (스프링 → 인터페이스)
 *                   스프링(1.XML 2.ANNOTATION 인터페이스)
 *                   1.XML → 설정 
 *                   2.ANNOTATION → 구분
 *                   3.인터페이스 → 클래스 제어 
 *         → 객체 생성 
 *            Calendar cal=Calendar.getInstance()
 *            1) 날짜 설정 
 *               cal.set(Calendar.YEAR,2021)
 *               cal.set(Calendar.MONTH,12(X) month-1) → 0~11
 *                    12월 → 11
 *               cal.set(Calendar.DATE,17)
 *            2) 요일을 읽어 온다 (요일 : 1~7) → 0~6 → week-1
 *                                
 *  5.Scanner : 키보드 입력값을 읽는 경우 
 *    1) 정수 입력 : nextInt()
 *    2) 논리 입력 : nextBoolean() 
 *    3) 문자열 입력 : next() → 공백
 *    			    nextLine() → enter시 전체값 읽기
 *    4) SimpleDateFormat : 날짜를 원하는 형태로 변경 
 *         → 년도 : yyyy
 *           월  : MM(M)
 *           일  : dd(d)
 *           시간 : hh(h)
 *           분  : mm(m) → 대소문자 구분
 *           초 : ss(s)  
 *
 *    5)ChoiceFormat : 사용빈도 많이 없음
 *    6)MessageFormat : 사용빈도 많이 없음
 *   → 데이터베이스 연결 (핵심) => JDBC (데이터베이스 : 표준화 (SELECT...))
 * 
 * 11장 : java.util 
 *  1. Collection : 데이터를 모아서 브라우저로 한번에 전송 
 *    1) 컬렉션 프레임워크 : 표준화를 기반 (모든 개발자 동일형태로 코딩) → 가독성이 좋음
 *          - Spring framework
 *          - Mybatis framework 
 *    2) 컬렉션 : 집합체(데이터를 모아서 관리), 다수의 데이터가 많은 경우에 관리를 쉽게 해주는 역할 
 *    3) CURD : (Create(저장) , Update(수정), Read(읽기), Delete(삭제))
 *              배열 삭제가 불가능 → 고정, 컬렉션 → 가변(17만개)
 * 				고정 → 증가 (배열보다 큰 배열 만들고 복사 → 저장)
 *    4)기능별로 나눠져 있다 
 *       (1) 순서가 있고 데이터의 중복을 허용 → List
 *       (2) 순서가 없고 데이터의 중복을 허용하지 않는다 → Set
 *       (3) 키와 값으로 저장  (키는 중복허용(X), 값은 중복으로 허용)
 *                - 우편번호 (우편번호(키),실제 주소) → Map
 *                
 *       [상속도] 
 *                     (Collection)
 *                          |
 *                   ---------------   Map(별도)
 *                   |             | 
 *                  List          Set → List,Map,Set (인터페이스)
 *                  
 *       [구현하고 있는 클래스] 
 *                        (List) 
 *                          |
 *              -------------------------------
 *              |         |         |          |
 *           ArrayList  Vector  LinkedList   Stack
 *            
 *                		 (Set)
 *                  	   |
 *              	-----------------
 *              	|               |
 *            	 TreeSet        HashSet
 *                           
 *               		  (Map)
 *                		    |
 *         		    ------------------
 *           	    |                |
 *           	 HashMap        Hashtable 
 *           
 *           
 *  [List : 순서가 있고 데이터 중복 허용]
 *    1. ArrayList : 비동기화 (데이터베이스 연결)
 *    			     데이터 수집 (데이터를 모아서 관리)
 *        1) 주요 메소드 (CURD)
 *           (1)추가 : 맨뒤에 추가
 *               - add(추가할 데이터(Object obj)) / 문자열, 클래스 객체,정수...
 *          
 *               - 원하는 위치 추가 
 *                → add(int index,Object obj)
 *                → Object (매개변수) → 모든 데이터를 첨부
 *           (2)수정 : set(int index,수정할 데이터)
 *           (3)삭제 : remove(int index)
 *           (4)읽기 : get(int index)
 *           (5)저장 갯수 : size() 
 *           (6)전체 삭제 : clear()
 *    2. Vector : 동기화 (네트워크 사용자 정보 저장)
 *                → ip, port 
 *    3. LinkedList : C언어 호환 
 *    4. Stack : LIFO → 나중에 들어온 데이터 먼저 출력 
 *                      주차장 시뮬레이션 (자료구조 → 코테) 
 *                
 * 12장 : 데이터형의 통일화 (제네릭스)
 * 13장 : 쓰레드,
 * 14장 : 람다/스트림 
 * 15장 : 입출력 
 * 16장 : 네트워크 
 * 
 * 584page 
 *   1. ArrayList → 컬렉션중에 가장 많이 사용하는 컬렉션 
 *   2. ArrayList → 순서가 있고, 데이터 중복허용 
 *   3. Vector(호환)보다는 ArrayList를 많이 사용
 *   4. 사용처 : 데이터베이스, 파일 입출력, 데이터 수집(크롤링)  
 */
import  java.util.*;
public class MainClass1 {
	public static void main(String[] args) {
		// 1. ArrayList 객체생성
		ArrayList list=new ArrayList(); 	// 단점 : 모든 데이터가 Object로 저장  
		// index번호는 자동으로 생성 → 0번부터 시작(배열)
		/*
		 * 홍길동 0
		 * 심청이 1
		 * 박문수 2
		 * 이순신 3
		 * 김두한 4
		 * 
		 * 홍길동 0
		 * 심청이 1
		 * 박문수 2
		 * 강감찬 3
		 * 이순신 4
		 * 김두한 5
		 * 
		 * - 맨뒤에 추가(속도상 문제가없음)
		 * - 중간에 추가(속도가 느려짐)
		 * - 인덱스번호는 ArrayList자체에서 자동 처리 →  0번부터 순차적으로 유지
		 * 		반복문을 수행하기 쉽게 → 인덱스 번호 자동조정
		 */
		// Object로 저장이 되면 → 값을 읽어올 때 반드시 형변환 → for-each 사용 불가
		// 2. ArrayList 저장(맨 뒤에 추가) 		→ add(데이터)
		// 3. ArrayList 저장(원하는 위치에 추가)	→ add(index번호,데이터)
		// 4. ArrayList 저장된 데이터 읽기		→ get(index번호)
		// 5. ArrayList 저장된 객수 확인			→ size 
		// 6. ArrayList 저장된 데이터 수정		→ set(index번호,데이터)
		// 7. ArrayList 저장된 데이터 삭제 		→ remove(index번호)
		// 8. ArrayList 저장된 데이터 전체 삭제	→ clear()
		
		// 이름추가
		list.add("홍길동"); //0 // → 데이터는 어떤 데이터형이든 관계 없음
		list.add("심청이"); //1
		list.add("김두한"); //2
		list.add("강감찬"); //3
		list.add("박문수"); //4

		//출력
		for(int i=0;i<list.size();i++)
		{
			//0번부터 데이터를 읽기 시작
			String name=(String)list.get(i);	//object로 불러오니까 string으로 형변환이 필요
			//왼쪽편이 크거나 같으면 형변환을 하지 않고 오른쪽이 크면 반드시 형변환을 한다
			System.out.println((i)+"."+name);			
			// 원형 : Object get(int index) → 매번 형변환이 어려울 수 있음
			
			// ArryaList<String>
			// → <Type:class> → ArrayList<int> (x) , ArrayList<Integer> (o)
			// 상속내린 클래스가 상속을 받을 클래스보다 데이터형이 크다(메모리 크기는 상속을 받은 클래스가 크다)  
		}
			// 2.추가 : 원하는 위치에 추가(인덱스 번호 변경)
			// 인덱스 번호는 항상 0부터 순차적으로 유지(ArrayList클래스에서 조절)
		System.out.println("=====원하는 위치에 데이터 추가=====");
		list.add(2,"이순신");
		//출력
		for(int i=0; i<list.size();i++)	//범위를 벗어나면 오류 발생(저장된 갯수만큼)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		// 속도 최적화 → 맨뒤에 추가(add())가 사용빈도가 많다
		
		// 3.수정 : 1에 등록된 심청이를 춘향이로 변경
		System.out.println("=====데이터변경=====");
		list.set(1, "춘향이");
		for(int i=0; i<list.size();i++)	
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		
		// 4.삭제 : 3.김두한 탈퇴 → 데이터를 삭제
		System.out.println("=====데이터 삭제=====");
		list.remove(3);
		// ArrayList → 메모리에 저장 → 프로그램을 종료하면 자동으로 메모리에서 사라짐
		// 유지가 가능하게 만드는 방법 : 파일, 오라클(영구적으로 저장)
		for(int i=0; i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		// CRUD 프로그램(추가,수정,삭제,읽기) → 데이터베이스(데이터 저장 후 관리)
		// → 메모리(데이터를 저장하는 장소)
		// 변수, 배열, 클래스, 컬렉션, 파일, RDBMS오라클
		
		System.out.println("=====데이터 전체삭제=====");
		list.clear();
		for(int i=0; i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		System.out.println("저장된갯수: "+list.size());
		// 배열이용
		System.out.println("=====배열→ArrayList로 변경=====");
		String[] names={"홍길동","이순신","강감찬","을지문덕","박문수"};
		List<String> nameList=Arrays.asList(names);
		for(String name:nameList)
		{
			System.out.println(name);
		}
		Object[] n=nameList.toArray();
		for(Object o:n)
		{
			System.out.println(o);
		}
	}
	/*
	 * ArrayList
	 * 	- add : 추가
	 *  - size : 갯수
	 *  - set : 수정
	 *  - remove : 삭제
	 *  - get : 읽기
	 *  - clear : 전체삭제
	 */
}
