package com.sist.main;
// ������ ����Ǿ��ִ� �ҽ�
/*
 *		�޼ҵ�() throws ����ó���� ������ 
 *
 * 		�� ȣ��� ����ó���� �ϰ� ���
 * 			1.�޼ҵ�() throws(����:Exception,Throwalbe)
 * 			2.�޼ҵ�()
 * 				{
 * 					try
 * 					{
 * 					}catch(Exception,Throwalbe){}
 * 				}
 * 
 */
public class MainClass2 {
	// ����(���̺귯��) �� ����Ŭ
	// IO, NetWork, Oracle
	String name;
	public static MainClass2 createClass() throws Exception
	{
		// Ŭ���� �̸����� �޸� �Ҵ��� ����(���÷���)
		// ������ �� Ŭ���� �̸��� �����ϸ� �� �޸��Ҵ�(Ŭ��������)
		// ������ �� Ŭ���� ����
		Class clsName=Class.forName("com.sist.main.MainClass2");
		Object obj=clsName.getDeclaredConstructor().newInstance();
		return (MainClass2)obj;
		// ���ռ�(�ٸ������� �ִ��� ����), ������(�޼ҵ�)
	}
	// �̹� �ڵ尡 �Ǿ��ִ� ���� �� throws(��������)
	// �ڵ尡 ���� ���� �� try~catch(����)
	
	public static void main(String[] args) {
		try
		{
			MainClass2 m=createClass();		//�ݵ�� ����ó���� ���� try~catch or ����throws
			m.name="ȫ�浿";
			System.out.println(m.name);
		} catch (Exception e) {
			
		} 
	}
}
