package com.sist.lib;
import java.util.*;
public class MainClass5 {
	public static void main(String[] args) {
		//난수발생
		int[] com=new int[3];
		//중복없는 난수 발생
		int su=0; // 난수저장
		boolean bCheck=false; //중복여부확인
		//중복이 있으면 난수 재발생, 중복이 없으면 com에 저장
		//난수 1~9사이의 정수 발생
		Random r=new Random();
		for(int i=0;i<3;i++)
		{
			bCheck=true;
			while(bCheck)	// 중복체크
			{
				//난수발생
				su=r.nextInt(9)+1;
				bCheck=false;	//false이면 while문 빠져나오기
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)	// 중복이 있나 확인
					{
						bCheck=true;	//중복이있으면
						break;			//while문 다시 수행
					}
				}
			}
			// 중복없는 정수가 발생
			com[i]=su;
		}
		//	System.out.println(Arrays.toString(com));
			
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			//사용자 입력
			System.out.println("세자리 정수를 입력해라");
			int input=scan.nextInt();
			
			//오류처리 → ||, 정상처리 → &&
			if(input<100 || input>999)
			{
				System.out.println("잘못된 입력입니다");
				continue; 	// while문 처음으로 돌아간다
			}
			//배열에 저장 → 345/100(3)
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			//중복된 수를 입력하면 안된다
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				System.out.println("중복된 수는 사용할 수 없습니다.");
				continue; 	// 다시 처음부터 시작
			}
			//0을 사용할 수 없다
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0을 사용할 수 없습니다.");
				continue;
			}
			//힌트
			int s=0;	// 자리수
			int b=0;	// 숫자
			
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(com[i]==user[j]) 	// 같은 수가 있는지?
					{
						if(i==j)	// 같은자리에 있으면 
							s++;
						else		// 다른 자리에 같은 수가 존재
							b++;
					}
				}
			}
			System.out.printf("Input Number: %d, Result: %dS-%dB\n",input,s,b);
			
			//종료여부확인
			if(s==3)
			{
				System.out.println("정답입니다. GAME OVER");
				break;
			}
		}
		
	}
	
}
