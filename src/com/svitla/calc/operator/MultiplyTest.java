package com.svitla.calc.operator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplyTest {

	@Test
	void test() throws Exception{
		Multiply mul = new Multiply();
		assertEquals(9.0, mul.perform(3, 3));
	}

}
