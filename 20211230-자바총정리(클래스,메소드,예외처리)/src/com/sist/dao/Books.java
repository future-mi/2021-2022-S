package com.sist.dao;
/*
 * [데이터형] 
 * 객체지향 프로그램 : 재사용
 * 재사용 → 기존에 있는 기능,추가,수정,데이터보안
 * 
 * [객체지향의 3대요소]
 * 1) 재사용 : 상속(수정,추가) → is-a
 * 			 포함(변셩 사항이 없는 경우) → has-a
 * 
 *   class A{}
 *   class B extends A{}
 *   A클래스를 확장해서 새로운 클래스를 만들어서 사용
 *   (1) 추가: 오버로딩 - new 
 *   (2) A를 변경해서 사용 : 오버라이딩 - modify(다형성)
 * 
 * 	 class B{}
 * 	 class B{
 * 		A a=new A(); → 포함클래스 → 오버라이딩이 가능
 * 		A a=new A(){
 * 		A클래스가 가지고있는 메소드 재정의(오버라이딩)
 * 	  	};
 * 			→ 상속없이 오버라이딩 → 익명의 클래스
 * 
 * 데이터보안 : 데이터의 값이 변경되거나 변질을 방지하기 위함
 * 			→ 데이터를 감추고(은닉화) 외부 메소드를 통해서 접근이 가능하게(캡슐화) 만드는 방식
 * 			- 은닉화 : 멤버변수-private, 메소드-public
 * 객체지향의 최종 목적 : 유지보수
 * 
 * 변수(한개만 저장) → 배열(데이터를 모아서 하나의 이름으로 여러 변수를 제어-고정적, 같은 데이터형만 모아서 관리)
 * 	→ 구조체(다른 데이터형을 모아서 한번에 한개의 이름으로 제어) → 클래스(데이터형+메소드)
 * 
 * [클래스를 만드는 방법]
 * 	1) 사용자 정의 데이터형 : 데이터를 여러개 묶어서 한번에 관리 → 변수만 제어
 * 						- 서로 다른 데이터형을 묶을 수 있다
 *  2) 혼합형 : 변수 + 메소드 - ActionClass
 * 	
 *  3) 클래스의 구성요소
 *     클래스명 {
 *  	 - 저장할변수(멤버변수) → 여러개 있을 수 있음
 *  		(1) 인스턴스변수 : new를 사용했을 때 객체마다 따로 저장되는 변수
 *  		(2) 정적변수(공유변수) : 컴파일시 한개의 메모리만 사용 가능
 *  			static → 축구공,야구공
 *  	 - 초기화(변수) → 초기화블록 또는 생성자 이용
 *  	 - 변수활용하는 기능 → 메소드
 *    → 필요시마다 재사용 : 상속, 포함
 * 
 * 	데이터형(VO,DTO), 메소드를 이용해서 제어 → 오라클, 웹
 */
public class Books {
	private int no;
	private String title;
	private String poster;
	private String content;
	private String author;
	private String price;
	private String regdate;
	private String isbn;
	private String tags;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
}