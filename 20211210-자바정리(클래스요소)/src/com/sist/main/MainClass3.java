package com.sist.main;
// �迭
/*
 *  �޼ҵ� : ����
 *  	- ������ / �Ű�����(�Ϲݰ�,�ּҰ�)
 */
class A
{
	int a=100;
}


class Swap2 {
	// public int[] changeArray(int[] arr) <�������
	public void changeArray(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public void changeValue(A aa)
	{
		aa.a=10000;
	}
}
public class MainClass3 {
	public static void main(String[] args) {
		int[] arr={10,50,60,30,20};
		Swap2 s1=new Swap2();
		s1.changeArray(arr); 		// arr�� �ּ���ü�� ����(������ü�� �Ѱܼ� ����)
		// Call By Reference : Ŭ����, �迭 
		for(int i:arr)
		{
			System.out.println(i+" ");
		}
		A a=new A();
		System.out.println("a.a="+a.a);
		System.out.println("=====changevalue=====");
		s1.changeValue(a);
		System.out.println("a.a="+a.a);
	}
}
