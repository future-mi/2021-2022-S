package com.sist.main;
// ��������� ����ó��(�ڹٿ��� �������� �ʴ� ���ܰ� �߻��ÿ� ���� ���� ó��)
// 439page(���󵵴� ���� ����)
class MyException extends Exception
{
	public MyException(String msg)
	{
		super(msg);	//ExceptionŬ������ ������
		// this �� MyExceptionŬ������ ��ü 
	}
}
/*
 * 		class A
 * 		{
 * 		}
 * 
 * 		1. Ŭ���� ���� - A a=new A();  // ���÷��� Class.forName();
 * 					�� JVM �� this=a; �� ��ü���� �ּҸ� ����ϰ� ����
 *		2. ��� (�ӵ��� ���� �� JOIN(Subquery) �� ����ȭ
 *			�޸��Ҵ� �� ��� ������ Ŭ���� �޸� �Ҵ�
 *					  ��� �޴� Ŭ���� �޸� �Ҵ� 
 * 		
 */
public class MainClass5 {
	public static void main(String[] args) {
		// ��������� ����ó���� �ڵ����� ã�� �� ����(����ȣ��)
		// �̹� �ڹٿ� ������ ����ó���� �ڵ� ȣ���� ����
/*
 *		1. ������ ȣ�� : new ������()
 *		2. ����ó�� ȣ�� : throw new ������() �� ���ܴ�����(����ó���� ã�´�)
 *
 *		break, continue, return, throw �ؿ��� �ҽ��ڵ��� �Ұ���
 */
		try
		{
			int a=11;
			if(a%2==0)
			{
				throw new MyException("¦���Դϴ�");
				// throw �ؿ��� �ҽ��ڵ��� �� �� ����.(���� �������)
			}
			else
			{
				throw new MyException("Ȧ���Դϴ�");
			}
		} catch (MyException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
