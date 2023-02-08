package StringReview;

/**
 * <h1>StringReview.StringReview</h1>
 * Program creates two methods for manipulating strings.
 * {@link #replaceChar(String, char, char)} method replaces all occurrences of a character
 * within a string with another character, then outputs the modified string to the console.
 * {@link #splitString(String, char)} splits a string into separate strings based on a character,
 * then stores all the substrings in a String array, and outputs the contents of the array to the
 * console.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 7, 2023
 * @author Luke Mathieu
 *
 */

public class StringReview {
    /** Default fields the methods will use to demonstrate their function.     */
    static String defaultString = "This is the default String.";
    static char defaultTargetChar = ' ';
    static char defaultReplaceChar = '_';
    static char defaultSplitChar = ' ';


    /**
     * Replaces all occurrences of a character within a string with
     * another character. If the character does not appear within
     * the string, the original string is output.
     *
     * @param inputString The string the method will replace characters.
     * @param targetChar Target character to be found and replaced.
     * @param newChar Character that will replace target characters.
     * @return The string after all characters have been replaced.
     */
    public static String replaceChar (String inputString, char targetChar, char newChar) {
        String outputString = "";

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == targetChar) {
                outputString += newChar;
            } else {
                outputString += inputString.charAt(i);
            }
        }
        System.out.println(outputString);
        return outputString;
    }

    /**
     * Splits a string into substrings based on a character passed to the function,
     * then returns a string array containing all the substrings, and prints the
     * contents of the array to the console.
     * If the character does not occur in the string, will return a string array of
     * size 1 that contains the original string.
     *
     * @param inputString The string to be split into substrings.
     * @param splitChar The character that divides the string into substrings.
     * @return A string array of all substrings the string was split into.
     */
    public static String[] splitString (String inputString, char splitChar) {
        String[] outputArray;
        int arrayLength = 1;
        int stringIterator = 0;

        // Detect the number of occurrences of the character within the string to determine the size of the output array.
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == splitChar) {
                arrayLength++;
            }
        }
        outputArray = new String[arrayLength];

        // Divide the string into substrings by transversing the string once more.
        for (int i = 0; i < arrayLength; i++) {
            outputArray[i] = "";
            while ((stringIterator < inputString.length()) && (inputString.charAt(stringIterator) != splitChar)) {
                outputArray[i] += inputString.charAt(stringIterator);
                stringIterator++;
            }
            stringIterator++;
        }

        // Display contents of the output array, then return the array.
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(outputArray[i]);
        }
        return outputArray;
    }

    /**
     * Main method to control program execution and output.
     */
    public static void main (String[] args) {
        replaceChar(defaultString, defaultTargetChar, defaultReplaceChar);
        System.out.println("========");
        splitString(defaultString, defaultSplitChar);
    }
}
