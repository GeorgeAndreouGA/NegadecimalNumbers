package hw1;

/*
* A brief summary about this class.
* Takes two negadecimal numbers and one valid operator from class NegadecimalCalculator.
* This class acts as an  object created by the class NegadecimalCalculator.It is helper class
* 
*
* @author George Andreou
* @since 13/2/15
* @see Homeworks.hw1.NegadecimalCalculator.java
*/
public class NegadecimalNumber {
	private int negadecimal;

	/**
	 * Constructs a NegadecimalNumber object with the specified negadecimal operands
	 * and operation.
	 * 
	 * @param negadecimal The first negadecima operand.
	 */
	public NegadecimalNumber(int negadecimal) {
		this.negadecimal = negadecimal;
	}

	/*
	 * Retrieves the value of the first negadecimal operand.
	 * 
	 * @return The value of the first negadecima operand.
	 */
	public int getNegadecimal() {
		return negadecimal;
	}

	/**
	 * Processes the given expression to evaluate negadecimal arithmetic. It checks
	 * for input validity, including missing operands or operators, and wrong input
	 * format. Parses the expression, extracts operands and operator, then performs
	 * negadecimal to decimal conversion and evaluation. If the expression is
	 * invalid, it prints an error message. If the expression is valid, it creates a
	 * NegadecimalCalculator object and performs the necessary calculations.
	 * 
	 * @param expression The expression to be processed.
	 * @throws If the provided expression is empty, the method prints "No expression
	 *            found" and returns. If the expression starts or ends with an
	 *            operator (+, -, *, /), it prints "Wrong Input" and returns. If the
	 *            expression contains no operators or more than one operator, it
	 *            prints "Wrong Input" and returns.
	 */
	public static String processExpression(String expression) {
		if (expression.length() == 0) {
			return "No frase found";

		}
		String exWithOutBlanks = expression.replaceAll("\\s", "");
		if ((exWithOutBlanks.charAt(0) == '+') || (exWithOutBlanks.charAt(0) == '-')
				|| (exWithOutBlanks.charAt(0) == '/') || (exWithOutBlanks.charAt(0) == '*')) {
			return expression + " = " + "Wrong Input";
		} else if ((exWithOutBlanks.charAt(exWithOutBlanks.length() - 1) == '+')
				|| (exWithOutBlanks.charAt(exWithOutBlanks.length() - 1) == '-')
				|| (exWithOutBlanks.charAt(exWithOutBlanks.length() - 1) == '/')
				|| (exWithOutBlanks.charAt(exWithOutBlanks.length() - 1) == '*')) {
			return expression + " = " + "Wrong Input";
		} else {
			int plithOp = 0;
			for (int i = 0; i < exWithOutBlanks.length(); i++)
				if ((exWithOutBlanks.charAt(i) == '+') || (exWithOutBlanks.charAt(i) == '-')
						|| (exWithOutBlanks.charAt(i) == '/') || (exWithOutBlanks.charAt(i) == '*'))
					plithOp++;

			if (plithOp == 0 || plithOp > 1)
				return expression + " = " + "Wrong Input";

			String frase = "";
			int neg2 = 0, neg1 = 0;
			char op = ' ';
			for (int i = 0; i < exWithOutBlanks.length(); i++)
				if (exWithOutBlanks.charAt(i) != '+' && exWithOutBlanks.charAt(i) != '-'
						&& exWithOutBlanks.charAt(i) != '*' && exWithOutBlanks.charAt(i) != '/')
					frase += exWithOutBlanks.charAt(i);
				else {
					if (checkEqualsWithSelf(frase)) {
						neg1 = Integer.parseInt(frase);
						op = exWithOutBlanks.charAt(i);
						frase = "";
					} else {
						return expression + " = " + "Wrong Input";

					}
				}
			if (checkEqualsWithSelf(frase))
				neg2 = Integer.parseInt(frase);
			else {
				return expression + " = " + "Wrong Input";
			}

			NegadecimalCalculator aritmeticExpression = new NegadecimalCalculator(neg1, neg2, op);

			return expression + " = " + aritmeticExpression.equation();
		}
	}

	/**
	 * Checks if the provided string contains only numerical characters. Removes
	 * non-numerical characters and compares the result with the original string.
	 * Returns true if the modified string equals the original, indicating it
	 * contains only numbers. Otherwise, returns false.
	 * 
	 * @param phrase The string to check.
	 * @return true if the string consists of only numeric characters, false
	 *         otherwise.
	 */
	private static boolean checkEqualsWithSelf(String frase) {
		String fraseOnlyNumbers = "";
		for (int j = 0; j < frase.length(); j++)
			if (frase.charAt(j) >= '0' && frase.charAt(j) <= '9')
				fraseOnlyNumbers += frase.charAt(j);

		if (fraseOnlyNumbers.equals(frase))
			return true;
		return false;
	}
}
