package com.sist.exception;

// ��ü try~catch �� �޼ҵ� ��, ������, �ʱ�ȭ��� / Ŭ������Ͽ����� ��� �� �� ����

public class MainClass4 {
	// ���� �ϴ� ����
	
	public static void main(String[] args) {
		// ��ü����ó��
	//	try
	//	{
			// ������ �����Ҷ��� for���ȿ� try~catch�� �־��ֱ�
			for(int i=1; i<=10; i++)
			{
				try
				{
				int j=(int)(Math.random()*3); //0,1,2 �߿� �ϳ� �߻�
				int k=i/j;
				System.out.println("k="+k);
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage()); // try~catch���� for���ȿ� ������ 10���� �� ������
					i++;
				}
			}
	//	}catch(Exception ex)			//	try~catch���� �ۿ����� �� for���� ���ٰ� �������ϱ� catch�� ã������ �ߴ��ϰ� ����
	//	{
	//		System.out.println(ex.getMessage());
	//	}
		
		/*
		 *  getMessage �� ���� �����޼����� ���
		 *  printStackTrace �� ������ �κ� üũ(�ټ�)
		 *  
		 */
	}
}
