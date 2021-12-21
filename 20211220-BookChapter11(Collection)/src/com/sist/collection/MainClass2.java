package com.sist.collection;
/*
 * Vector : ArrayList가 나오기 전에 많이 사용된 컬렉션 
 * 			쓰레드를 이용해서 데이터 저장(동기)
 * 			네트워크 서버의 사용자 정보를 저장(ip,port)
 * 			List 인터페이스를 구현 / 메소드는 ArrayList와 동일
 * 		(1)추가 : add(Object), addElement(Object) 
 *		(2)삭제 : remove(int index), removeElementAt(int index)
 *		(3)수정 : set(int index)
 *		(4)갯수확인 : size()
 *		(5)읽기 : get(int index), elementAt(int index)
 *		(6)전체삭제 : clear()
 *		(7)데이터유무확인 : isEmpty()  
 * 
 */
import java.util.*;
public class MainClass2 {
	public static void main(String[] args) {
	// 저장공간 생성(자료구조 → 메모리에 데이터를 저장하고 관리)
	// Stack(LIFO) / Queue(FIFO)를 만들어라 - 코테	
	// ↑ index=0,    ↑ index=langth-1
	Vector vec=new Vector();
	// Vector waitVc=new Vector();	// 대기실
	// Vector roomVc=new Vector();	// 방정보
	// Vector userVc=new Vector();	// 방안에있음 사람
	
		// 데이터 추가
		vec.add("홍길동");
		vec.addElement("심청이");
		vec.add("박문수");
		vec.addElement("이순신");
		vec.add("강감찬");
	
		// 추가된 데이터 출력
		System.out.println("저장된 총 갯수: "+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			//Object elementAt(int index), get(int index)
			System.out.println(i+". "+name);
		}
		System.out.println("=====삭제 후=====");
		vec.removeElementAt(0); //vec.remoive(1)
		System.out.println("저장된 인원수: "+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			System.out.println(i+". "+name);
		}
		System.out.println("=====수정후=====");
		vec.set(3, "을지문덕");
		System.out.println("저장된 인원수: "+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			System.out.println(i+". "+name);
		}
		System.out.println("====전체삭제====");
		vec.clear();
		System.out.println("저장된 인원수:"+vec.size());
		if(vec.isEmpty())
		{
			System.out.println("저장된 인원이 없습니다!!");
		}
	}
}
