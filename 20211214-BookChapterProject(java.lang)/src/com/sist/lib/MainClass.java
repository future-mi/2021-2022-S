package com.sist.lib;
/*
 * 	ÀÚ¹Ù¸¦ Àß ÇÏ·Á¸é
 * 	1. ¹®¹ı (1~8Àå : º¯¼ö, ¹è¿­, Å¬·¡½º, ¿¬»êÀÚ, Á¦¾î¹®, ¸Ş¼Òµå)
 * 	2. ¿ëµµ 
 * 		- Å¬·¡½º(ÀÎÅÍÆäÀÌ½º,¸Ş¼Òµå(¸®ÅÏÇü,¸Å°³º¯¼ö)
 * 			¡æ ¿¹¿ÜÃ³¸®(try~catch, throws)
 * 		- ¸Ş¼Òµå
 * 		- º¯¼ö(ÀÎ½ºÅÏ½º,static)
 * 		
 * 	3. Á¶¸³ÇÏ´Â ¹æ¹ı(»ç¿ëÀÚ Á¤ÀÇ Å¬·¡½º+¶óÀÌºê·¯¸®)
 * 	4. ¼ø¼­(¾Ë°í¸®Áò)
 * 		- ¼Ò½º¸¦ ¾Ï±â ¡æ ¼ø¼­
 * 		- ÀÚ¹Ù¿¡¼­ °¡Àå ½¬¿î ÇÁ·Î±×·¥(³×Æ®¿öÅ©/µ¥ÀÌÅÍº£ÀÌ½º) ¡æ ¸ğµç °³¹ßÀÚ°¡ µ¿ÀÏÇÏ°Ô ÄÚµù
 * 		- ±¸±¸´Ü(2Â÷ for) / ÆäÀÌÁö(1Â÷ for)
 * 		- ¹İº¹ / À§Ä¡È®ÀÎ / CV ¡æ ºĞ¼®
 * ==================================================================
 * 	java.lang  java.util java.io  java.net  java.sql  java.text
 * 	java.xml	org.w3c.dom		org.w3c.sax		javax.http(JSP)
 * 
 * 	1.java.lang : import¸¦ »ı·« ÇÒ ¼ö ÀÖ´Ù
 * 		1)Object : ¸ğµç Å¬·¡½º(»ç¿ëÀÚÁ¤ÀÇ,¶óÀÌºê·¯¸®)ÀÇ »ó¼ÓÀ» ³»¸®´Â Å¬·¡½º
 * 			Class A(extends Object) »ı·«ÀÌ µÈ´Ù
 * 			- toString(°´Ã¼¸¦ ¹®ÀÚ¿­È­)
 * 			- finalize() : ¼Ò¸êÀÚ ¸Ş¼Òµå(°´Ã¼°¡ ¸Ş¸ğ¸®¿¡¼­ ÇØÁ¦, ÀÚµ¿È£ÃâµÇ´Â ¸Ş¼Òµå)
 * 			- clone() : º¹Á¦ ¡æ ½ºÇÁ¸µ(prototype)
 * 		2)String / StringBuffer /StringBuilder
 * 			¶óÀÌºê·¯¸® : ¿øÇü, ¿ëµµ¸¦ ±â¾ïÇÏ°í »ç¿ëÇÏ±â
 * 			(1) String(¹®ÀÚ¿­À» Á¦¾îÇÏ´Â ¸Ş¼Òµå)
 *	 			- length() : ¹®ÀÚ°¹¼ö ¡æ  ...
 *							 ¡æ ¿øÇü : public int length()
 *				- equals() : ¹®ÀÚ¿­ ºñ±³(==Àº »ç¿ëÇÏÁö ¾ÊÀ½) / ·Î±×ÀÎ, idÁßº¹Ã¼Å©½Ã »ç¿ë / ´ë¼Ò¹®ÀÚ ±¸ºĞ
 *							 ¡æ ¿øÇü : public boolean equals(String s)
 *				- equalsIngnoreCase() : ¹®ÀÚ¿­ ºñ±³ / ´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀ½ / °Ë»öÇÒ ¶§ »ç¿ë
 *							 ¡æ ¿øÇü : public boolean equalsIngnoreCase(String s)
 * 				- substring() : ¿øÇÏ´Â ºÎºĞ¸¸ ¹®ÀÚ¿­À» ÀÚ¸£´Â ¿ªÇÒ
 * 							 ¡æ ¿øÇü : public String substring(int start)
 * 									 public String substring(int start,int end)
 *  			- trim() : ÁÂ¿ì °ø¹éÀ» Á¦°ÅÇÒ ¶§ »ç¿ë
 *  						¡æ »ç¿ëÀÚ°¡ ½Ç¼ö·Î space¸¦ »ç¿ëÇßÀ» ¶§ ¿ŞÂÊ¿¡ °ø¹éÀÌ »ı°Ü¼­ Ã£±â°¡ Èûµé ¶§ »ç¿ë
 *  						¡æ ¿øÇü : public String trim() ¡æ °ø¹é¹®ÀÚ Á¦°Å ÈÄ ´Ù½Ã ¸®ÅÏ
 *				- indexOf : ¹®ÀÚ¸¦ Ã£±â(¾Õ¿¡¼­ºÎÅÍ)
 *							¡æ ¿øÇü : public int indexOf(String s)
 *									public int indexOF(char c) 
 *				- lastIndexOf : ¹®ÀÚ¸¦ Ã£±â(µÚ¿¡¼­ºÎÅÍ)
 *								¡æ ¿øÇü : public int lastIndeOf(Sting s)
 *										public int lastIndexOf(char c)
 *				- split() : ¹®ÀÚ¿­À» ºĞ¸®
 *							¡æ ¿øÇü : public String[] split(String regex)
 *				- replace() : ¹®ÀÚ ÇÑ °³¸¦ º¯°æ
 *							¡æ ¿øÇü : public String replace(char c1,char c2)
 *									public String replace(String s1,String s2)
 *				- replaceAll() : ¹®ÀÚ ÀüÃ¼¸¦ º¯°æ(Á¤±Ô½ÄÀ» »ç¿ë)
 *								¡æ ¿øÇü : public String replaceAll(String s1,String s2)
 *										ÇÑ±Û [°¡-ÆR]
 *										¿µ¹® [A-Zz-z]
 *										¼ıÀÚ [0-9]
 *				- charAt() : ¹®ÀÚ¿­ Áß¿¡ ¹®ÀÚ ÇÑ°³¸¦ ÀÚ¸£´Â °æ¿ì
 *							¡æ ¿øÇü : public char charAt(int index)
 * =============================================================
 *				- startsWith : ½ÃÀÛ¹®ÀÚ¿­ÀÌ ¹Ù²ğ ¶§ 
 *								¡æ ¿øÇü : public boolean statWith(String s)
 *				- endsWith : ³¡³ª´Â ¹®ÀÚ¿­ÀÌ ¹Ù²ğ ¶§ 
 *							¡æ ¿øÇü : public boolean endsWith(Sting s)
 *					¡æ ÀÚµ¿¿Ï¼º±â(¼­Á¦½ºÆ®) ¡æ °Ë»ö±â¸¦ ¸¸µé¶§ »ç¿ë, Cookie±¸ºĞ
 * =============================================================
 * 				- toUpperCase : ´ë¹®ÀÚ º¯È¯
 * 								¡æ ¿øÇü : public String toUpperCase()
 * 				- toLowerCase : ¼Ò¹®ÀÚ º¯È¯
 * 								¡æ ¿øÇü : public String toLowerCase()
 * 				- valueOf() : ¸ğµç µ¥ÀÌÅÍÇüÀ» ¹®ÀÚ¿­·Î º¯È¯
 * 							¡æ ¿øÇü : public static String valueOf(int a)
 * 									public static String valueOf(boolean a)
 * 									public static String valueOf(char a) ..... µî
 * 
 * 		3)Math
 * 			- ceil : ¿Ã¸²
 * 			- ramdom : ³­¼ö
 * 		4)Wrapper : ¸ğµç µ¥ÀÌÅÍÇüÀ» Å¬·¡½ºÈ­
 * 			- byte ¡æ Byte
 * 			- short ¡æ Short
 * 			- int ¡æ Integer
 * 			- double ¡æ Double
 * 			- float ¡æ Float
 * 			- boolean ¡æ Boolean
 * 		5)System
 *			- System.in
 *			- System.out
 *			- System.gc() ¡æ ¸ÖÆ¼¹Ìµğ¾î, È­»ó µîÀ» »ç¿ëÇÒ ¶§ / ÀÚµ¿À¸·Î ¸Ş¸ğ¸® È¸¼ö 
 */
