package com.rathi.tddcalculator.stringcalculator;

public class StringCalculator {

	public int add(String str) {
		if (str.equals("")) {
			return 0;
		}
		
		String[] sNumbs = splitNumbers(str);
		int ans = addNumbers(sNumbs);
		return ans;
	}
	
	private String[] splitNumbers(String numString) {
		String[] sNumbs = numString.split(",");
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
