package com.sist.main;
/*
 *	사용자가 년도/월 입력
 *  달력을 출력 → 윤년(4년마다/100년마다 제외/400년마다)
 *  1. 1년1월1일부터 작년도까지 총 일수
 *  2. 현재년도의 1월1일부터 입력한 월의 총 일수
 *  3. 입력한 날의 1++
 * ============================================
 * 	총 일수 % 7 → 요일
 * ============================================
 *    → Calendar
 *  
 */
import java.util.*;
// java.lang.* 을 생략할 수 있음 / 자동인식을 한다
/*
 * [생략된 내용들이 있고 생략할 수 있음]
 * public class MainClass extends Object
 * {
 * 	   public MainClass()
 * 		{
 * 		}
 *     public void display()
 *      {
 *        return
 *      }
 * }
 */
public class MainClass {

	public static void main(String[] args) {
		// 사용자 입력 완료
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year=scan.nextInt();
		
		System.out.print("월 입력 : ");
		int month=scan.nextInt();
		
		// 요청한 내용을 가공 → 1일자의 요일 구하기
		// 전년도까지의 총 날수
		int total=(year-1)*365
				 +(year-1)/4
				 -(year-1)/100
				 +(year-1)/400;
		// 전달까지의 합
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%4==0 && year%100==0) || (year%400==0)) 		// 윤년 조건
		{
			lastday[1]=29;
		}
		else
		{
			lastday[1]=28;
		}
		
		for(int i=0;i<month-1;i++)
		{
			total+=lastday[i];
			
		}
		total++;
		
		// 요일구하기
		int week=total%7;
		
		// 요청한 내용을 출력
		
		/*
		 * 문자열을 입력받아서 거꾸로 출력 
		 * =======================
		 * 그림파일을 읽어와서 거꾸로 출력
		 * byte[] buffer=fileReader()
		 */
		String[] strWeek= {"일","월","화","수","목","금","토"};
		
		// 요일출력
		System.out.println(year+"년 "+month+"월");
		for(int i=0;i<strWeek.length;i++)
		{
			System.out.print(strWeek[i]+"\t");
		}
		System.out.println("\n");
		for(int i=1;i<=lastday[month-1];i++)
		{
		//	System.out.print(i+"\t");
			if(i==1)
			{
				for(int j=0;j<week;j++)
				{
					System.out.printf("\t");
				}
				System.out.printf("%2d\t",i);
				week++;
				if(week>6)
				{
					week=0;
					System.out.println();
				}
			}
		}
		
	}	

}
