package com.rathi.tddcalculator.stringcalculator;

import org.junit.jupiter.api.BeforeAll;

public class StringCalculatorTest {

	private static StringCalculator stringCalculator;
	
	@BeforeAll
	public static void setUp() {
		stringCalculator = new StringCalculator();
	}
	
}
