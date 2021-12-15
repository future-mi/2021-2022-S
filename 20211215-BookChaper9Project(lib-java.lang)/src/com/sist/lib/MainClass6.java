package com.sist.lib;
/*
 *  replace(char c1,char c2) 			�� c1�� c2�� �ٲ��
 *  replace(String s1,String s2) 		�� s1�� s2�� �ٲ��
 *  replaceAll(String regex,String s) 	�� regex�� s�� �ٲٴµ� ���Խ� ���
 *  
 *  [������ ����]
 *  211.238.142.181
 *  127.0.0.1
 *  211.63.64.10
 *  211.238.142.1
 *  �� [0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3} �� �̷������� ���� regex
 *  
 *  ���ִ� ���ְ� ���ְ� ���ְ�.....
 *  �� ����+ (+�� �ڿ� �ѱ����ִٴ� ��?)
 */
public class MainClass6 {
	public static void main(String[] args) {
		String s="Hello Java!!";
		String s1=s.replace('a', 'b');
		System.out.println(s1);		// Hello Jbvb!!
		String s2=s.replace("ll", "LL");
		System.out.println(s2);		// HeLLo Java!!
		
		String data="AAABBBcccddd1234567890 �ȳ��ϼ��� �ڹ��Դϴ�";
		String ss=data.replaceAll("[A-Za-z0-9]", "");
		System.out.println("ss= "+ss);
		String ss1=data.replaceAll("[^A-Z]", "");
		System.out.println("ss1= "+ss1);
		
		//[A-Z] �� ���ĺ� �빮�� ��ü
		// [^A-Z] �� �빮�ڸ� �����ϰ�
		String ss2=data.replaceAll("[^a-z]", "");
		// �ҹ��� �� a-z
		System.out.println(ss2);
		String ss3=data.replaceAll("[^0-9]", "");
		// ���� �� 0-9
		System.out.println(ss3);
		String ss4=data.replaceAll("[^��-�R]", "");
		// �ѱ� �� ��-�R
		// ^����(�����ϰ�)
		// [^]����
		// ^[��-�R] �� �ѱ۷� ������ ��� ����
		// [0-9]$ �� ���ڷ� ������ ��� ��
		// ^[��|��] �� �� or ���� �����ϴ� ��� ���ڿ�
		// * �� 0���̻�
		// + �� 1���̻�
		// ^,$,|,+,* �� ���Ǵ� ��ȣ / *, + �� �������ڸ� ã�� ���� \\+ �̷������� �Է��ؾ���
		System.out.println(ss4);		
	}
}
