package com.sist.lib;

import java.util.*;
public class MainClass3 {
	public static void main(String[] args) {
		
		String[] data= {"가위","바위","보"};
		//1.컴퓨터
		int com=(int)(Math.random()*3);
		//2.사용자입력
		Scanner scan=new Scanner(System.in);
		System.out.println("0.가위 1.바위 2.보");
		int user=scan.nextInt();
		
		System.out.println("컴퓨터: "+data[com]);
		System.out.println("사용자: "+data[user]);
		System.out.println("====결과====");
		
		// 3.결과출력
		switch(user-com)
		{
			case -1:
				System.out.println("컴퓨터ㅏ승");
				break;
			case -2: case 1:
				System.out.println("player 승");
				break;
			case 0:
				System.out.println("비겼다");
		}
		
	}
}
