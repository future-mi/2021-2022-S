package com.sist.thread;

// �������� ���ÿ� ����(��Ƽ������)
class MyThread2 extends Thread
{
	// ������ ����
	public void run()
	{
		for(char c='A';c<='Z';c++)
		{
			System.out.println(getName()+"��"+c);
			try
			{
				// �Ͻ�����
				Thread.sleep(100);	// ��ø��� (1/1000 s) /0.1�� �����
			} catch (Exception ex) {}
		}
	}
}
public class MainClass2 {
	public static void main(String[] args) {
		// 3���� �����尡 ���� �� �ú���(�ð��� ������ �ѹ��� ����)
		MyThread2 m1=new MyThread2();
		MyThread2 m2=new MyThread2();
		MyThread2 m3=new MyThread2();
		
		// ���� �����Ѵ�()
		m1.start();
		m2.start();
		m3.start();
	}
}
