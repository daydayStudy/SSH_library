package com.library.util;

/**
 * @author Administrator
 * 工具栏
 */
public class JUtils {

	/**
	 * 是否能转换成整数
	 * @param str
	 * @return
	 */
	public static boolean changeToNum(String str) {
		boolean isNum = str.matches("[0-9]+");
		
		return isNum;
	}
}
