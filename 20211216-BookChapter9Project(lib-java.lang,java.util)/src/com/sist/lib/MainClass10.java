package com.sist.lib;
/*
 * MessageFormat �� �������
 */
import java.util.*;
import java.text.*;
public class MainClass10 {
	/*
	 * �̸� : ȫ�浿
	 * ��ȭ��ȣ : 000-0000-0000
	 * �ּ� : ����
	 * ���� : ����
	 */
	public static void main(String[] args) {
		// insert / update�� �� ���� ���
//		String msg="�̸�: {0}\n��ȭ��ȣ: {1}\n�ּ�: {2}\n����: {3}";
//		Object[] obj={"ȫ�浿","010-1234-7890","����","����"};
//		String res=MessageFormat.format(msg, obj);		// ����ϴ� ������ ���� �ִ´�
//		System.out.println(res);
		String pattern="INSERT INTO Member VALUES({0},''{1}'',''{2}'',"+"''{3}'',''{4}'',{5})"; 
		// ' ' ��������ǥ�� ���ڸ� �� �� ����� �� ����Ŭ�� ���
		Object[] obj= {1,"�̼���","����","����","010-1234-5678",25};
		String res=MessageFormat.format(pattern, obj);
		System.out.println(res);
	}
}