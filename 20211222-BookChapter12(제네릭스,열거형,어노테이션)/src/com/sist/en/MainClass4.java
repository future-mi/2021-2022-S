package com.sist.en;
import java.util.*;
enum Company {
	SK("에스케이"), 
	LG("엘지"), 
	KT("케이티"), 
	SAMSUNG("삼성"), 
	APPLE("애플"); 
	private final String value; 
	Company(String value)
	{ 
		this.value = value; 
	} 
	public String getValue()
	{ 
		return value; 
	} 
}

public class MainClass4 {

	public static void main(String[] args) {
		for(Company type : Company.values())
		{ 
			System.out.println(type.getValue()); 
			// 에스케이, 엘지, 케이티, 삼성, 애플 
		}
		System.out.println(Company.APPLE.getValue()); // 애플
	}
}