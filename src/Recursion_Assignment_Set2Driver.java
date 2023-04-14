/**
 * <h1>Recursion Assignment Set 2</h1>
 * Driver class for Set 2 of Recursion Assignments.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-04-13
 *
 * @author Luke Mathieu
 */

public class Recursion_Assignment_Set2Driver {

    // main method 
    public static void main(String[] args) {
        Recursion_Assignment_Set2 set2 = new Recursion_Assignment_Set2();

        System.out.println("Result of calling count(\"this is a test\", 's'): " + set2.count("this is a test", 's'));
        System.out.println("Result of calling count(\"this is a test\", 'x'): " + set2.count("this is a test", 'x'));

        System.out.println("Result of calling gcd(12, 6): " + set2.gcd(12, 6));
        System.out.println("Result of calling gcd(13, 7): " + set2.gcd(13, 7));

        int[][] map = {{12, 10, 33, 21}, {15, 20, 14, 24}, {18, 15, 52, 5}, {22, 21, 30, 41}};
        System.out.println("Result of calling findCheapestPath(arr, 0, 3) for given array: " + set2.findCheapestPath(map, 3,0));
    }
}
