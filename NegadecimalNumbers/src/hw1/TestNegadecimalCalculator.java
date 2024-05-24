package hw1;

/*
* A brief summary about this class.
* Takes a file of negadecimal  expressions and gives the result.
* 
* 
*
* @author George Andreou
* @since 13/2/15
* @see Homeworks.hw1.NegadecimalNumber.java
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestNegadecimalCalculator {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(
				new FileReader("/home/george/eclipse-workspace/Homeworks/src/input.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(NegadecimalNumber.processExpression(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
