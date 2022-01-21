package com.sist.client;
import java.net.*;
/*
 * 네트워크
 * - IO(입출력)
 * - Thread → 서버에서 각 클라이언트마다 서버 동작을 따로 설정
 * - 네트워크 관련 라이브러리
 * - 윈도우
 */
public class Client {
	public static void main(String[] args) {
		try {
			Socket s=new Socket("172.30.1.54",3355);
		}catch(Exception ex) {}
	}
}
