package com.sist.lib;
/*
 * String Ŭ����
 * 
 * String �� ��������, Ŭ������(���)
 * ====== ����� ������ ���ϴ� Ŭ����
 *   ����) public final class String{}
 *   �� java.lang �� final �� ������ ������ ���, ��� �����ڰ� �����ϰ� ���
 *   
 *   1. ������������ ���
 *   	- String s="";
 *   2. Ŭ���������� ���
 *   	- String s=new String("");
 * 	 3. ���(����) �� �޼ҵ�
 * 		- charAt(int index) �� �ڹٴ� �ε�����ȣ 0������ / ����Ŭ�� 1������ 
 * 		- contains/stratswith/endswith : �˻���
 * 	 4. ��(���ڿ�) �� ���� ����Ǿ��ִ� ���ڿ� ��ü / == �ּҰ��� ���ϴ� �� 
 * 		- equals() : ��ҹ��ڸ� ����(��й�ȣ,ID)
 * 		- equalsIgnoreCase() : ��ҹ��� ���� ����(�̸�,�˻�)
 * 			
 * 			** ���ڿ� ="" / "" �� ��ü�� �ּ�
 * 	 5. ã��
 * 		- ���ϴ� ������ ��ġ ã�� �� ���ϴ� �κ� ����
 * 		  ���翩��Ȯ��(-1)�̸� �������� �ʴ´�.
 * 			�տ��� ã�� : indexOf
 * 			�ڿ��� ã�� : lastIndexOf(Ȯ����)
 * 			c:\\javaDev\\a.java 	�� a.b
 * 
 * 469~471page
 * 	 ����) public int indexOf(char c)
 * 		  public int indexOf(String s)
 * 
 * 		  public int lastIndexOf(char c)
 * 		  public int lastIndexOf(String s)
 * 
 * 
 * 
 * 
 * 
 */		

// ����� �Է� �� �α���
import java.util.*;

public class MainClass2 {
	public static void main(String[] args) {
		// 1.�Է��� �޴´�.
		Scanner scan=new Scanner(System.in);
		System.out.println("ID�� Password�Է�: ");
		String id=scan.next();
		String pwd=scan.next();
		System.out.println("ID:"+id);
		System.out.println("Password:"+pwd);
		
		// 2.ID,PWD��
		// �� ����Ŭ�� ����� �����Ͷ�� �����غ���
		final String myId="admin";
		final String myPwd="1234";
		
		// 3.������� ���
		// ��øif
		// equals �� ��ҹ��ڸ� �����ؼ� ��
		// equalsIgnoreCas �� ��ҹ��� ���� ����
		if(myId.equalsIgnoreCase(id))
		{
			if(myPwd.equals(pwd)) 	// ��й�ȣ�˻�
			{
				System.out.println(id+"�� �α��εǾ����ϴ�.");
			}
			else
			{
				System.out.println("Password�� Ʋ���ϴ�.");
			}
		}
		else
		{
			System.out.println("ID�� �������� �ʽ��ϴ�.");

		}
		
		
		
		
	}
} 
