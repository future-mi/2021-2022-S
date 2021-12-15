package com.sist.lib;
import java.util.*;
// 응용 → toUpperCase(문자-32), toLowerCase(문자+32)
// 조건 → &&(포함), ||(미포함)
public class MainClass8 {
	public static void main(String[] args) {
		// 입력값받기
		Scanner scan=new Scanner(System.in);
		System.out.println("알파벳 입력창: ");
		String data=scan.next();
		
		/*
		 * ASC
		 * A → 65
		 * a → 97
		 * '0' → 48
		 */
		
		// 대문자로 변환 toUpperCase()
		for(int i=0;i<data.length();i++)
		{
			char c=data.charAt(i);
			if(c>='a' && c<='z') 	// 소문자라면
			{
				System.out.print((char)(c-32));
			}
		}
		
		// 소문자로 변환 toLowerCase
		for(int i=0;i<data.length();i++)
		{
			char c=data.charAt(i);
			if(c>='A' && c<='A') 	// 대문자라면
			{
				System.out.print((char)(c+32));
			}
		}

	}
}
