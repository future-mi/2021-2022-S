package com.sist.lib;
import java.util.*;
// ���� �� toUpperCase(����-32), toLowerCase(����+32)
// ���� �� &&(����), ||(������)
public class MainClass8 {
	public static void main(String[] args) {
		// �Է°��ޱ�
		Scanner scan=new Scanner(System.in);
		System.out.println("���ĺ� �Է�â: ");
		String data=scan.next();
		
		/*
		 * ASC
		 * A �� 65
		 * a �� 97
		 * '0' �� 48
		 */
		
		// �빮�ڷ� ��ȯ toUpperCase()
		for(int i=0;i<data.length();i++)
		{
			char c=data.charAt(i);
			if(c>='a' && c<='z') 	// �ҹ��ڶ��
			{
				System.out.print((char)(c-32));
			}
		}
		
		// �ҹ��ڷ� ��ȯ toLowerCase
		for(int i=0;i<data.length();i++)
		{
			char c=data.charAt(i);
			if(c>='A' && c<='A') 	// �빮�ڶ��
			{
				System.out.print((char)(c+32));
			}
		}

	}
}
