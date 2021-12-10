package com.sist.main;

/* [등수구하기]
 * 3명의 학생
 * 국어,영어,수학 → 총점, 평균, 등수
 * 
 * 
 */

import java.util.*;

public class MainClass3 {

	public static void main(String[] args) {
		
		int[] kor= new int[3];
		int[] eng= new int[3];
		int[] math= new int[3];
		int[] total= new int[3];
		double[] avg= new double[3];
		int[] rank= new int[3];
		// double[][] hak=new double[3][6] → 이런식으로 2차원 배열로 입력 할 수 있음 / 자바에선 굳이 안씀
		// 3개이상 → 데이터형이 같다(배열로 모으기), 데이터형이 틀리다(클래스로 모으기)
		// int, string, int
		/*
		 * class A
		 * {
		 *   int
		 *   String
		 * 	 int
		 * }
		 * 
		 * */
		
		Scanner scan=new Scanner(System.in);
		//System.in → keyboard → c(scanf)
		
		for(int i=0;i<3;i++)
		{
			System.out.print((i+1)+"번째 국어 점수 입력 : ");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어 점수 입력 : ");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학 점수 입력 : ");
			math[i]=scan.nextInt();
			
			total[i]=(kor[i]+eng[i]+math[i]);
			avg[i]=total[i]/3.0;
			
		}
		// 등수구하기
		for(int i=0;i<3;i++)
		{
			rank[i]=1;
			for(int j=0;j<3;j++)
			{
				if(total[i]<total[j])
				{
					rank[i]++;
				}
			}
		}
		
		// 출력
		for(int i=0;i<3;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-5d%-8.2f%-5d\n",
					kor[i],eng[i],math[i],total[i],avg[i],rank[i]); 		// -는 앞에서부터 +는 뒤에서부터 출력 
		}
		
		
	}

}
