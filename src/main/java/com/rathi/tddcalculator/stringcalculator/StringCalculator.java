package com.rathi.tddcalculator.stringcalculator;

public class StringCalculator {

	public int add(String str) {
		if (str.equals("")) {
			return 0;
		}
		
		String[] sNumbs = str.split(",");
		int ans = 0;
		for (String numb: sNumbs) {
			ans += Integer.valueOf(numb);
		}
		return ans;
	}

}
