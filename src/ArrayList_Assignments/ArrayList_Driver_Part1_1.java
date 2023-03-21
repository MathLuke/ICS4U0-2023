package ArrayList_Assignments;

import ArrayList_Assignments.ArrayList_Assignment_Part1_1;

/**
 * <h1>ArrayList Assignment Part 1.1 Driver Class</h1>
 * Driver Class to ArrayList Assignment Part 1.1.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-10
 *
 * @author Luke Mathieu, Tom Philip
 */

public class ArrayList_Driver_Part1_1 {
    // main method
    public static void main(String[] args) {
        ArrayList_Assignment_Part1_1 arrayListAssignmentPart11 = new ArrayList_Assignment_Part1_1();
        System.out.println("Crazy Sentences Assignment by Luke Mathieu and Tom Philip: \n");
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayListAssignmentPart11.generateSentence() + "\n");
        }
    }
}
