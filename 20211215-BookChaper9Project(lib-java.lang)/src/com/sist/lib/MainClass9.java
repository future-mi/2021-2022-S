package com.sist.lib;
/*
 * trim(),valueOf(),split()
 * 
 * 1. trim() : �¿��� ���� ���� / ����ڰ� ���������� �Է½ÿ�
 * 				�� "Hello" , " Hello".trim() 
 * 			  	  " Hello Java!! " �� ���ڿ� ��� ������ ���� �Ұ���
 * 2. valueOf() : ��� ���������� ���ڿ��� ��ȯ
 * 					 valueOf(1) �� "1"
 * 					 valueOf(true) �� "true"
 * 					 valueOf(10.5) �� "10.5" 
 * 3. split() : ���ڸ� �и��ؼ� �迭�� ����
 * 				String s="admin|1234|ȫ�浿|����";
 * 				String[] ss=s.split("|");
 * 				ss[0]="admin";
 * 				ss[1]="1234";
 * 				ss[2]="ȫ�浿";
 * 
 */
public class MainClass9 {
	public static void main(String[] args) {
		String data=" Hello Java!! ";
		System.out.println("���ڰ���: "+data.length()+"��"); // 14��
		String s=data.trim();
		System.out.println("���ڰ���: "+s.length()+"��");	// 12��
	
		int a=100;
		int b=200;
		System.out.println("a+b: "+a+b);
		// static �޼ҵ�(Ŭ������,�޼ҵ�) �� static
		// Math.random()
		String a1=String.valueOf(a);
		String b1=String.valueOf(b);
		System.out.println("a1+b1: "+a1+b1);
		
		System.out.println("=========================");
		
		String data2="ȫ�浿-����-25-����-����";
		String[] info=data2.split("-");
		for(String ss:info)
		{
			System.out.println(ss);
		}
	}
}
