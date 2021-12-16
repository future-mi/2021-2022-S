package com.sist.lib;

public class MainClass4 {
	public static void main(String[] args) {
		int[] binary=new int[16];
		int num=(int)(Math.random()*32768); //0~32767까지 발생
		int index=15;
		System.out.println("이진법확인: "+num);
		System.out.println(Integer.toBinaryString(num));
		
		while(true)
		{
			binary[index]=num%2;
			num=num/2;
			if(num==0)
				break;
			index--;
		}
		for(int i=0;i<binary.length;i++)
		{
			if(i%4==0 && i!=0)
			System.out.print(" ");
			System.out.print(binary[i]);
		}	
	}
}
