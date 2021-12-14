package com.sist.lib;
// contains() �� ���ڿ��߿� ���ԵǾ����� ���� / LIKE
/*
 * 	���� : public boolean contains(String word) �� �ڹٽ�ũ��Ʈ(SearchBar)
 */
import java.util.*;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
// ��ȭ��õ, ��α�, ī�信�� �Է±��� �д´� �� �ǽð�(Ʈ����)

/*	<div class="wrap_song_info">
<div class="ellipsis rank01"><span>
<a href="javascript:melon.play.playSong('1000002721',34298499);" title="������ (Feat. MINO) (Prod. GRAY) ���">������ (Feat. MINO) (Prod. GRAY)</a>
</span></div><br>    */
public class MainClass6 {

	public static void main(String[] args) {
		//1. ������Է�
		Scanner scan=new Scanner(System.in);
		System.out.println("�˻��� �Է�: ");
		String fd=scan.next();
		
		//2.ã�� �� contains
		try
		{
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();	
			//����Ʈ�� �����ؼ� ��� �����͸� �о�Ͷ�
			org.jsoup.select.Elements elem=doc.select("div.wrap_song_info a");
			for(int i=0;i<elem.size();i++)
			{
				String ss=elem.get(i).attr("title"); 
				if(ss.contains(fd))
				{
					System.out.println(ss);
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();	// ����Ȯ��
		}
		//3.ã������� �����ش�
		
	}
	
}
