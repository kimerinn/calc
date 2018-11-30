package com.svitla.calc.operator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlusTest {

	@Test
	void test() throws Exception{
		Plus plus = new Plus();
		assertEquals(2.0, plus.perform(1, 1));
	}

}
