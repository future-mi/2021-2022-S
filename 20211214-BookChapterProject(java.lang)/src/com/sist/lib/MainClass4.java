package com.sist.lib;
// charAt
// ���ڿ��� �Է¹޾Ƽ� ���ڿ��� ���ڰ� �¿� ��Ī���� Ȯ��(ABBA)
import java.util.*;
// 1.length() �� ���ڰ���(����ó��) / ���ڿ��� ¦��������
// 2.charAt() �� 
public class MainClass4 {

	public static void main(String[] args) {
		// ���ڿ� �Է� �ޱ�
		Scanner scan=new Scanner(System.in);
		System.out.println("���ڿ� �Է�");
		String s=scan.next();
		
		if(s.length()%2==0)
		{
		//	System.out.println("��������� �����մϴ�");
			boolean bCheck=true;					// �ݺ������� ���Ҷ��� ����Ʈ ���� ����
			for(int i=0;i<=s.length()/2;i++)
			{
				char f=s.charAt(i);					//�տ�������
				char e=s.charAt(s.length()-1-i);	// �ڿ�������
		//		System.out.println(f+"|"+e);
				if(f!=e)							// �������ڰ� �ƴϸ� ����
				{
					bCheck=false;
					break;
				}
				
			}
			if(bCheck==true)
			{
				System.out.println("�¿��Ī�Դϴ�");
			}
			else
			{
				System.out.println("�¿��Ī�� �ƴմϴ�");
			}
		}
		else
		{
			System.out.println("�Է��� ���� ������ ¦�������Ѵ�");
		}
		
	}
}
