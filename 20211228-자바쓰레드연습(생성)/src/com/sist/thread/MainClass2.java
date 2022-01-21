package com.sist.thread;

// 여러개를 동시에 수행(멀티스레드)
class MyThread2 extends Thread
{
	// 쓰레드 동작
	public void run()
	{
		for(char c='A';c<='Z';c++)
		{
			System.out.println(getName()+"→"+c);
			try
			{
				// 일시정지
				Thread.sleep(100);	// 잠시멈춤 (1/1000 s) /0.1초 멈춘다
			} catch (Exception ex) {}
		}
	}
}
public class MainClass2 {
	public static void main(String[] args) {
		// 3개의 쓰레드가 동작 → 시분할(시간을 나눠서 한번씩 수행)
		MyThread2 m1=new MyThread2();
		MyThread2 m2=new MyThread2();
		MyThread2 m3=new MyThread2();
		
		// 일을 시작한다()
		m1.start();
		m2.start();
		m3.start();
	}
}
