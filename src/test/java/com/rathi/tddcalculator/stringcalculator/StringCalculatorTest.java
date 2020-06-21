package com.rathi.tddcalculator.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	private static StringCalculator stringCalculator;
	
	@BeforeAll
	public static void setUp() {
		stringCalculator = new StringCalculator();
	}
	
	@Test
	public void emptyStringTest() {
		assertEquals(0, stringCalculator.add(""));
	}
	
	@Test
	public void singleNumberStringTest() {
		assertEquals(1, stringCalculator.add("1"));
	}
	
}
