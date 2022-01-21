package com.sist.thread;
/*
 * Thread �� java.lang.* �� import�� �ʿ����
 * 
 * Thread
 * - ��� ���α׷��� ���μ���(���μ��� �ȿ��� �ٸ� ���� �����ϰ� ����� ����)
 * 	(���μ��� : �������α׷�)
 * - ���ó(����� ���� ������)
 * 	1. ������ ����
 * 	2. ��Ʈ��ũ ���� ����(�������� ���ÿ� ���� �� ���)
 *  3. ����(���� �� �����...)
 *  4. ��(������ ������ �Ǿ��ִ�) �� ���� ����ڵ��� ����� ���ؼ�
 *  
 *  [����� ���� ������]
 *  1) Thread ���
 *  	class MyThread extends Thread
 *  	{
 *  		�ڿ�����
 *  		�ݵ�� ó��
 *  		public void run()
 *  		{
 *  			������ �۾�(��ũ������) �� �Ѱ��� �ϸ� ����
 *  		}	
 *  	}
 *  2) �������̽� ����
 *  	class MyThrea implements Runnalbe
 *  	{
 *  		Runnable �� ����� �޼ҵ�		
 *  		public void run()
 *  		{
 *  			���� �� ���� 
 *  		}
 *  	}
 *  
 *  3) �͸��� �Լ�() �� run �� ���ٽ�(�Լ����� ��� �ڵ��� ����)
 *  	- ���� : ������ �����(��ü������ ����� ����)
 *  	 Runnable r=() ��{
 *  		����
 *  	}
 *  
 *  [�������� �����ֱ�(����~�Ҹ�)]
 *  - new Thread() �� start() �� run() �� sleep()
 *  - �������� ���� �� ���(�ڿ�Ȯ��-�ڿ�:������ ���۽� �ʿ��� ������) 
 *  	�� ������ ���� �� �Ͻ�����
 *  
 *  1. ������
 *   1) �񵿱�ȭ : ��(�������� ���� ���ÿ� ����)
 *   2) ����ȭ : ����(�ѹ��� ����)
 *  
 *  2. �ֿ�޼ҵ�
 *   - start() : ������ �� run()�� ȣ��
 *   - run() : ������ ����(����)
 *   - sleep() : �Ͻ�����
 *   - intertupt() : ������ ����
 *   - currentThead() : ���� �������� �������� �̸��� ������ �´�
 *   - getName() / setName() : �������� �̸� ����
 *   - getPriority() / setPriority() : �켱���� ����
 *   	�� �켱������ 1~10 �� 10���� ���� ���� �۾�
 *   	�� Max_PRIORITY : main() �� 10
 *   	�� MIN_PRIORITY : ga() �� 1
 *   	�� NORM_PRIORITY : ����� ���� ������ �� 5  
 */

// ����� �޾Ƽ� ó��
class MyThread extends Thread
{
	// Ȯ���� ���� �� ��������
	// ����
	public void run()
	{
		for(int i=1;i<10;i++)
		{
			System.out.println(i+" ");
		}
	}
	
}

// �������̽� ����
class MyThread1 implements Runnable
{
	//����
	 public void run()
	 {
		 for(char c='A';c<'Z';c++)
		 	{
				System.out.println(c+" ");
			}
	 }
}

public class MainClass {
	// Thread[main,5,main] �� ������
	// GC �� Thread (�������÷���) �� ��Ƽ�����带 �����Ѵ�
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread());
		// ����� ���� ������
		MyThread m=new MyThread();
		m.start(); // �� run() ���� �� while() �� ���ѷ���
		MyThread m1=new MyThread();	// start�� �������ִ� �޼ҵ尡 �ƴϴ�
		new Thread(m1).start();		// �� �̷������� m1�� �������ִ� run() ȣ��
		/*
		 * ��
		 * Thread t=new Thread(m1);
		 * t.start(); 
		 * 
		 * t==new Thread(m1)
		 * �� ��ü ���� ���ϰ� �� �� ����
		 */
	}
}
