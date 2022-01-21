package com.sist.thread;
/*
 * Thread → java.lang.* → import는 필요없음
 * 
 * Thread
 * - 모든 프로그램은 프로세스(프로세스 안에서 다른 일을 수행하게 만드는 역할)
 * 	(프로세스 : 응용프로그램)
 * - 사용처(사용자 정의 쓰레드)
 * 	1. 데이터 수집
 * 	2. 네트워크 서버 제작(여러명이 동시에 접근 → 통신)
 *  3. 게임(몬스터 → 비행기...)
 *  4. 웹(서버가 제작이 되어있다) → 각자 사용자들의 통신을 위해서
 *  
 *  [사용자 정의 쓰레드]
 *  1) Thread 상속
 *  	class MyThread extends Thread
 *  	{
 *  		자원공유
 *  		반드시 처리
 *  		public void run()
 *  		{
 *  			쓰레드 작업(워크쓰레드) → 한가지 일만 정의
 *  		}	
 *  	}
 *  2) 인터페이스 구현
 *  	class MyThrea implements Runnalbe
 *  	{
 *  		Runnable → 선언된 메소드		
 *  		public void run()
 *  		{
 *  			구현 → 동작 
 *  		}
 *  	}
 *  
 *  3) 익명의 함수() → run → 람다식(함수명이 없어서 코딩이 간결)
 *  	- 단점 : 재사용이 어려움(객체지향을 벗어나고 있음)
 *  	 Runnable r=() →{
 *  		구현
 *  	}
 *  
 *  [쓰레드의 생명주기(생성~소멸)]
 *  - new Thread() → start() → run() → sleep()
 *  - 쓰레드의 생성 → 대기(자원확보-자원:쓰레드 동작시 필요한 데이터) 
 *  	→ 쓰레드 동작 → 일시정지
 *  
 *  1. 쓰레드
 *   1) 비동기화 : 웹(여러가지 일을 동시에 수행)
 *   2) 동기화 : 은행(한번씩 수행)
 *  
 *  2. 주요메소드
 *   - start() : 대기상태 → run()을 호출
 *   - run() : 쓰레드 실행(동작)
 *   - sleep() : 일시정지
 *   - intertupt() : 쓰레드 종료
 *   - currentThead() : 현재 실행중인 쓰레드의 이름을 가지고 온다
 *   - getName() / setName() : 쓰레드의 이름 변경
 *   - getPriority() / setPriority() : 우선순위 결정
 *   	→ 우선순위는 1~10 → 10번이 가장 빠른 작업
 *   	→ Max_PRIORITY : main() → 10
 *   	→ MIN_PRIORITY : ga() → 1
 *   	→ NORM_PRIORITY : 사용자 정의 쓰레드 → 5  
 */

// 상속을 받아서 처리
class MyThread extends Thread
{
	// 확장이 가능 → 변수설정
	// 동작
	public void run()
	{
		for(int i=1;i<10;i++)
		{
			System.out.println(i+" ");
		}
	}
	
}

// 인터페이스 구현
class MyThread1 implements Runnable
{
	//동작
	 public void run()
	 {
		 for(char c='A';c<'Z';c++)
		 	{
				System.out.println(c+" ");
			}
	 }
}

public class MainClass {
	// Thread[main,5,main] → 쓰레드
	// GC → Thread (가비지컬렉션) → 멀티쓰레드를 지원한다
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread());
		// 상속을 받은 쓰레드
		MyThread m=new MyThread();
		m.start(); // → run() 수행 → while() → 무한루프
		MyThread m1=new MyThread();	// start를 가지고있는 메소드가 아니다
		new Thread(m1).start();		// ← 이런식으로 m1이 가지고있는 run() 호출
		/*
		 * ↑
		 * Thread t=new Thread(m1);
		 * t.start(); 
		 * 
		 * t==new Thread(m1)
		 * 로 객체 선언 안하고 쓸 수 있음
		 */
	}
}
