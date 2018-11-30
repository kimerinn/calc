package com.svitla.calc.operator;

/**
 * @author Max Tugai
 * Base interface for all calculator operators
 *
 */

public interface Operator {

	double perform(double n1, double n2) throws Exception;
}
