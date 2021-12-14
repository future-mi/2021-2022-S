package com.sist.main;
/*
 * ����ó�� : ������ �����߻��� ���� ���� ���α׷�
 * 			�� ������ ���Ḧ �����ʰ� ��������� �����ϰ� ����� �ش�
 * 			�� ���������� �����Ŀ� ������ �����
 * ����ó�� : �ڵ���� ������ �ִ� ��쿡 ������ ������ ������ ó��(�������)
 * 
 * [����]
 * 	1.�������� ����
 * 		- ;, {}, ������ ��θ�, ����IP  �� �ݵ�� ����ó�� �� CheckException
 * 	2.����� ����
 * 		- ����� �Է¿����� ����, ���α׷��� �Ǽ� �� UnCheckException
 * 
 * [����ó�����]
 * 1.���ܺ��� �� catch(���������� ������ ����ؼ�(output) ���(�����ϴ�) ����)
 * 		try	
 * 		{
 * 			������� ����
 * 			�� ������ �߻��� �� ����
 * 		}catch(��������)
 * 		{
 * 			1)�����������(��� ������ �߻��ϴ��� Ȯ��)
 * 				- getMessage() �� �����������
 * 					�� �и�(�޼ҵ带 ����ȭ) �� �ܶ��� ������
 * 				- printStackTrace() �� �����ϴ� ������ ���(���ߴ»��¿��� �ڵ���ġ Ȯ��) 
 * 			2)���ܺ���(�ٽ� �Է�â���� ����)
 * 				- �����ͼ���(Jsoup(����),�����Ͽ�(����))
 * 				- ����(�������� Ŭ����) - ~VO
 * 				�� ����Ȯ��(�ڵ����)
 * 		}
 * 			**catch���� ������ ����� ����(����Ǵ� ����ó��)
 * 			**���ջ�� �� Exception, Throwalbe
 * 		finally
 * 		 - �����ݱ�, ����Ŭ �ݱ�
 * 		 - ���ϴݱ�
 * 2. ����ȸ�� (throws �� ���ܼ����ϱ�) �� 427page
 * 		�� ���� ó���ϴºκ��� �ƴϰ� �̷� ������ �߻��� �� ���ٰ� JVM�� �˷��ִ� ����
 * 		1) ����
 * 			- �޼ҵ�()throws ��������1,��������2.... �� �������� ����� ����
 * 		2)ó�����
 * 			- ����(����ȸ��)
 * 			- try~catch�� �̿��ؼ� ó���� ����
 * 			- �⺻�� ������
 * 				ex) public void display() throws NumberFormatException,ClassCastException
 * 					�� display�� ����Ϸ��� ����ó�� �ϰ� ����Ѵ�
 * 					���� : RuntimeException ��Exception �� Throwalbe
 * 	
 * 				(1)	public void main() throws NumberFormatException,ClassCastException
 * 					{
 * 						display()
 * 					}
 * 				(2)	public void main()
 * 					{
 * 						try
 * 						{
 * 							display()	
 * 						}catch(NumberFormatException e){
 * 						}catch(ClassCastException e){}
 * 					}
 * 				(3)	public void main() throw RuntimeException
 * 					{
 * 						display()	
 * 					}
 * 				(4)	public void main() throw Exception
 *					{
 *						display()
 *					} 
 *  3. ����� ���� ����ó��
 *  	1)extends Exception
 *  	2)catch���� ���ÿ� �ڵ����� ã���� ���Ѵ�
 *  	3)throw �� ����ó�� ȣ��
 *  
 */
public class MainClass {
	//���ܰ� �ִ� �޼ҵ� ����(���̺귯�� �޼ҵ�) �� �ڹٿ��� ����, �ܺ�����
	public static void add(int a,int b)throws Exception
	{
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b); 	// b==0�̸� �����߻�
	}
	
	public static void main(String[] args) throws Exception {
		add(10,20);
		
		
		
		
	}
}
