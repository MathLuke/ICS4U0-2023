package ArrayList_Assignments.MacsBook;

import java.io.IOException;

/**
 * <h1>MacsBook Assignment Driver Class</h1>
 * Driver class to the MacsBook Assignment. Runs the menu() function from
 * the MacsBook class.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-20
 *
 * @author Luke Mathieu and Tom Philip
 */

public class MacsBookDriver {

    // main method 
    public static void main(String[] args) throws IOException {
        MacsBook mb = new MacsBook();
        while(!mb.menu()){}
    }
}
