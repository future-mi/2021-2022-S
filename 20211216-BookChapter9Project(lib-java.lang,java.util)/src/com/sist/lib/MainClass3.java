package com.sist.lib;
/*
 * 1. java.lang
 * 2. java.util
 * 	 - ���α׷����� �����ϰ� ���Ǵ� Ŭ���� ����
 * 	1) ���� : Random �� 500page
 * 	2) ���ڿ��и� : StringTokenizer �� 513page
 * 	3) ��¥ : Date,Calendar
 *  4) ��ȯ : SimpleDateFormat, MessageFormat
 *  5) ����(�����ͼ���)
 *  			Collection
 *  				|
 *  	 =======================
 *  	|			|			|
 *     List		   Set		   Map
 *    	|			|			|
 * 	ArrayList	 TreeSet	 Hashtable
 *  Vector  	 HashSet	 HashMap �� �ַ� ���׿� ����
 *  LinkedList
 *  Stack
 * 
 *  6) �Է°� : Scanner
 */
import java.util.*;	// *�� ��� Ŭ������ �ҷ����� �� �� util�� ���̾� ���� *���	
					// java.util.Scanner; �̷������� �ϴ°��� ����
public class MainClass3 {
	public static void main(String[] args) {
		// ���� �� nextInt(30) �� 0~29���� �߻�
		Random r=new Random();
		//int i=r.nextInt(); //int�������� �߻�
		//System.out.println(i);
		int i=r.nextInt(100); //0~99���� �߻�
		//nextInt(n) �� 0~n�� ����
		System.out.println(i);
		//�Ǽ� : nextDouble �� 0.0~0.99
	}
}
