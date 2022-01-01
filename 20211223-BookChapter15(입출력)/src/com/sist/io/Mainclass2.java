package com.sist.io;
// 폴더정보 → 폴더 모든 파일읽기
import java.io.*;
import java.util.*;
public class Mainclass2 {
	public static void main(String[] args) {
		try
		{
			File dir=new File("C:\\java_data");
			System.out.println("폴더명: "+dir.getName());
			System.out.println("경로명: "+dir.getPath());
			System.out.println("크기: "+dir.length());
			System.out.println("수정일: "+dir.lastModified());
			System.out.println("=====폴더안에 있는 모든 파일 읽기=====");
			
			File[] files=dir.listFiles(); 	// 업로드할때 같은 파일이 올라올수있음
			//	 같은 폴더안에는 같은 파일명을 올릴 수없다
			HashSet<String> set=new HashSet<String>();
			for(File f:files)
			{
				if(f.isFile())	// 파일일 경우에만 출력
				{
					// System.out.println(f.getName());
					// 확장자만 출력
					String name=f.getName();
					String ext=name.substring(name.lastIndexOf(".")+1);
					System.out.println(ext);
					set.add(ext);
				}
			}
			// 중복이 없는 확장자를 출력 → HashSet
			// 중복이 없는 확장자만 출력
			System.out.println("====중복없는 확장자 출력====");
			for(String s:set)
			{
				System.out.println(s);
			}
			/*
			 * 파일은 읽기 → 파일정보를 읽기
			 * 	→ 중복없이 저장 : HashSet
			 */
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}