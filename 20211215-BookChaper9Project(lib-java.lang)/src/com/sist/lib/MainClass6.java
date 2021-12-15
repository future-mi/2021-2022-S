package com.sist.lib;
/*
 *  replace(char c1,char c2) 			¡æ c1À» c2·Î ¹Ù²ã¶ó
 *  replace(String s1,String s2) 		¡æ s1À» s2·Î ¹Ù²ã¶ó
 *  replaceAll(String regex,String s) 	¡æ regex¸¦ s·Î ¹Ù²Ù´Âµ¥ Á¤±Ô½Ä »ç¿ë
 *  
 *  [¹®ÀÚÀÇ Çü½Ä]
 *  211.238.142.181
 *  127.0.0.1
 *  211.63.64.10
 *  211.238.142.1
 *  ¡æ [0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3} ¡æ ÀÌ·±½ÄÀ¸·Î Çü½Ä regex
 *  
 *  ¸ÀÀÖ´Â ¸ÀÀÖ°í ¸ÀÀÖ°Ô ¸ÀÀÖ°í.....
 *  ¡æ ¸ÀÀÖ+ (+´Â µÚ¿¡ ÇÑ±ÛÀÚÀÖ´Ù´Â ¶æ?)
 */
public class MainClass6 {
	public static void main(String[] args) {
		String s="Hello Java!!";
		String s1=s.replace('a', 'b');
		System.out.println(s1);		// Hello Jbvb!!
		String s2=s.replace("ll", "LL");
		System.out.println(s2);		// HeLLo Java!!
		
		String data="AAABBBcccddd1234567890 ¾È³çÇÏ¼¼¿ä ÀÚ¹ÙÀÔ´Ï´Ù";
		String ss=data.replaceAll("[A-Za-z0-9]", "");
		System.out.println("ss= "+ss);
		String ss1=data.replaceAll("[^A-Z]", "");
		System.out.println("ss1= "+ss1);
		
		//[A-Z] ¡æ ¾ËÆÄºª ´ë¹®ÀÚ ÀüÃ¼
		// [^A-Z] ¡æ ´ë¹®ÀÚ¸¦ Á¦¿ÜÇÏ°í
		String ss2=data.replaceAll("[^a-z]", "");
		// ¼Ò¹®ÀÚ ¡æ a-z
		System.out.println(ss2);
		String ss3=data.replaceAll("[^0-9]", "");
		// ¼ıÀÚ ¡æ 0-9
		System.out.println(ss3);
		String ss4=data.replaceAll("[^°¡-ÆR]", "");
		// ÇÑ±Û ¡æ °¡-ÆR
		// ^ºÎÁ¤(Á¦¿ÜÇÏ°í)
		// [^]ºÎÁ¤
		// ^[°¡-ÆR] ¡æ ÇÑ±Û·Î ½ÃÀÛÇÑ ¸ğµç ¹®ÀÚ
		// [0-9]$ ¡æ ¼ıÀÚ·Î ³¡³ª´Â ¸ğµç °Í
		// ^[°¡|³ª] ¡æ °¡ or ³ª·Î ½ÃÀÛÇÏ´Â ¸ğµç ¹®ÀÚ¿­
		// * ¡æ 0¹øÀÌ»ó
		// + ¡æ 1¹øÀÌ»ó
		// ^,$,|,+,* ¡æ »ç¿ëµÇ´Â ±âÈ£ / *, + ¡æ ½ÇÁ¦¹®ÀÚ¸¦ Ã£À» ¶§´Â \\+ ÀÌ·±½ÄÀ¸·Î ÀÔ·ÂÇØ¾ßÇÔ
		System.out.println(ss4);		
	}
}
