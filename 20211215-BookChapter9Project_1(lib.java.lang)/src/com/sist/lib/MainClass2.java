package com.sist.lib;

public class MainClass2 {
	public static void main(String[] args) {
		//로또번호 추출
		for(int i=0;i<6;i++)
		{
			int lotto=(int)(Math.random()*45)+1;
			
			System.out.println(lotto+" ");
		}
		
	}
}
