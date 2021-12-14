package com.sist.lib;
/*
 * 469~471page(String) �� AI,RPA,��� ����
 * 
 * String : ���ڿ��� �����ϴ� Ŭ���� / ��������
 * 			char[]
 * 	- ���(�޼ҵ�)
 * 	1)charAt() : ���ڿ����� ���ڸ� �ڸ��� ��쿡 ���
 * 					���ڿ� �� "" / ���� �� ''
 * 		���� : public char charAt(int index)
 * 			Hello Java
 * 			0123456789 �� charAt(4) �� 'o'
 * 						 charAt(6) �� 'J'
 * 
 * 
 * 
 */

// charAt �� ����(����)
import java.util.*;
public class MainClass3 {
	// �ν��Ͻ� �� MainClss3�� �޸𸮿� �����Ŀ� ��� 
	public void calc() throws ArithmeticException,NumberFormatException,Exception
	{
		Scanner scan=new Scanner(System.in);
		// ���� 2���Է�, ������ �Է�
		// scan,bufferedReader �� char(x), String�� �Է� ����
		System.out.println("ù��° ���� �Է�:");
		int num1=scan.nextInt();
		
		System.out.println("�ι�° ���� �Է�");
		int num2=scan.nextInt();
		
		System.out.println("������ �Է�(+,-,*,/): ");
		String temp=scan.next();
		
		// switch �� ���ڿ� case "+" 
		char op=temp.charAt(0);
		switch (op) {
		case '+' :
			System.out.printf("%d+%d=%d\n",num1,num2,num1+2);
			break;
		case '-' :
			System.out.printf("%d-%d=%d\n",num1,num2,num1-2);
			break;
		case '*' :
			System.out.printf("%d*%d=%d\n",num1,num2,num1*2);
			break;
		case '/' :
			if(num2==0)
				System.out.printf("0���� ���� �� �����ϴ�");
			else											
				System.out.printf("%d/%d=%.2f\n",num1,num2,num1/(double)num2);
																//�谭������ȯ
			break;
			default :
				System.out.println("�߸��� ������ �Է��Դϴ�.");
		}
		
	}
	public static void main(String[] args) {
		MainClass3 m=new MainClass3();
		// �ν��Ͻ������� �ν��Ͻ������� ���� / clac() �� ����
		try
		{
			m.calc();	// ����ó���� ���� ��� ����
		}catch(Exception ex)
		{
			//�������� ����ó���� ����� ��� �� ����ū ����ó���� ����ó�� �� �� �ִ�
			System.out.println(ex.getMessage());
		}
				
		
		
		
		
	}
}
