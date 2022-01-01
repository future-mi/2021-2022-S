package com.sist.main;
/*
 * 1. ��������(�ʿ��ѵ����͸� ��Ƽ� �ѹ��� ����)
 * 2. ���� ����ڰ� ��û�� ������ ó���ϴ� ���(�׼�Ŭ����) �� ���ó��(�޼ҵ�)
 * 3. ����ڰ� ����� �����ϰ� �����
 */
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		NewsSystem ns=new NewsSystem();
		// �˻��� �Է� ��û
		Scanner scan=new Scanner(System.in);
		System.out.println("�˻��� �Է�");
		String fd=scan.next();
		ns.newsGetData(fd); // ���Ͽ� ����
		ArrayList<News> list=ns.newsAllData();
		System.out.println("====�˻����====");
		for(News n:list)
		{
			System.out.println(n.getTitle());
			System.out.println(n.getDescription());
			System.out.println(n.getAuthor());
			System.out.println("=============\n");
		}
	}
}
