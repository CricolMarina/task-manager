package com.stefanini.taskmanager.command.utils;

public class StrUtil {

	public static String getSubtrByStr(String str) {
		int i = str.indexOf("=");
		return str.substring(i+1);
	}
}
