package com.sist.collection;
// Set → TreeSet
import java.util.*;
/*
 * ArrayList,HashSet,HashMap → 웹
 */
public class MainClass10 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		//데이터 추가
		set.add(80);
		set.add(100);
		set.add(70);
		set.add(85);
		set.add(99);
		set.add(83);
		set.add(87);
		set.add(92);

		System.out.println("가장 낮은 점수: ");
		int min=100;	// 가장 높은값 → 비교해서 변경
		for(Object score:set)
		{
			int a=(int)score;
			if(min>a)
			{
				a=min;
			}
		}
		System.out.println(min);
		System.out.println("가장 낮은 값: "+set.first());
		System.out.println("가장 높은 점수: ");
		int max=70;	// 가장 낮은값 → 비교해서 변경
		for(Object score:set)
		{
			int a=(int)score;
			if(max<a)
			{
				a=max;
			}
		}
		System.out.println(max);
		System.out.println("가장 높은 값: "+set.last());
		System.out.println(set.lower(90));   //90점에 가장 가까이 있는 낮은 점수
		System.out.println(set.higher(90));  //90점에 가장 가까이 있는 높은 점수
		System.out.println(set.floor(98));	 //98이거나 바로 아래
		System.out.println(set.ceiling(98)); //98이거나 바로 위
		// 내림차순 : DESC
		NavigableSet d=set.descendingSet();
		System.out.println(d.toString()); // [100, 99, 92, 87, 85, 83, 80, 70]
		//올림차순 : ASC
		NavigableSet a=d.descendingSet();
		System.out.println(a.toString()); // [70, 80, 83, 85, 87, 92, 99, 100]
		// ~ORDER BY no DESC|ASC
	}
}



