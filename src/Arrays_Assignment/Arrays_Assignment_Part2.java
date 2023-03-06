package Arrays_Assignment;

/**
 * <h1>Arrays Assignment Part 2</h1>
 * Driver class for part 2 of the Arrays Assignment. Reads CPU data from a file and stores in a single 2D Object array,
 * which can be viewed by the user through the menu. Alternatively, the best CPU based on criteria can be output
 * if the user chooses a different menu option.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-05
 *
 * @author Luke Mathieu, Tom Philip
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays_Assignment_Part2 {
    Scanner fileInput;
    Scanner userInput = new Scanner(System.in);
    String menuChoice;
    Object[][] data;

    /**
     * Class constructor. Initializes two scanners to read the data file. One of the scanners
     * is used to determine the number of lines in the data file, which determines how many
     * CPUs are represented in the data file, and how large the parallel arrays should be to
     * accommodate all the data.
     */
    public Arrays_Assignment_Part2 () {
        Scanner countNumberOfLines;
        int numberOfLines = 0;
        try {
            fileInput = new Scanner(new File("Arrays_Assignment/data.csv"));
            countNumberOfLines = new Scanner(new File("Arrays_Assignment/data.csv"));
            countNumberOfLines.nextLine(); // Skip the first (heading) line of the CSV file
            while (countNumberOfLines.hasNextLine()) {
                countNumberOfLines.nextLine();
                numberOfLines++;
            }
            countNumberOfLines.close();

            fileInput.useDelimiter(",");
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found!");
            System.exit(-1);
        }
        data = new Object[6][numberOfLines];

    }

    /**
     * Reads all data from the CSV file, and stores it into a 2d array.
     * Contains error-traps to catch if the data file is formatted incorrectly or contains
     * invalid values.
     */
    public void readData () {
        int index = 0;
        fileInput.nextLine(); // Skip heading line of the CSV file.
        while (fileInput.hasNextLine()) {

            try {
                String[] vals = fileInput.nextLine().split(",");
                data[0][index] = vals[0];
                data[1][index] = Integer.parseInt(vals[1]);
                data[2][index] = Double.parseDouble(vals[2]);
                data[3][index] = Double.parseDouble(vals[3]);
                data[4][index] = Integer.parseInt(vals[4]);
                data[5][index] = Double.parseDouble(vals[5]);
                if ((int)data[1][index] <= 0 || (double)data[2][index] <= 0.0 || (double)data[3][index] < 1.0 || (int)data[4][index] < 0 || (double)data[5][index] < 0.0) {
                    throw new IllegalArgumentException();
                }
                index++;
            } catch (InputMismatchException e) {
                System.err.println("Data file is formatted improperly. Please check the data file.");
                System.exit(1);
            } catch (IllegalArgumentException e) {
                System.err.println("Data file contains one or more illegal values. Please check the data file.");
                System.exit(1);
            }

        }
    }

    /**
     * Pause the program until the user enters a key, then add extra spacing to separate different "screens" of the program.
     */
    private void pauseProgram () {
        System.out.println("Enter any key to continue...");
        userInput.nextLine();
        System.out.print("\n\n\n\n\n");
    }

    /**
     * Prints the program title, followed by 2 newlines
     */
    private void title () {
        System.out.printf("%65s", "Arrays Assignment Part 2\n\n");
    }

    /**
     * Main menu for the program. Displays program options and takes user input for the menu choice.
     */
    public void mainMenu () {
        title();
        System.out.println("[1]\tProgram premise and formula used");
        System.out.println("[2]\tDisplay all CPU data in a table");
        System.out.println("[3]\tFind the best CPU based on the formula");
        System.out.println("[4]\tExit program");

        System.out.println("\nEnter 1, 2, 3, or 4");

        do {
            menuChoice = userInput.nextLine().strip();
            if (menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3") || menuChoice.equals("4")) {
                break;
            } else {
                System.out.println("You must enter either 1, 2, 3, or 4!");
            }
        } while (true);
        System.out.print("\n\n\n\n\n");
    }

    /**
     * Prints out a brief explanation for the program, including the formula used to calculate the CPU with the best value.
     */
    public void introduction () {
        title();
        System.out.println("This program stores data about computer CPU's (Central Processing Units) using a 2D array.\nThe program is also capable of determining the CPU with the best data[3] to performance value, which is calculated by the expression:\n\nCPU Value = Number of CPU Cores * CPU Clock Speed / Math.sqrt(CPU Price)\n\n");
        pauseProgram();
    }

    /**
     * Displays all the data in the 2D arrays in a table format.
     */
    public void displayTable ()
    {
        title();
        System.out.println("CPU Name                      # of Cores     Clock Speed (GHz)     Price ($)     Release Year     Cache Size (MB)");
        for (int i = 0; i < data[0].length; i++) {
            System.out.printf("%-30.25s%10d%22.1f%14.2f%17d%20.3f\n", data[0][i], (int)data[1][i], (double)data[2][i], (double)data[3][i], (int)data[4][i], (double)data[5][i]);
        }
        System.out.println("\n\n");
        pauseProgram();
    }

    /**
     * Calculates then displays the best CPU based on the formula.
     */
    public void displayBest () {
        double maxScore = 0.0;
        String bestCPU = "";
        for (int i = 0; i < data[0].length; i++) {
            double current = (int)data[1][i] * (double)data[2][i] / Math.sqrt((double)data[3][i]);
            if (current > maxScore) {
                maxScore = current;
                bestCPU = (String)data[0][i];
            }
        }

        title();
        System.out.println("The CPU with the greatest price-to-performance ratio of the sample data according to the formula used is the " + bestCPU + ", with a score of " + maxScore + "\n\n");
        pauseProgram();
    }

    /**
     * Displays a goodbye message for the user.
     */
    public void goodbye () {
        title();
        System.out.println("Exiting Arrays Assignment Part 2 by Luke M. and Tom P.\n\n");
        pauseProgram();
    }

    // main method 
    public static void main(String[] args) {
        Arrays_Assignment_Part2 arraysAssignment = new Arrays_Assignment_Part2();
        arraysAssignment.readData();
        do {
            arraysAssignment.mainMenu();
            if (arraysAssignment.menuChoice.equals("1")) {
                arraysAssignment.introduction();
            } else if (arraysAssignment.menuChoice.equals("2")) {
                arraysAssignment.displayTable();
            } else if (arraysAssignment.menuChoice.equals("3")) {
                arraysAssignment.displayBest();
            }
        } while (!arraysAssignment.menuChoice.equals("4"));
        arraysAssignment.goodbye();
    }
}