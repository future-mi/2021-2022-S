package com.sist.exception;
// Check Exception �� �����Ϸ��� ����

import java.io.*; 	// ������ �б�
import java.net.*;  // ������Ʈ ����

// �� ����ó���� �ݵ��  

public class MainClass7 {
	public static void main(String[] args) {
		try
		{
			/*
			 * 		URLconnection(����Ŭ����)
			 * 			|
			 * 		HttpURLConnection(����Ŭ����) 
			 * 
			 * 		HttpURLConnection conn=(HttpURLConnectio)new URLConnection();  // ����ȯ ���������
			 */
			// 1.������Ʈ ����
			URL url=new URL("https://mabinogi.nexon.com/page/main/index.asp");
			HttpURLConnection conn=(HttpURLConnection) url.openConnection(); 	// ����ó���� �ݵ�� �ؾ���
			
			if(conn!=null)		// ����Ǿ��ٸ�
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true)
				{
					String s=br.readLine();
					if(s==null) break;
					System.out.println(s);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
