package com.sist.lib;
/*
 * length() �� ������ ���� Ȯ��
 */
public class MainClass5 {
	public static void main(String[] args) {
		String[] movie= {
				"����",
				"�׸� ��",
				"��������",
				"������ ��庥ó ��Ʈ ������� : �ο�",
				"����",
				"���ϸ� �����",
				"���϶�",
				"������ ���̿÷� ��������",
				"�簥",
				"�� �ʳ� �츮"
		};
		// 1.��ü���
		for(String title:movie)
		{
			System.out.println(title);
		}
		System.out.println("========================");
		// length�� ����Ȯ�νÿ� ���
		for(String title:movie)
		{
			if(title.length()>7)
			{
				title=title.substring(0,7)+"...";
			}
			System.out.println(title);
		}
	}
}
