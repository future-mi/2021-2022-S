package com.sist.movie;
// 데이터만 관리 → 영화 1개에 대한
/*
 * 
 */
/*
 * 사용자 정의 데이터형
 * 기본 데이터형(정수,실수,논리,문자...)
 * 
 * 1. 다른 데이터형을 모아서 관리(사용자 정의 데이터형)
 * 2. 기능을 가지고 있는 클래스(영화)목록,검색,출연의 영화명..등
 * 
 * 
 * 
 * 데이터형 클래스 → 캡슐화 방식(데이터를보호) → 메소드를 통해서 접근
 * 데이터형(읽기→getter / 쓰기→setter)
 * 
 * 
 */
// [캡슐화]
public class MovieVO { 	
	private int no;
	private String title;
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	

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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
}
