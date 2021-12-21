package com.sist.collection;
// TreeSet → headSet(작은값), tailSet(큰값) 
/*
 * 1)add : 추가
 * 2)remove : 삭제
 * 3)clear : 전체삭제
 * 4)isEmpty : 데이터유무
 * 5)first : 가장 낮은값
 * 6)last : 가장 높은값
 * 7)headSet : ~보다 낮은값
 * 8)tailSet : ~보다 높은값
 * 
 */
import java.util.*;
public class MainClass11 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		int[] score=new int[10];
		// 배열초기화
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			score[i]=r.nextInt(101);
		}
		System.out.println(Arrays.toString(score));
		
		// 기준이 60이상인 데이터를 출력
		System.out.println("====60이상 데이터 출력====");
		for(int jumsu:score)
		{
			if(jumsu>=60)
			{
				System.out.println(jumsu);
			}
		}
		
		System.out.println("====60미만 데이터 출력====");
		for(int jumsu:score)
		{
			if(jumsu<60)
			{
				System.out.println(jumsu);
			}
		}
		
		// TreeSet에 데이터 첨부
		System.out.println("=====TreeSet에 데이터 첨부=====");
		for(int jumsu:score)
		{
			set.add(jumsu);
		}
		System.out.println(set.toString());
		
		System.out.println("====TreeSet에 50보다 큰수====");
		System.out.println(set.tailSet(50));
		
		System.out.println("====TreeSet에 50보다 작은수====");
		System.out.println(set.headSet(50));
		
		
	}
}
