package com.sist.lib;
import java.util.*;
public class MainClass5 {
	public static void main(String[] args) {
		//�����߻�
		int[] com=new int[3];
		//�ߺ����� ���� �߻�
		int su=0; // ��������
		boolean bCheck=false; //�ߺ�����Ȯ��
		//�ߺ��� ������ ���� ��߻�, �ߺ��� ������ com�� ����
		//���� 1~9������ ���� �߻�
		Random r=new Random();
		for(int i=0;i<3;i++)
		{
			bCheck=true;
			while(bCheck)	// �ߺ�üũ
			{
				//�����߻�
				su=r.nextInt(9)+1;
				bCheck=false;	//false�̸� while�� ����������
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)	// �ߺ��� �ֳ� Ȯ��
					{
						bCheck=true;	//�ߺ���������
						break;			//while�� �ٽ� ����
					}
				}
			}
			// �ߺ����� ������ �߻�
			com[i]=su;
		}
		//	System.out.println(Arrays.toString(com));
			
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			//����� �Է�
			System.out.println("���ڸ� ������ �Է��ض�");
			int input=scan.nextInt();
			
			//����ó�� �� ||, ����ó�� �� &&
			if(input<100 || input>999)
			{
				System.out.println("�߸��� �Է��Դϴ�");
				continue; 	// while�� ó������ ���ư���
			}
			//�迭�� ���� �� 345/100(3)
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			//�ߺ��� ���� �Է��ϸ� �ȵȴ�
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				System.out.println("�ߺ��� ���� ����� �� �����ϴ�.");
				continue; 	// �ٽ� ó������ ����
			}
			//0�� ����� �� ����
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0�� ����� �� �����ϴ�.");
				continue;
			}
			//��Ʈ
			int s=0;	// �ڸ���
			int b=0;	// ����
			
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(com[i]==user[j]) 	// ���� ���� �ִ���?
					{
						if(i==j)	// �����ڸ��� ������ 
							s++;
						else		// �ٸ� �ڸ��� ���� ���� ����
							b++;
					}
				}
			}
			System.out.printf("Input Number: %d, Result: %dS-%dB\n",input,s,b);
			
			//���Ῡ��Ȯ��
			if(s==3)
			{
				System.out.println("�����Դϴ�. GAME OVER");
				break;
			}
		}
		
	}
	
}
