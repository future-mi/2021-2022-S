package com.sist.client;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/*
 *  Ŭ���̾�Ʈ ���� 2��
 *  1) ä�ù��ڿ� ����
 *  2) �����κ��� ä�� ���ڿ��� �о�ͼ� ��� �� ������ 
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientForm extends JFrame
implements Runnable, ActionListener
{	
	// ȭ�� UI����
   JTable table;
   DefaultTableModel model;
   JTextArea ta;
   JTextField tf;
   JButton loginBtn, sendBtn, endBtn;

   // ��Ʈ��ũ ����
   Socket s; 	// ������ ����
   BufferedReader in; // �����κ��� ���� �о�´�
   OutputStream out;  // ������ ��û���� ����
   String name="";
   
   public ClientForm(){
      // ��������� �ʱ�ȭ
      ta = new JTextArea();
      ta.setEditable(false);
      JScrollPane js1 = new JScrollPane(ta); 	// ��ũ�ѹ� �����
      tf = new JTextField();
      loginBtn = new JButton("�α���");
      sendBtn = new JButton("����");
      endBtn = new JButton("����");

      String[] col = { "ID", "Name", "Sex" };
      String[][] row = new String[0][3];
      model = new DefaultTableModel(row, col);
      table = new JTable(model);
      JScrollPane js2 = new JScrollPane(table);
      // Spring / AWS / MyBatis
      // Spring-Boot == VueJS , ReactJS AI
      // �����쿡 ��ġ
      setLayout(null);
      js2.setBounds(10, 15, 500, 200);
      js1.setBounds(10, 220, 500, 250);
      tf.setBounds(10, 475, 500, 30);

      JPanel p = new JPanel();
      p.add(loginBtn);
      p.add(endBtn);
      p.setBounds(10, 510, 500, 35);
      
      // �߰�
      add(js1);
      add(js2);
      add(tf);
      add(p);
      setSize(550, 590);
      setVisible(true);
      
      // ���(�̺�Ʈ)
      loginBtn.addActionListener(this); // click �� actionperformed
      tf.addActionListener(this);	// enter �� actionperformed
   }

   public static void main(String[] args) {
      new ClientForm();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==loginBtn)	// �α��� ��ư�� Ŭ���ߴٸ�
	   {
		   name=JOptionPane.showInputDialog("�̸��Է�");
		   try
		   {
			   s=new Socket("localhost",3355);
			   in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			   // �������� ������ �����Ͱ� 1byte �� 2byte�� ��ȯ �Ŀ� �޴´�
			   out=s.getOutputStream();
		   } catch (Exception ex) {}
		   //�������� �����°��� ���
		   new Thread(this).start(); //run()�� ȣ���ؼ� ���(�ٸ������ ���� �����͸� ���)
	   }
	
	   if(e.getSource()==tf)// ä�ÿ��� enter�� �ߴٸ�
	   {
		   //������ ���ڿ��� ������
		   try
		   {
			//����ڰ� �Է��� ä�ù��ڿ� �б�
			   String msg=tf.getText();
			   if(msg.length()<1)return;
			   out.write(("["+name+"]"+msg+"\n").getBytes());
			   
			   tf.setText("");
		   } catch (Exception ex) {}
	   }
   }

   @Override
   public void run() {
	   // �������� ������ ���� ���
	while(true)
	{
		try
		{
			String msg=in.readLine();
			ta.append(msg+"\n");
		} catch (Exception ex) {}
	}
   }
}