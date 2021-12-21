package com.sist.movie;
/*
 * Back-End
 */
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class MovieSystem {
	// 1.��ȭ�� ��� ������ ������ ����
	// 2.��� Ŭ���̾�Ʈ(�����) �� ���� �����͸� ��� �� ����
	// 3.���� �� static(stiatic���� �� �޸𸮰����� 1��)
	// 4.static �� ��絥���͸� ������ �� �ִ³��� �����Ŭ
	// 5.��ȭ 1���� ���� ���� �� Movie �� ������(����) 
	// �� �迭 / Collection
	// �迭 �� ��ȭ����Ȯ��(����), Collection �� ���� 
	
	private static ArrayList<Movie> list=new ArrayList<Movie>();
	// list=null �� size=0 �� �ʱ�ȭ
	/*
	 * ����� �ʱ�ȭ �� X �Ϲݵ����͸� ó��
	 * �ʱ�ȭ ��� �� �ܺ� �����͸� �о ����
	 * 			�� Ŭ������ �ε�Ǿ��� �� �ڵ����� �����ϴ� ���(�ʱ�ȭ����� ����)��
	 * ������ �� �ܺο��� �����͸� �о ����
	 */
	static
	{
		// ������ �б�
		// 1. ����Ʈ�� ����(��Ʈ��ũ �� CheckException) / �ݵ�� ����ó��
		// 1.IO(���������) 2.������ 3.��Ʈ��ũ 4.SQL(�����ͺ��̽�)
		try
		{
			//����Ʈ���� �� �����͸� �о ���(Document : ��������)
			Document doc=Jsoup.connect("https://movie.daum.net/ranking/reservation").get();
			Elements title=doc.select("strong.tit_item a.link_txt");
			// Element  �� �±� �Ѱ��� ����ش�
			// Elements �� ���� �±� �������� ����ش�
			Elements score=doc.select("span.txt_grade");
			Elements reserve=doc.select("span.info_txt span.txt_num");
			Elements story=doc.select("a.link_story");
			Elements regdate=doc.select("span.txt_info span.txt_num");
			for(int i=0;i<title.size();i++)
			{
				System.out.println(title.get(i).text());
				System.out.println(score.get(i).text());
				System.out.println(reserve.get(i).text());
				System.out.println(regdate.get(i).text());
				System.out.println(story.get(i).text());
				System.out.println("=============================");
			
				Movie m=new Movie();
				m.setNo(i+1);
				m.setTitle(title.get(i).text());
				m.setStory(story.get(i).text());
				m.setReserve(reserve.get(i).text());
				m.setRegdate(regdate.get(i).text());
				m.setScore(Double.parseDouble(score.get(i).text()));
				// �Ѱ��� ��ȭ���� �� 20��
				list.add(m);
				//����(������) �� Ŭ���� ���´� �� ������ �� Collection
			}
		}catch(Exception ex)
		{
			//System.out.println(ex.getMessage()); // �����޼��� ���
			ex.printStackTrace(); 		// ��� ������ ������ Ȯ��
		}
	}
	// 1. ���������
	// ArrayList<Movie> �� ��ȭ���� ��ü
	// Movie �� ��ȭ �Ѱ�
	public ArrayList<Movie> movieAllData()
	{
		return list;
	}
	// 2. �󼼺���(��ȭ�Ѱ��� ���� ������ ����)
	public Movie movieDetailData(int no)
	{
		Movie m=new Movie();
		for(Movie mm:list)
		{
			if(mm.getNo()==no)
			{
				m=mm;
				break;
			}
		}
		return m;
	}
	// 3. ã�� �� ��ȭ�� ������ �ִ� ��쵵 �ִ�
	public ArrayList<Movie> movieFind(String title)
	{
		ArrayList<Movie> mList=new ArrayList<Movie>();
		// mList�� ã�� ��ȭ ��Ƽ� �Ѱ��ش�
		for(Movie m:list)
		{
			if(m.getTitle().contains(title))
			{
				mList.add(m);
			}
		}
		return mList;
	}
}



