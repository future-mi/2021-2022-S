package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicSystem {
	private static ArrayList list=new ArrayList(); // ������ ��ü����
	// ���������� 1���� ����ϸ�ȴ�(static) �� �������� ����ϴ� ������
	
	// 1.������ �ʱ�ȭ(����) �� ����Ŭ
	// �����͸� �о �ʱ�ȭ(����) �� �ʱ�ȭ���(ȣ����� �ڵ�ó��), ������
	// �ʱ�ȭ��� �̿��Ͽ� �����͸� �޸𸮿� ����
	static
	{
		try
		{
		// 1. ����Ʈ ���� �� �������� ��������� �����͸� ����
		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		// 2. �ش絥���� �б�
		Elements title=doc.select("td.info a.title"); 	//���̺� �̸��� �� �����
		Elements singer=doc.select("td.info a.artist");
		Elements album=doc.select("td.info a.albumtitle");
		
		// 3. Music�� ����
		for(int i=0;i<title.size();i++)
		{
			Music music=new Music();
			// �ʱⰪ
			music.setTitle(title.get(i).text());
			music.setSinger(singer.get(i).text());
			music.setAlbum(album.get(i).text());
			list.add(music);

		}
		// 4. list�� �߰�
		
		}catch(Exception ex) {}
	}
	// ��� ���
	public ArrayList musicListData()
	{
		return list;
	}
	// ã�� �� ����,������,�ٹ� �� contains
	public ArrayList musicFinddata(String fd)
	{
		ArrayList fList=new ArrayList();// ã�� �����͸� ��Ƽ� ����
		for(int i=0;i<list.size();i++)
		{
			Music m=(Music)list.get(i); // ����Ǿ��ִ� music�� 1���� �о��
			if(m.getTitle().contains(fd))
			{
				// �뷡����ȿ� ����ڰ� ������ �˻�� ���Կ��� Ȯ��
				fList.add(m);
			}
		}
		return fList;
	}
	// �߰�
	
	
	
}
