package com.sist.lib;
/*
 * 469~471page(String) → AI,RPA,통계 수집
 * 
 * String : 문자열을 제어하는 클래스 / 데이터형
 * 			char[]
 * 	- 기능(메소드)
 * 	1)charAt() : 문자열에서 문자를 자르는 경우에 사용
 * 					문자열 → "" / 문자 → ''
 * 		원형 : public char charAt(int index)
 * 			Hello Java
 * 			0123456789 → charAt(4) → 'o'
 * 						 charAt(6) → 'J'
 * 
 * 
 * 
 */

// charAt → 연산(계산기)
import java.util.*;
public class MainClass3 {
	// 인스턴스 → MainClss3을 메모리에 저장후에 사용 
	public void calc() throws ArithmeticException,NumberFormatException,Exception
	{
		Scanner scan=new Scanner(System.in);
		// 숫자 2개입력, 연산자 입력
		// scan,bufferedReader → char(x), String만 입력 가능
		System.out.println("첫번째 정수 입력:");
		int num1=scan.nextInt();
		
		System.out.println("두번째 정수 입력");
		int num2=scan.nextInt();
		
		System.out.println("연산자 입력(+,-,*,/): ");
		String temp=scan.next();
		
		// switch → 문자열 case "+" 
		char op=temp.charAt(0);
		switch (op) {
		case '+' :
			System.out.printf("%d+%d=%d\n",num1,num2,num1+2);
			break;
		case '-' :
			System.out.printf("%d-%d=%d\n",num1,num2,num1-2);
			break;
		case '*' :
			System.out.printf("%d*%d=%d\n",num1,num2,num1*2);
			break;
		case '/' :
			if(num2==0)
				System.out.printf("0으로 나눌 수 없습니다");
			else											
				System.out.printf("%d/%d=%.2f\n",num1,num2,num1/(double)num2);
																//↑강제형변환
			break;
			default :
				System.out.println("잘못된 연산자 입력입니다.");
		}
		
	}
	public static void main(String[] args) {
		MainClass3 m=new MainClass3();
		// 인스턴스변수와 인스턴스변수가 저장 / clac() → 저장
		try
		{
			m.calc();	// 예외처리가 없을 경우 에러
		}catch(Exception ex)
		{
			//여러개의 예외처리가 선언된 경우 → 가장큰 예외처리로 예외처리 할 수 있다
			System.out.println(ex.getMessage());
		}
				
		
		
		
		
	}
}
