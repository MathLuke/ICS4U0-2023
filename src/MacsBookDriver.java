import java.io.IOException;

/**
 * <h1>EXERCISE TITLE</h1>
 * CLASS DESCRIPTION
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
    public static void main(String[] args) {
        try {
            MacsBook macsBook = new MacsBook();
            macsBook.menu();
        } catch (IOException ignored) {

        }
    }
}
