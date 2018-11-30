package com.svitla.calc.operator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivideTest {

	@Test
	void test() throws Exception {
		Divide div = new Divide();
		assertEquals(4.0, div.perform(12, 3));
	}

	void testDivByZero() throws Exception {
		Divide div = new Divide();
		
		try {
			div.perform(12, 0);
			throw new Exception("Should not come to this point");
		}
		catch (ArithmeticException e) {
			assertEquals("Division by zero", e.getMessage());
		}
	}
}
