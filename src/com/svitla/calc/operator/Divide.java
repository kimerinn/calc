package com.svitla.calc.operator;
/**
 * @author Max Tugai
 * '/' operator
 */

public class Divide implements Operator {

	/* (non-Javadoc)
	 * @see com.svitla.calc.operator.Operator#perform(double, double)
	 * @return n1 / n2
	 */
	@Override
	public double perform(double n1, double n2) throws Exception {
		if (n2 == 0.0) {
			throw new ArithmeticException("Division by zero");//otherwise Infinity will be returned
		}
		
		return n1 / n2;
	}

}
