package com.sist.collection;

import java.util.*;
import java.util.HashMap;

/*
 * Map �� Ű�� ������ ����
 * 	- Ű�� �ߺ��� ������� ���� : ex)ISBN, �����ȣ
 * 	- ���� �ߺ��� ����� 		 : ex)å����, �����ּ�
 * ������ ������ ���� �ʴ´� �� Iterator
 * 
 * Map �� �������̽�
 * 	- ������ Ŭ����
 * 	- HashMap �� Hashtable�� ������ Ŭ����(������,���̹�Ƽ��,��)
 * 	- Hashtable 
 */
public class MainClass13 {
	public static void main(String[] args) {
		HashMap map=new HashMap(); // �� ä��(���� �� key,��(user����))
		//map�� Ű�� �ߺ��� ���� �����Ͱ� �ʿ��ϴ�(���ڷ� ���������ʴ´�)
		// ���� �ߺ� �� �� �ִ�
		// ���� ���� �� put("Ű","��") �� put(String key, Object value)
		// size() �� ���尹��
		map.put("ȫ�浿", "90,70,80");
		map.put("�ڹ���", "98,80,84");
		map.put("��û��", "100,60,85");
		map.put("������", "80,74,77");
		map.put("�̼���", "75,84,90");
	
/*		
		// ȫ�浿�� ����ǥ
		String score=(String)map.get("ȫ�浿");
		String[] ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// �ڹ����� ����ǥ
		score=(String)map.get("�ڹ���");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// ��û���� ����ǥ
		score=(String)map.get("��û��");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// �������� ����ǥ
		score=(String)map.get("������");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
		
		// �̼����� ����ǥ
		score=(String)map.get("�̼���");
		ss=score.split(",");
		System.out.println(ss[0]+" "+ss[1]+" "+ss[2]);
*/
		System.out.println("�л� �ο���: "+map.size());
		Set set=map.keySet();	// Ű�� �ߺ��� ���� ������ 
		System.out.println(set.toString());
		Iterator it=set.iterator();
		// Map �� key�� ���ͼ� ó�� 
		while(it.hasNext())
		{
			String key=(String)it.next();
			String value=(String)map.get(key);
			String[] ss=value.split(",");
			System.out.println(key+" "+ss[0]+" "+ss[1]+" "+ss[2]);			
		}
	}
}




