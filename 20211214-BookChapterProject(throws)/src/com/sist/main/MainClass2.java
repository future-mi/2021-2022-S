package com.sist.main;
// 실제로 선언되어있는 소스
/*
 *		메소드() throws 예외처리가 여러개 
 *
 * 		→ 호출시 예외처리를 하고 사용
 * 			1.메소드() throws(통합:Exception,Throwalbe)
 * 			2.메소드()
 * 				{
 * 					try
 * 					{
 * 					}catch(Exception,Throwalbe){}
 * 				}
 * 
 */
public class MainClass2 {
	// 선언(라이브러리) → 오라클
	// IO, NetWork, Oracle
	String name;
	public static MainClass2 createClass() throws Exception
	{
		// 클래스 이름으로 메모리 할당이 가능(리플렉션)
		// 스프링 → 클래스 이름을 제공하면 → 메모리할당(클래스관리)
		// 스프링 → 클래스 관리
		Class clsName=Class.forName("com.sist.main.MainClass2");
		Object obj=clsName.getDeclaredConstructor().newInstance();
		return (MainClass2)obj;
		// 결합성(다른영향이 있는지 여부), 응집성(메소드)
	}
	// 이미 코드가 되어있는 상태 → throws(유지보수)
	// 코드가 없는 상태 → try~catch(개발)
	
	public static void main(String[] args) {
		try
		{
			MainClass2 m=createClass();		//반드시 예외처리가 존재 try~catch or 선언throws
			m.name="홍길동";
			System.out.println(m.name);
		} catch (Exception e) {
			
		} 
	}
}
