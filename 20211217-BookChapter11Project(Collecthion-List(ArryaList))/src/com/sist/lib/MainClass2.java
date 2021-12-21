package com.sist.lib;
// ����� ���� Ŭ����
import java.util.*;

// �Ѱ�(��)�� ���� ������ ����
// �������� ���� �� new �޸𸮸� ���� ��ġ
// ���� �� ������ ��ȣ
class Student
{
	// ���� �� �б�(�޸𸮿��� ������ ���) /  ����(�޸𸮿� �����Ͱ� ����)
	private int hakbun;
	private String name;
	private int kor,eng,math;
	
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	// �ʱ�ȭ�� ���� �����ڿ� �Ű������� ���
	public Student(int hakbun, String name, int kor, int eng, int math) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}

public class MainClass2 {
	public static void main(String[] args) {
		// �л� 5�� ���� �� 5���� ���� �� �� �ִ� �������(�÷���-����,�迭-����)
		ArrayList list=new ArrayList();
		// �л����
		list.add(new Student(1, "ȫ�浿", 89, 90, 85));
		list.add(new Student(2, "�ڹ���", 78, 96, 60));
		list.add(new Student(3, "�Ҽ���", 85, 61, 88));
		list.add(new Student(4, "�̼���", 50, 99, 80));
		list.add(new Student(5, "������", 25, 95, 77));
		list.add(new Student(6, "������", 68, 77, 58));
		list.add(new Student(7, "�����", 99, 90, 98));
		
		// ���, �Է�, ����, ����...�޼ҵ�
		// ��� �� ����, ���
		for(int i=0;i<list.size();i++)
		{
			// ����� �����͸� �Ѱ��� �о����
			Student std=(Student)list.get(i);
			// ���
			// d(����) s(���ڿ�) c(����)  f(�Ǽ�)
			System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath(),
					(std.getKor()+std.getEng()+std.getMath()),
					(std.getKor()+std.getEng()+std.getMath())/3.0);
		}
		// �߰� �� ����(���ϴ� ��ŭ �߰��ؼ� ���� ����)
/*
		System.out.println("===�л������� 5�� �߰�===");
		
		Scanner scan=new Scanner(System.in);
		System.out.print("�й��Է�:");
		int hakbunn=scan.nextInt();
		System.out.print("�̸��Է�:");
		String name=scan.next();
		System.out.print("�����Է�:");
		int kor=scan.nextInt();
		System.out.print("�����Է�:");
		int eng=scan.nextInt();
		System.out.print("�����Է�:");
		int math=scan.nextInt();
		
		// list�� ����
		Student s=new Student(hakbunn, name, kor, eng, math);
		list.add(s);
		
		for(int i=0;i<list.size();i++)
		{
			Student std=(Student)list.get(i);	
			System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath(),
					(std.getKor()+std.getEng()+std.getMath()),
					(std.getKor()+std.getEng()+std.getMath())/3.0);
		}
*/	
/*
		System.out.println("===����(�л�) remove===");
		System.out.println("�л���: "+list.size());
		list.remove((int)(Math.random()*5));
		//���
		for(int i=0;i<list.size();i++)
		{
			Student std=(Student)list.get(i);	
			System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath(),
					(std.getKor()+std.getEng()+std.getMath()),
					(std.getKor()+std.getEng()+std.getMath())/3.0);
		}
		// ���� �����ִ� �ο��� Ȯ��
		System.out.println("�����л��ο�: "+ list.size());
*/
		System.out.println("====�л����� : set====");
		Scanner scan=new Scanner(System.in);
		String msg="====������ �л��� �����ϼ���====\n";
	
		for(int i=0;i<list.size();i++)
		{
			Student s=(Student)list.get(i);	
			msg+=s.getName()+"("+i+")\n";
		}
		msg=msg.substring(0,msg.lastIndexOf("\n"));
		System.out.print(msg);
		System.out.println();
		System.out.println("������ ����� �����ϼ���");
		int select=scan.nextInt();
		
		System.out.print("�й��Է�:");
		int hakbunn=scan.nextInt();
		System.out.print("�̸��Է�:");
		String name=scan.next();
		System.out.print("�����Է�:");
		int kor=scan.nextInt();
		System.out.print("�����Է�:");
		int eng=scan.nextInt();
		System.out.print("�����Է�:");
		int math=scan.nextInt();
		
		Student s=new Student(hakbunn, name, kor, eng, math);
		list.set(select, s);
		
		for(int i=0;i<list.size();i++)
		{
			Student std=(Student)list.get(i);	
			System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath(),
					(std.getKor()+std.getEng()+std.getMath()),
					(std.getKor()+std.getEng()+std.getMath())/3.0);
		}
		
	}
}
