package com.svitla.calc.operator;

/**
 * @author Max Tugai
 * '-' operator
 */
public class Minus implements Operator {

	/* (non-Javadoc)
	 * @see com.svitla.calc.operator.Operator#perform(double, double)
	 * @return n1 - n2
	 */
	@Override
	public double perform(double n1, double n2) throws Exception {
		return n1 - n2;
	}

}
