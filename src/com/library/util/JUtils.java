package com.library.util;

/**
 * @author Administrator
 * ������
 */
public class JUtils {

	/**
	 * �Ƿ���ת��������
	 * @param str
	 * @return
	 */
	public static boolean changeToNum(String str) {
		boolean isNum = str.matches("[0-9]+");
		
		return isNum;
	}
}
