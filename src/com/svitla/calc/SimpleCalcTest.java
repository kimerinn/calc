package com.svitla.calc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Test;

class SimpleCalcTest {
	private static final String START_LINE = ">>> Start of calculation. Press 'q' to stop\n";
	private static final String TERMINATOR = ">>>end of calculation\n";
	
	@Test
	void testPlus() throws Exception {
		SimpleCalc calc = new SimpleCalc();
		StringBuffer inBuf = new StringBuffer("4\n2\n+\nq\n");
		ByteArrayInputStream in = new ByteArrayInputStream(inBuf.toString().getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		calc.calcLoop(in, out);
		assertEquals(START_LINE + ">4.0\n>2.0\n>6.0\n>" + TERMINATOR, new String(out.toByteArray()));
	}

	@Test
	void testMinus() throws Exception {
		SimpleCalc calc = new SimpleCalc();
		StringBuffer inBuf = new StringBuffer("4\n2\n-\nq\n");
		ByteArrayInputStream in = new ByteArrayInputStream(inBuf.toString().getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		calc.calcLoop(in, out);
		assertEquals(START_LINE + ">4.0\n>2.0\n>2.0\n>" + TERMINATOR, new String(out.toByteArray()));
	}

	@Test
	void testMultiply() throws Exception {
		SimpleCalc calc = new SimpleCalc();
		StringBuffer inBuf = new StringBuffer("4\n2\n*\nq\n");
		ByteArrayInputStream in = new ByteArrayInputStream(inBuf.toString().getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		calc.calcLoop(in, out);
		assertEquals(START_LINE + ">4.0\n>2.0\n>8.0\n>" + TERMINATOR, new String(out.toByteArray()));
	}

	@Test
	void testDivide() throws Exception {
		SimpleCalc calc = new SimpleCalc();
		StringBuffer inBuf = new StringBuffer("4\n2\n/\nq\n");
		ByteArrayInputStream in = new ByteArrayInputStream(inBuf.toString().getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		calc.calcLoop(in, out);
		assertEquals(START_LINE + ">4.0\n>2.0\n>2.0\n>" + TERMINATOR, new String(out.toByteArray()));
	}

	@Test
	void testDivideByZero() throws Exception {
		SimpleCalc calc = new SimpleCalc();
		StringBuffer inBuf = new StringBuffer("4\n0\n/\n5\n4\n+\nq\n");
		ByteArrayInputStream in = new ByteArrayInputStream(inBuf.toString().getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		calc.calcLoop(in, out);
		assertEquals(START_LINE + ">4.0\n>0.0\n>Division by zero\n>5.0\n>4.0\n>9.0\n>" + TERMINATOR, new String(out.toByteArray()));
	}
}
