/**
 * <h1>Recursion Assignment Set 2</h1>
 * Set 2 of Recursion Assignments. Implements recursive methods to find the number
 * of occurrences of a character within a string, find the GCD (Greatest Common Divisor) of
 * two integers, and to find the cheapest path to traverse a 2D Array.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-04-14
 *
 * @author Luke Mathieu
 */

public class Recursion_Assignment_Set2 {

    /**
     * Recursively counts the number of occurrences of a character in a String
     * @param str The String to be searched
     * @param c The character to be detected
     * @return The number of occurrences of the character within the String.
     */
    public int count(String str, char c) {
        if (str.length() == 0) {
            return 0;
        }

        if (str.charAt(0) == c) {
            return 1 + count(str.substring(1), c);
        } else {
            return count(str.substring(1), c);
        }
    }

    /**
     * Recursively finds the greatest common divisor of two numbers.
     * @param a An integer.
     * @param b Another integer.
     * @return The greatest common divisor of integers a and b.
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    /**
     * Given a rectangular 2-dimensional array of integers, recursively find the cheapest path from the
     * bottom-left corner (map[map.length-1][0]) to the top right corner of the array (map[0][map[0].length-1]),
     * travelling only upwards and leftwards from the starting location.
     * @param map The 2D array to be traversed.
     * @param row The row of the beginning location (map.length - 1).
     * @param column The column of the beginning location (0).
     * @return The cheapest path from map[row][column] to map[0][map[0].length-1] travelling only upwards and leftwards.
     */
    public int findCheapestPath (int[][] map, int row, int column) {
        if (row < 0 || column > map.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (row == 0 && column == map.length - 1) {
            return map[0][map.length - 1];
        }
        return map[row][column] + Math.min(findCheapestPath(map, row-1, column), findCheapestPath(map, row, column+1));
    }
}
