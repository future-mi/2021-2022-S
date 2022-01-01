package com.sist.io;

import java.io.*;
import java.util.*;
/*
 * 파일,폴더제어(파일만들기, 폴더만들기, 삭제)
 */
public class MainClass3 {
	public static void main(String[] args) {
		try
		{
			File dir=new File("C:\\download");
			// download 폴더가 없다
			// 1. 폴더유무 확인 → 있는경우 통과/ 없는경우 만든다
			if(!dir.exists())	// 존재하지 않는경우
			{
				dir.mkdir(); 	// 폴더를 만든다
			}
			//System.out.println("폴더생성 완료");
			File file=new File("C:\\download\\food.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			//System.out.println("파일생성완료");
			// 삭제
			file.delete();
			dir.delete();
			System.out.println("파일삭제 완료");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
