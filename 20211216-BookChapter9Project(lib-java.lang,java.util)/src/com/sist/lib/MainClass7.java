package com.sist.lib;
import java.util.*;
import java.text.*;
/*
 * 1. Random() �� nextInt(n) : n�� ����
 * 2. StringTokenizer
 * 	- nextToken : ���б�
 *  - hasMoreTokens : �ݺ�
 *  - countTokens : ����
 * 3. Date,Calendar : �޷�
 * 4. Format
 * 5. List
 */
public class MainClass7 {
	public static void main(String[] args) {
		//���ó�¥
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// ���� M �빮�� / �ð��� m�� �ҹ��ڷ� �Է��ؾ��� / "yyyy�� MM�� dd�� hh:mm:ss"
		System.out.println(sdf.format(date));
		
		StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		System.out.println(st.nextToken()+"��");
		System.out.print(st.nextToken()+"��");
		System.out.print(st.nextToken()+"��");
		
		// �޷��� ���鶧�� MM�� �ƴ� yyyy-M-dd�� �Է��ؾ���
		// MM dd �� 01, 01 / 09, 10 
		// �� 08�� 09�� �տ� 0�� �پ������� 8�������� �ν��ؼ� ������ �� ����
		// System.out.println(0b1111); // �� 0b�� ���̸� 15�� ��µ�
	}
}
