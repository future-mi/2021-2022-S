package com.sist.io;

import java.io.*;
import java.util.*;
/*
 * ����,��������(���ϸ����, ���������, ����)
 */
public class MainClass3 {
	public static void main(String[] args) {
		try
		{
			File dir=new File("C:\\download");
			// download ������ ����
			// 1. �������� Ȯ�� �� �ִ°�� ���/ ���°�� �����
			if(!dir.exists())	// �������� �ʴ°��
			{
				dir.mkdir(); 	// ������ �����
			}
			//System.out.println("�������� �Ϸ�");
			File file=new File("C:\\download\\food.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			//System.out.println("���ϻ����Ϸ�");
			// ����
			file.delete();
			dir.delete();
			System.out.println("���ϻ��� �Ϸ�");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
