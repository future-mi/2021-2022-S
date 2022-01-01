package com.sist.main;
/*
 * �ڹ������� 2��(���̺귯�� �߽�)
 * [11�� Collection]
 * 	- ArrayList,HashSet,HashMap
 * [12��]
 * 	- ���׸��� : �Ϲ����׸��� <> �� �������� ����
 * 			  �ڹٿ��� ���̺귯�� ���鶧 ����ڰ� � ���������� ����������
 * 				�� �Ź� ����ȯ(����) �� ����� ������� ������ ����
 * 			 	�� ���ϵ�ī�� X
 * 	- ������ : ���� ������� ����(�迭)
 *  - ������̼� : ������ �� �Ϲ��ڹ�(O)
 *  			������(������̼�, XML)
 *  [13��]
 *  - ������ : �⺻����
 *  [14��]
 *  - ���ٽ� : �͸��� �Լ� �� �� ǥ�� 
 *  [15��]
 *  - �����
 *  [16��]
 *  - ��Ʈ��ũ
 *  
 *  ���׸��� �� �÷���, IO
 */
import java.util.*;
/*
 * List<E> �� class�� Object �� ���α׷��� �ʿ��� ������������ ����
 * 						 ��� �޼ҵ峪 �������� ������ �����ͷ� ����
 *  - List<String>, List<Integer>, List<Double>, List<Food> �� ����� ���� Ŭ������ ���� 
 * 
 * Set<E>
 *  - Set<String>, Set<Integer>, Set<Double>
 * 
 * Map<K,V> �� �ΰ��� ���ÿ� ����
 *  - Map<String,Object>, Map<String,String>, Map<String,Food>
 *  - Ű�� String�� �ַ� ��� �� ���׸����� ������� �ʴ� ��� �ݵ�� ����ȯ
 */
public class MainClass {
	public static void main(String[] args) {
		MusicSystem ms=new MusicSystem();
		// 1. �ߺ����� ����
		ArrayList<String> list=ms.singerData();
		// ���
		for(int i=0;i<list.size();i++)
		{
			System.out.println((i+1)+"."+list.get(i));
		}
		System.out.println("======��ü���======");
		ArrayList<Music> mList=ms.musicAllData();
		for(Music m:mList)
		{
			System.out.println("����:"+m.getRank());
			System.out.println("����:"+m.getTitle());
			System.out.println("������:"+m.getSinger());
			System.out.println("�ٹ�:"+m.getAlbum());
			System.out.println("======================");

		}
		System.out.println("========ã��=========");
		Scanner scan=new Scanner(System.in);
		System.out.println("�˻��� �Է�:");
		String ss=scan.next();
		
		ArrayList<Music> sList=ms.musicFindData(ss);
		if(sList.isEmpty())
		{
			System.out.println("�˻��� �����Ͱ� �����ϴ�");
		}
		else
		{
			for(Music m:sList)
			{
				System.out.println(m.getTitle()+"("+m.getSinger()+")");
			}
		}	
	}
}
