package com.sist.lib;
/*
 * MessageFormat → 출력형식
 */
import java.util.*;
import java.text.*;
public class MainClass10 {
	/*
	 * 이름 : 홍길동
	 * 전화번호 : 000-0000-0000
	 * 주소 : 서울
	 * 성별 : 남자
	 */
	public static void main(String[] args) {
		// insert / update할 때 많이 사용
//		String msg="이름: {0}\n전화번호: {1}\n주소: {2}\n성별: {3}";
//		Object[] obj={"홍길동","010-1234-7890","서울","남자"};
//		String res=MessageFormat.format(msg, obj);		// 출력하는 패턴을 만들어서 넣는다
//		System.out.println(res);
		String pattern="INSERT INTO Member VALUES({0},''{1}'',''{2}'',"+"''{3}'',''{4}'',{5})"; 
		// ' ' 작은따옴표는 문자를 쓸 때 써야함 → 오라클에 사용
		Object[] obj= {1,"이순신","남자","서울","010-1234-5678",25};
		String res=MessageFormat.format(pattern, obj);
		System.out.println(res);
	}
}
