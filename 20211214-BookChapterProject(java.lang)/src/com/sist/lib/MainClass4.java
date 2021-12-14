package com.sist.lib;
// charAt
// 문자열을 입력받아서 문자열의 문자가 좌우 대칭인지 확인(ABBA)
import java.util.*;
// 1.length() → 문자갯수(오류처리) / 문자열이 짝수여야함
// 2.charAt() → 
public class MainClass4 {

	public static void main(String[] args) {
		// 문자열 입력 받기
		Scanner scan=new Scanner(System.in);
		System.out.println("문자열 입력");
		String s=scan.next();
		
		if(s.length()%2==0)
		{
		//	System.out.println("정상수행이 가능합니다");
			boolean bCheck=true;					// 반복문에서 비교할때는 디폴트 설정 실행
			for(int i=0;i<=s.length()/2;i++)
			{
				char f=s.charAt(i);					//앞에서부터
				char e=s.charAt(s.length()-1-i);	// 뒤에서부터
		//		System.out.println(f+"|"+e);
				if(f!=e)							// 같은문자가 아니면 종료
				{
					bCheck=false;
					break;
				}
				
			}
			if(bCheck==true)
			{
				System.out.println("좌우대칭입니다");
			}
			else
			{
				System.out.println("좌우대칭이 아닙니다");
			}
		}
		else
		{
			System.out.println("입력한 문자 갯수가 짝수여야한다");
		}
		
	}
}
