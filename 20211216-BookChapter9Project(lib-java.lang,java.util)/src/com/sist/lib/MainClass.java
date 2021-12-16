package com.sist.lib;
/*
 * 1. ��������(�ڹ�)
 * 	1) ����,������(����,����,���,��,��,����),���(if,for,while,break),�޼ҵ�,Ŭ����,�������̽�
 * 	2) ����ó��(���ܺ���(try~catch),����ȸ��(throws)
 * 	3) ���̺귯�� 
 * 		(1) java.lang
 * 			- String,StringBuffer,Wrapper(�������� �� Ŭ����ȭ),Math	
 * 		(2) java.util
 * 			- StringTokenizer, Calendar, Date, List, Map
 * 		(3) java.io
 * 			- FileInputStream, FileOutputStream, BufferReader, File
 * 		(4) java.text
 * 			- SimpleDateFormat
 * 		(5) java.net
 * 			- URL, URLEncoding, Socket, ServerSocket
 * 		(6) java.sql(����Ŭ)
 * 			- Connection, Statement, ResultSet
 * 
 * 2. ����������
 * 3. �˰���
 * 
 * [490page]
 * ����Ŭ����(Wrapper)
 * 	- �Ϲ� ���������� Ŭ����ȭ ���Ѽ� ���� ������ �� �ְ� ����� �ش�
 * 	1. �������� (**�� ���־�����)
 * 		1)������ 
 * 			- byte(1byte) �� ��Ʈ��ũ, ��������� / -128~127
 * 			- short(2byte) �� c��� ȣȯ / -32768~32767
 * 			- int(4byte)** �� Ŭ������ : Integer
 * 			- long(8byte)
 * 		2)������(Unicode vs ASC)
 * 			- char(2byte) �� Ŭ������ : Character
 * 		3)�Ǽ���
 * 			- float(4byte) �� f(�Ҽ������� 6�ڸ�)
 * 			- double(8byte)** �� d(��������, �Ҽ������� 15�ڸ�)
 * 		4)���� 
 * 			- boolean(1byte)** �� true/false
 * 
 * [����ڽ� & ��ڽ�]
 * - ����ڽ� 
 *	  Integer i=10; �� Ŭ�����ȿ� ���� ���ϴ� ���� ����ִ°�
 * - ��ڽ�
 *    Integer i=new Integer(10);
 * 	  int j=i; 
 * 
 * [Object�� ����]
 * 	- ��� ���������� ǥ�� �� �� �ִ�
 * Object o=10;
 * Object o=10.0
 * Object o="������Ʈ"
 * Object o='a'
 * Object o=true
 * Object o=new A()
 * 
 * [��(���ڿ�) �� ���ϴ� ������������ ����]
 * 	"10", "10.5", "true"
 * 	- ���ڿ��� ���������� ��ȯ
 *    int i=Integer.parseInt("10"); 
 *    double d=Double.parseDouble("10.5");
 *    boolean b=Boolean.parseBoolean("true");
 * 
 * 		i=10; / d=10.5; / b=ture;
 * 
 * 	- ���ڿ��� �ٽ� ��ȯ�Ҷ��� valueOf ���
 * 	  String.valueOf(I) �� "10"
 * 	  String.valueOf(d) �� "10.5"
 * 	  String.valueOf(b) �� "true"
 * �� String, Object
 * 
 * - ���ڿ� : String.valueOf() �� ��� ���������� ���ڿ��� ��ȯ
 * - �Ϲݵ������� : .parse��������() �� ���ڿ��� ���ϴ� ������������ ��ȯ
 * 
 */

import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		// ���� �� ���ڿ�(��)
		// ���� �߻��Ҽ� �ִ� ���� �� NumberFormatException
		// ���������� ���� �� list.jsp?page=1 �� String page="1";
		Scanner scan=new Scanner(System.in);
		System.out.println("ù��° ���ڿ� �Է�: ");
		String num1=scan.next();
		System.out.println("�ι�° ���ڿ� �Է�: ");
		String num2=scan.next();
		
		System.out.println("====���Ѱ����====");
		
//		System.out.println("num1+num2: "+num1+num2);
//		int i=Integer.parseInt(num1);	
//		int j=Integer.parseInt(num2);
//		System.out.println("====���ڿ��� ���������� ����====");
//		System.out.println(i+j);
		
//		double d1=Double.parseDouble(num1);
//		double d2=Double.parseDouble(num2);
//		System.out.println("====���ڿ��� �Ǽ������� ����====");
//		System.out.println(d1+d2);
		
		boolean b1=Boolean.parseBoolean(num1);
		boolean b2=Boolean.parseBoolean(num2);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(b1);
		System.out.println(b2);

	}
}
