package com.notifier.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
