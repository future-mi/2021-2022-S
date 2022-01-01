package com.sist.main;
/*
 * 데이터만 모아서 관리 → 데이터가 변질,노출 방지 → 캡슐화
 * 데이터 : 읽기/쓰기 → 메소드를 이용해서 읽기/쓰기 가능하게 만든다
 * getXxx(), SetXxx() → getter/setter 
 * 음악 한개에 대한 정보 → 사용자 정의 데이터형
 * 한개의 음악에 관한 데이터를 모아서 전송
 * MusicVO, MusicDTO → 데이터값만 가지고있는 것 
 * 
 */
public class Music {
	private int rank;
	private String title;
	private String singer;
	private String album;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
}
