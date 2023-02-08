/**
 * <t>String Review Assignment</t>
 *
 * @author Luke Mathieu
 * Ms. Krasteva
 */

public class StringReview {
    static String defaultString = "This is the default String.";
    static char defaultSplitChar = ' ';

    public static void replaceChar (String inputString, char findChar, char replaceChar) {
        String outputString = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == findChar) {
                outputString += replaceChar;
            } else {
                outputString += inputString.charAt(i);
            }
        }
        System.out.println(outputString);
    }

    public static void splitString (String inputString, char splitChar) {
        String[] outputArray;
        int arrayLength = 1;
        int stringIterator = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == splitChar) {
                arrayLength++;
            }
        }
        outputArray = new String[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            outputArray[i] = "";
            while (inputString.charAt(stringIterator) != splitChar) {
                outputArray[i] += inputString.charAt(stringIterator);
                stringIterator++;
            }
        }


        for (int i = 0; i < arrayLength; i++) {
            System.out.println(outputArray[i]);
        }
    }

    public static void main (String[] args) {
        replaceChar(defaultString, ' ', '_');
        System.out.println("========");
        splitString(defaultString, defaultSplitChar);
    }
}
