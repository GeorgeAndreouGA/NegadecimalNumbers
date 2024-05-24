package hw1;

/*
* A brief summary about this class.
* Gives the result of two negadecimal numbers.It takes the two numbers from class TestNegadecimal
* then converts each number from negadecimal to decimal,
* makes equation and converts back the result to negadecimal.
* 
*
* @author George Andreou
* @since 13/2/15
* @see Homeworks.hw1.NegadecimalNumber.java
*/
public class NegadecimalCalculator {
	private NegadecimalNumber NegNum1;
	private NegadecimalNumber NegNum2;
	private char op;

	public NegadecimalCalculator(int neg1, int neg2, char op) {
		NegNum1 = new NegadecimalNumber(neg1);
		NegNum2 = new NegadecimalNumber(neg2);
		this.op = op;
	}

	/**
	 * Converts the two negadecimal numbers held in the object to decimal
	 * representation. Retrieves the negadecimal operands from the object. Iterates
	 * over each negadecimal operand and converts it to decimal using the formula
	 * sum += (temp * Math.pow((-10), j)). Stores the decimal representations in an
	 * array and passes it to the equation() method.
	 * 
	 * @return int[] array
	 */
	private int[] negToDec() {
		int[] holdNeg = new int[2];
		int[] holdDec = new int[2];
		holdNeg[0] = this.NegNum1.getNegadecimal();
		holdNeg[1] = this.NegNum2.getNegadecimal();
		int sum, j;
		for (int i = 0; i < holdNeg.length; i++) {
			sum = 0;
			j = 0;
			while (holdNeg[i] > 0) {
				int temp = holdNeg[i] % 10;
				sum += (temp * Math.pow((-10), j));
				holdNeg[i] /= 10;
				j++;
			}
			holdDec[i] = sum;
		}

		return holdDec;

	}

	/**
	 * Converts an integer decimal to neggadecimal. Shows the end result
	 * 
	 * @param integer decimal The integer decimal to convert.
	 * 
	 */
	private static String toNegativeBase(int integer) {
		int base = -10;
		String result = "";
		int number = integer;
		while (number != 0) {
			int i = number % base;
			number /= base;
			if (i < 0) {
				i += Math.abs(base);
				number++;
			}
			result = i + result;
		}
		return result + "";
	}

	/**
	 * Chooses the appropriate operation based on the operator stored in the
	 * twoNegNum object and performs the operation on the decimal equivalents of
	 * negadecimal numbers.
	 * 
	 * @param holdDec An array containing the decimal equivalents of the two
	 *                negadecimal numbers.
	 * @throws It handles division by zero and checks if the result of division is
	 *            an integer.If it is not integer it throws error
	 */
	public String equation() {
		int[] holdDec = this.negToDec();
		if (this.op == '+')
			return toNegativeBase(holdDec[0] + holdDec[1]);
		else if (this.op == '-' && holdDec[1] <= 0)
			return toNegativeBase(holdDec[0] + Math.abs(holdDec[1]));
		else if (this.op == '-' && holdDec[1] >= 0)
			return toNegativeBase(holdDec[0] - holdDec[1]);
		else if (this.op == '*')
			return toNegativeBase(holdDec[0] * holdDec[1]);
		else if (this.op == '/' && holdDec[1] != 0) {
			if ((((double) holdDec[0] / holdDec[1]) - (int) (holdDec[0] / holdDec[1])) == 0)
				return toNegativeBase(holdDec[0] / holdDec[1]);
			else
				return "The divition of the two numbers are not intiger";

		} else
			return "can't divine by 0";

	}

}
