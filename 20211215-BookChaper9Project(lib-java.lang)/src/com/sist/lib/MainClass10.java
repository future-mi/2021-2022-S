package com.sist.lib;
/*
 * [String(������ ���� ����ϴ� �޼ҵ�)]
 * 1.length() : ���� ����
 * 2.equals() : ��(�α���,���̵��ߺ�üũ)
 * 3.substring() : ���ϴ� �κ��� ���� �ڸ���
 * 4.indexOf(),lastIndexOf() : ��ġã��
 * 5.valueOf() : ��(���ڿ�) �� �ٸ� �������� ���ڿ� ��ȯ
 * 6.trim() : ����� �Է°��� ��������(��������)
 * 7.replace() : ���ں���
 * 8.contains() : ���� ���ڿ��� ã�°�� 
 */

import java.util.StringJoiner;

/*	��Ÿ
 *  StringJoiner
 *  Format(MessageFormat,SimpleDateFormat..)
 *  �� join(���ڿ� ����)
 *  
 *  Ŭ���� ��ü��=new Ŭ������();
 *  
 *  List list=new ArrayList() �� �������̽�(List)
 *  Connection conn=DriverManager.getConnection()
 *  
 *  - ��ü��.�޼ҵ�   �� �ν��Ͻ� �޼ҵ� 
 *    Ŭ������,�޼ҵ�  �� static �޼ҵ�    
 */

public class MainClass10 {
	public static void main(String[] args) {
		String name="ȫ�浿,�ڹ���,��û��,�̼���,������";
		String[] names=name.split(",");
		//names={"ȫ�浿","�ڹ���","��û��","�̼���","������"};
		//��� 
		for(String n:names)
		{
			System.out.println(n);
		}
		
		//		
		System.out.println("====JOIN====");
		String ss=String.join("-",names); 	
		// ��static �޼ҵ� / join���� �����ټ����� / �޸��Ҵ��� ���� �ʰ� ���
		System.out.println(ss);
		
		StringJoiner sj=new StringJoiner("," , "[" , "]"); // ������ �����
		for(String n:names)
		{
			sj.add(n);
		}
		System.out.println(sj.toString());
	}
}
