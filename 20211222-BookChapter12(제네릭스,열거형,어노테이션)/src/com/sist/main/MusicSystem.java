package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MusicSystem {
	// Music ��ü �����͸� ���� �� static(����Ŭ : static)
	private static ArrayList<Music> list=new ArrayList<Music>();
	
	// ���α׷� ���۰� ���ÿ� �����͸� ��Ƶд�(�ʱ�ȭ)
	static
	{
		// �� ����(��Ʈ��ũ) �� CkeckException
		try
		{
			// �������� �� �о�� �����͸� ����
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			 Elements title=doc.select("tr.list a.title");
			 Elements singer=doc.select("tr.list a.artist");
			 Elements album=doc.select("tr.list a.albumtitle");
			for(int i=0;i<title.size();i++)
			{
				System.out.println("����:"+(i+1));
				System.out.println(title.get(i).text());
				System.out.println(singer.get(i).text());
				System.out.println(album.get(i).text());
				System.out.println("==================================");
				
				// ArrayList�� ������ ����
				// 1. ������ Ŭ������ ����
				Music m=new Music();
				m.setRank(i+1);
				m.setTitle(title.get(i).text());
				m.setSinger(singer.get(i).text());
				m.setAlbum(album.get(i).text());
				
				// 2. �����Ŭ���� �� ArrayList�� ����
				list.add(m);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// ���
	// ��ü ���
	public ArrayList<Music> musicAllData()
	{
		return list;
	}
	// ã��
	public ArrayList<Music> musicFindData(String ss)
	{
		// ss �� searchString
		// ã�� �����͸� �ٽ� ��Ƽ� ����
		ArrayList<Music> mList=new ArrayList<Music>();
		for(Music m:list)
		{
			if(m.getTitle().contains(ss))
			{
				mList.add(m);
			}
		}
		return mList;
	}
	// �ߺ����� ���� ��� �� HashSet
	public ArrayList<String> singerData()
	{
		ArrayList<String> sList=new ArrayList<String>();
		HashSet<String> set=new HashSet<String>();
		for(Music m:list)
		{
			set.add(m.getTitle()); // �ߺ��� �������� ����
		}
		sList.addAll(set);
		return sList;
	}
}
