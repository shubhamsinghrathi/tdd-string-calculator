package com.rathi.tddcalculator.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
	
	@Test
	public void twoNumberStringTest() {
		assertEquals(3, stringCalculator.add("1,2"));
	}
	
	@Test
	public void multiNumberStringTest() {
		assertEquals(10, stringCalculator.add("1,2,3,4"));
	}
	
	@Test
	public void inputWithNewLineTest() {
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void simpleDifferentDelimiterTest() {
		assertEquals(3, stringCalculator.add("//;\n1;2"));
	}
	
	@Test
	public void negativeNumberTest() {
		try {
			stringCalculator.add("-5");
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Negative input found: -5", e.getMessage());
		}
		
		try {
			stringCalculator.add("-1,-2,3");
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Negative input found: -1, -2", e.getMessage());
		}
	}
	
	@Test
	public void getCalledCountTest() {
		StringCalculator strCalculator = new StringCalculator();
		strCalculator.add("");
		strCalculator.add("");
		strCalculator.add("");
		assertEquals(3, strCalculator.getCalledCount());
	}
	
}