class Sawon
{
	private String name;
	public Sawon(String name)
	{
		//»ı¼ºÀÚ ¡æ º¯¼öÀÇ ÃÊ±âÈ­
		System.out.println("Sawon °´Ã¼ ¸Ş¸ğ¸®¿¡ ÀúÀå");
		this.name=name;
	}
	// Ãâ·Â
	public void print()
	{
		// °´Ã¼ ±â´É È°¿ë
		System.out.println("ÀÌ¸§:"+name);
	}
	
	// ¸Ş¸ğ¸®¿¡ ÇØÁ¦
	// °´Ã¼ÀÇ ¸Ş¸ğ¸®¿¡¼­ »ç¶óÁú ¶§ ÀÚµ¿È£Ãâ µÇ´Â ¸Ş¼Òµå(¼Ò¸êÀÚ)
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("Sawon °´Ã¼ ¸Ş¸ğ¸® ÇØÁ¦");
	}
	
	@Override
	public String toString() {
		return "SawonÀÌ °¡Áö°íÀÖ´Â ÀÌ¸§Àº "+name+"ÀÔ´Ï´Ù";
	}
	// Object¿¡¼­ÀÇ ÀçÁ¤ÀÇ(¿À¹ö¶óÀÌµù) ¡æ toString
}

public class MainClass {
	public static void main(String[] args) {
		// »ç¿ø ±â´É »ç¿ë
		// 1. ¸Ş¸ğ¸® ÀúÀå
		Sawon s=new Sawon("È«±æµ¿");
		System.out.println(s.toString());
		// 2. È°¿ë
		s.print();
		// 3. ¸Ş¸ğ¸® ÇØÁ¦ s=null(GC)
		s=null; // ´õ ÀÌ»ó »ç¿ëÇÏÁö ¾Ê´Â´Ù 
		// 4. Á÷Á¢ÇØÁ¦
		System.gc(); // °¡ºñÁöÄÃ·º¼Ç È£Ãâ(¸Ş¸ğ¸®¿¡¼­ »ç¿ëÇÏÁö ¾Ê°Å³ª, nullÀÏ‹š È¸¼ö)
		// finalize()°¡ È£ÃâµÇ¸é ¸Ş¸ğ¸®¿¡¼­ Á¦°Å
	
	}
	
}
