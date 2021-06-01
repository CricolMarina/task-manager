package com.stefanini.taskmanager.command.utils;

public class StringUtil {
	/**
	 * This method is used to return a new substring that begins 
	 * at the next index of specified symbol "="
	 * @param string
	 * @return string
	 */
	public static String getSubtringByString(String string) {
		int i = string.indexOf("=");
		return string.substring(i+1);
		}
	}
