package com.rathi.tddcalculator.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private int totalAddCalls = 0;
	
	public int add(String str) {
		totalAddCalls += 1;
		if (str.equals("")) {
			return 0;
		}
		
		String[] splitterStr = getNumStringAndDelimiter(str);
		String numStr = splitterStr[0];
		String strDelimiter = splitterStr[1];
		
		String[] sNumbs = splitNumbers(numStr, strDelimiter);
		int ans = addNumbers(sNumbs);
		return ans;
	}
	
	private String[] getNumStringAndDelimiter(String str) {
		String numStr = str;
		String delimiter = ",|\n";
		if (str.matches("//(.*)\n(.*)")) {
			Pattern regexPatter = Pattern.compile("(//)(.*)(\n)(.*)");
			Matcher matcher = regexPatter.matcher(str);
			while (matcher.find()) {
				String limiter = "\n";
		        String[] limiterArr = matcher.group(2).split("\\]|\\[");
		        for (String l: limiterArr) {
		            if (!l.equals("")) {
		            	limiter += "|" + l;
		            }
		        }
		        delimiter = limiter;
				numStr = matcher.group(4);	
			}
		}
		return new String[] {numStr, delimiter};
	}
	
	private String[] splitNumbers(String numString, String strDelimiter) {
		String[] sNumbs = numString.split(strDelimiter);
		return sNumbs;
	}
	
	private int addNumbers(String[] numbs) {
		int ans = 0;
		String negativeInputs = "";
		for (String numb: numbs) {	
			int numbInt = Integer.valueOf(numb);
			
			if (numbInt < 0) {
				if (negativeInputs.equals("")) {
					negativeInputs = numb;
				} else {
					negativeInputs += ", " + numb;
				}
			}
			
			if (numbInt > 1000) {
				continue;
			}
			ans += numbInt;
		}
		
		if(!negativeInputs.equals("")){
			throw new IllegalArgumentException("Negative input found: " + negativeInputs);
		}
		
		return ans;
	}

	public int getCalledCount() {
		return totalAddCalls;
	}

}
