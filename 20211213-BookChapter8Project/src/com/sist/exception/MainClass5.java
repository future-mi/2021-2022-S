package com.sist.exception;
/*
 * 423page ��Ƽ���
 * 
 *  catch(����ó��Ŭ���� a1|����ó��Ŭ���� a2) / ����Ǵ� ������ �������϶� ��� 
 *  // ���󵵴� ���� ����
 *  
 */
import java.util.*;
// ������ ������ ��Ű�� �� java.lang.* (Object,String,StringBuffer...)
// java.lang, java.util, java.io, java.net, javax....
import java.io.*;

public interface MainClass5 {
	public static void main(String[] args) {
/*
 * ���ڿ�(next())�� �����͸� �޾Ƽ�  �� ������ȯ O
 * 	- NumberFormatException
 * �迭�� ���� �� �迭�� ���� �� �� �ִ�
 *  - ArrayIndexOutOFBoundsException
 * ����� �����͸� ������ �� 0���� ���� �� �ִ�.
 *  - ArithmeticException
 * ����� ���
 * 
 * �� catch 3�� �̿�
 * �� | �� ����
 * �� Exception / RuntimeException ���
 * 
 */
		try
		{
			//��������� ������ �ҽ�
			Scanner scan=new Scanner(System.in);
			System.out.println("ù��° ���� �Է�: ");
			String no1=scan.next(); 	// 1�� �Է��ϸ� "1" �� �Ѿ��
			System.out.println("�ι�° ���� �Է�: ");
			String no2=scan.next();
			
			// �迭�� ����
			int[] arr=new int[2];
			arr[0]=Integer.parseInt(no1); 		// Integer.parseInt ���ڿ��� ���������� ��ȯ
			arr[1]=Integer.parseInt(no2);
			
			int result=arr[0]/arr[1];
			System.out.println(result);
			
			//catch �� ����Ǵ� ������ ó�� �� ����
		}
//		catch(RuntimeException e /*Exception e*/) // �� ���� ���� ��
//		{	}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) // �� ��Ƽ���
		{
			e.printStackTrace(); // ������� ��� �� �߰��� ����(�����ټ�)
		}
//		catch(ArrayIndexOutOfBoundsException e)
//		{
//			System.out.println(e.getMessage());
//		}
//		catch(ArithmeticException e)
//		{
//			System.out.println(e.getMessage());
//		}
	}
	/*
	 * catch �� ����
	 * ���������� ���� �ö󰥼��� ������� ������ ũ��
	 * 			Throwable : ������ �ֻ��� Ŭ����
	 * ū Ŭ������ �ؿ� �ִ�(������ ����)
	 * 
	 * catch(Exception e){}
	 * catch(RuntimeException e){}
	 * catch(IOException e){}     �� ����
	 * 
	 * 
	 * catch(RuntimeException e){}
	 * catch(IOException e){}
	 * catch(Exception e){} �� �������
	 * 
	 * catch(RuntimeException e){}
	 * catch(SQLException e){}
	 * catch(NumberFormatException e){}
	 * catch(Exception e){} �� ����
	 * 
	 * catch(NumberFormatException e){}
	 * catch(RuntimeException e){}
	 * catch(SQLException e){}
	 * catch(Exception e){} �� �������
	 * 
	 */
	
}
