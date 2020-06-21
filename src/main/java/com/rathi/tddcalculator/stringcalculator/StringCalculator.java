package com.rathi.tddcalculator.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String str) {
		if (str.equals("")) {
			return 0;
		}
		
		String numStr = str;
		String strDelimiter = ",|\n";
		if (str.matches("//(.*)\n(.*)")) {
			Pattern regexPatter = Pattern.compile("(//)(.*)(\n)(.*)");
			Matcher matcher = regexPatter.matcher(str);
			while (matcher.find()) {
				strDelimiter = matcher.group(2) + "|\n";
				numStr = matcher.group(4);	
			}
		}
		
		String[] sNumbs = splitNumbers(numStr, strDelimiter);
		int ans = addNumbers(sNumbs);
		return ans;
	}
	
	private String[] splitNumbers(String numString, String strDelimiter) {
		String[] sNumbs = numString.split(strDelimiter);
		return sNumbs;
	}
	
	private int addNumbers(String[] numbs) {
		int ans = 0;
		for (String numb: numbs) {	
			ans += Integer.valueOf(numb);
		}
		
		return ans;
	}

}
