package com.sist.main;
/*
 * ��ûó�� �� ����� �� ����� �����ִ� ���� �� ������
 * �����͸� ��� ����
 */
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
// ī�װ� �� �������� �� Ŭ���̾�Ʈ ����(ArrayList �� ����)
// �������� �� �������� �� Ŭ���̾�Ʈ ����(ArrayList �� ����)
public class FoodSystem {
	public static void main(String[] args) {
		FoodSystem f=new FoodSystem();
	}
	// 1.���� �� ���Ͽ� ����
	// 1-1. �ʱ�ȭ ��� �� ���۰� ���ÿ� ���� ����
	// 1-2. ������ �� ���۰� ���ÿ� ȣ��
	public FoodSystem()
	{
		try
		{
			Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
			Elements title=doc.select("div.top_list_slide span.title");
			Elements subject=doc.select("div.top_list_slide p.desc");
			StringBuffer sb=new StringBuffer();
			
			
			for(int i=0;i<title.size();i++)
			{
				System.out.println(title.get(i).text());
				System.out.println(subject.get(i).text());
				System.out.println("\n");
				
				String data=(i+1)+"|"+title.get(i).text()+"|"
							+subject.get(i).text();
				sb.append(data);
			}
			File file=new File("c:\\java_data\\category.txt");
			if(file.exists())
			{
				file.createNewFile(); 
				System.out.println("���ϻ����Ϸ�");
			}
			// ���Ͽ� ī�װ� �����ϱ�
			FileWriter fw=new FileWriter(file);
			fw.write(sb.toString());
			fw.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}	
	// 2.����ڰ� ��û �� ������ �о ArrayList�� ���� �� ����
}
