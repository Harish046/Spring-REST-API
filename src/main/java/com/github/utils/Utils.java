package com.github.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	public static boolean checkPattren(String match,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(match);
        return matcher.find();
	}

}
