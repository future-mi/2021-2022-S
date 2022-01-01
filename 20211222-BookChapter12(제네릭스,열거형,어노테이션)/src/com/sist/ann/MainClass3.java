package com.sist.ann;
import java.util.*;
/*
 * annotation → XML을 대처한다
 */
public class MainClass3 {
	
	public static void main(String[] args) {
		try
		{
			Class clsName=Class.forName("java.util.ArrayLiust");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			ArrayList<String> list=(ArrayList<String>)obj;
			list.add("홍길동");
			list.add("심청이");
			for(String name:list)
			{
				System.out.println(name);
			}
		}catch(Exception ex) {}
	}
}
