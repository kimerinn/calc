package com.svitla.calc.operator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinusTest {

	@Test
	void test() throws Exception{
		Minus minus = new Minus();
		assertEquals(4.0, minus.perform(10, 6));
	}

}
