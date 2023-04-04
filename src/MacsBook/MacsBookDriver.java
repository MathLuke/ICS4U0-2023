package MacsBook;

import java.io.IOException;

/**
 * <h1>MacsBook Assignment Driver Class</h1>
 * Driver class to the MacsBook Assignment. Runs the menu() function from
 * the MacsBook class.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-31
 *
 * @author Daphne Tu, Luke Mathieu, and Henry Zhang
 */

public class MacsBookDriver {

    // main method 
    public static void main(String[] args) throws IOException {
        MacsBook mb = new MacsBook();
        while(!mb.menu()){}
    }
}
