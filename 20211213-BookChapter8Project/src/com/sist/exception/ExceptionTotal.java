package com.sist.exception;
/*
 * ����ó�� : ������ ������ ����
 * �� ���� : ���α׷��� ����� �߻��� �� �ִ� ������ ���� ����� �ڵ� �ۼ�
 * �� ���� ������ ó�� : if�������� ó�� �� ó���� �Ұ����ϸ� ����ó���� �Ѵ�
 * 
 * [ ����ó�� ]
 * 1. ����ó�� : try~catch~finally
 * 		- ���ܸ� ��Ƽ� ���� �� ���ܺ���(catch��)
 * 2. ����ó�� : throws(�޼ҵ� �ڿ� ����) �� ������ ����
 * 		- �ý��ۿ� �˷��� �ش� �� ����ȸ��
 * 3. �����߻� : throw(���α׷��Ӱ� ���� �߻�) �� test��
 * 4. �������� �ʴ� ���� ó�� ���� : ����� ���� ����ó��
 * 
 * 
 * 
 * 
 * 1) ����(��������)
 * 		�� ��� Ŭ������ �ֻ��� Ŭ����(��������� Ŭ����,���̺귯��)
 * 		�� ����ڰ� ���� ������ �߻��ϴ� �κ��� ��� ����ó���� �ϸ� ����
 * 
 * 2) ����
 * 		try
 * 		{
 * 			���� ������ ������ �ҽ�
 * 			�� ������ �߻�
 * 				- ���α׷����� �Ǽ�
 * 				- ������� �Է°� ����
 * 		}
 * 		// ����Ǵ� ���ܰ� ���� ��� catch ���
 * 		catch(����ó������) �� �������� ��� ����   
 * 		{
 * 			������ ���Ḧ �����ϴ� ���α׷� �ҽ�
 * 			�� ���� Ȯ�� / ���� �� ó������ �ٽ� ���ư��� ����
 * 		}
 * 		finally �� ������ ����
 * 		{
 * 			�ݱ�
 * 			- ���� �����
 * 			- ��Ʈ��ũ ���� �� ������������
 * 			- ����Ŭ �� ����Ŭ ���� ����
 * 		}		
 * 			[catch ���]
 * 		- ������ ���
 * 			catch(IOException e){}
 * 			catch(SQLException e){}
 * 			catch(RuntimeException e){}
 * 
 * 		- ���ٷ� ���
 * 			catch(IOException | SQLException | RuntimeException e){}
 * 		- �Ѱ� ���
 * 			catch(Exception e){} �� ���� ����
 * 		** catch�� ����ϴ� ������ ������ �ִ�.	����Ŭ����(����� ������ Ŭ����)�� ���߿� ����. **
 * 		** ��ü��뵵 ���������� �κ������� ��� �� �� �ִ� **
 * 3)
 * 
 * 
 * 
 */
import java.util.*;


public class ExceptionTotal {
	public static void main(String[] args) {
		// 1. ������ 2���� �޾Ƽ� ������ �� 0
		Scanner scan=new Scanner(System.in);
		System.out.println("ù��° ���� �Է�: ");
		int no1=scan.nextInt();
		System.out.println("�ι�° ���� �Է�: ");
		int no2=scan.nextInt();
		
		try
		{
			System.out.printf("%d/%d=%d\n",no1,no2,no1/no2);
		}catch(Exception e)
		{
			System.out.println("0���� ���� �� �����ϴ�");
		}
		
		
		
/*
		if(no2==0)
		{
			System.out.println("0���� ���� �� �����ϴ�");
		}else
		{
			System.out.printf("%d/%d=%d\n",no1,no2,no1/no2);
		}
*/
	}
}
