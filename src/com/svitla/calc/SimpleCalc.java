/**
 * Calc sample for Svitla Systems
 * 30.11.2018  
 * @author Max Tugai
 */
package com.svitla.calc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import com.svitla.calc.operator.Divide;
import com.svitla.calc.operator.Minus;
import com.svitla.calc.operator.Multiply;
import com.svitla.calc.operator.Operator;
import com.svitla.calc.operator.Plus;

/*
 * Performs calculation according RPN algorithm
 */
public class SimpleCalc {
	
	static public final String UNKNOWN_OPERATOR = ">Unknown operator";
	static public final String EXIT_STR = "q";
	
	static HashMap<String, Operator> operators = new HashMap<>();
	
	static {//could be initialized by Spring, but not for such small program
		operators.put("+", new Plus());
		operators.put("-", new Minus());
		operators.put("*", new Multiply());
		operators.put("/", new Divide());
	}

	public void calcLoop(InputStream in, OutputStream out ) throws Exception {
		BufferedWriter outWriter = new BufferedWriter(new OutputStreamWriter(out));
		Scanner scanner = new Scanner(in);
		Stack<Double> numStack = new Stack<>();
		
		outWriter.write(">>> Start of calculation. Press 'q' to stop\n>");
		outWriter.flush();
		
		while (scanner.hasNextLine()) {
			String ln = scanner.nextLine().trim().toLowerCase();
			
			if (EXIT_STR.equals(ln)) {
				break;
			}
			
			Operator op = operators.get(ln);
			double result = 0;
			
			if (op != null) {//token is an operator
				if (numStack.size() < 2) {
					outWriter.write("Not enough operands\n>");
					outWriter.flush();
				}
				else {
					Double n2 = numStack.pop();
					Double n1 = numStack.pop();

					try {
						result = op.perform(n1, n2);
						numStack.push(result);
						outWriter.write(result + "\n>");
						outWriter.flush();
					}
					catch (ArithmeticException e) {
						outWriter.write(e.getMessage() + "\n>");
						outWriter.flush();
					}
				}
			}
			else {//token is an operand
				try {
					result = Double.parseDouble(ln);
					numStack.push(result);
					outWriter.write(result + "\n>");
					outWriter.flush();
				}
				catch (NumberFormatException e)
				{
					outWriter.write("Wrong input\n>");
					outWriter.flush();
				}
			}
		}
		
		outWriter.write(">>>end of calculation\n");
		outWriter.flush();
		outWriter.close();
		scanner.close();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		SimpleCalc calc = new SimpleCalc();
		calc.calcLoop(System.in, System.out);//Other streams could be used - files/sockets/pipes/etc - use spring for flexible linking
	}
}
