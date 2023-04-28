/**
 * <h1>Recursion Assignment Set 1</h1>
 * Set 1 of Recursion Assignment. Provides recursive and iterative methods for
 * finding the sum of the integers from 1 to a number, and for calculating
 * exponents.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-04-14
 *
 * @author Luke Mathieu
 */

public class Recursion_Assignment_Set1 {

    /**
     * Iteratively finds the sum of all numbers from 1 to a number.
     * @param num The last number of the series, positive.
     * @return The sum of integers from 1 to num, inclusive.
     */
    public int sum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Recursively finds the sum of all numbers from 1 to a number.
     * @param num The last number of the series, positive.
     * @return The sum of integers from 1 to num, inclusive.
     */
    public int sumR(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sumR(num-1);
    }

    /**
     * Iteratively calculates the integer value of the expression base^exponent.
     * @param base The base of the exponent
     * @param exponent The power of the exponent
     * @return The value of the base raised to the power of the exponent
     */
    public int timeTable(int base, int exponent) {
        int total = 1;
        for (int i = 0; i < exponent; i++) {
            total *= base;
        }
        return total;
    }

    /**
     * Recursively calculates the integer value of the expression base^exponent.
     * @param base The base of the exponent
     * @param exponent The power of the exponent
     * @return The value of the base raised to the power of the exponent
     */
    public int timeTableR(int base, int exponent) {
        if (exponent <= 0) {
            return 1;
        }
        return base * timeTableR(base, exponent - 1);
    }
}
