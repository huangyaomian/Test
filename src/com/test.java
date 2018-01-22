package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class test
{
    public static void main( String args[] ){
 
      // 按指定模式在字符串查找
    	String ID ="User 0%, System 1%, IOW 0%, IRQ 0%";
//    	if (ID.contains("com.hx.socialapp")) {
			ID = ID.substring(ID.indexOf("User")+4, ID.indexOf("User")+8);
			System.out.println(ID);
//		}
   }
}