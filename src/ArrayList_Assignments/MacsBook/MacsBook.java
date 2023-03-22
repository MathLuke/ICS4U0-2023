package ArrayList_Assignments.MacsBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * <h1>MacsBook Assignment</h1>
 * <p>
 *     This program manages student marks by reading student mark data from a
 *     CSV file, and providing the user with the choice to either add additional
 *     students to the class, view all student data from the class, or to view a
 *     specific student's data, by searching either for a student name or student number.
 *     Finally, the program stores all the data back into the CSV file when the user
 *     exits the program.
 * </p>
 * <p>
 *     Tom Philip was responsible for reading data from the CSV file, the main menu method, and the display methods.
 *     Luke Mathieu was responsible for adding additional student data from the user into the program, and having the data
 *     written back into the CSV file when the program terminates.
 * </p>
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-21
 *
 * @author Luke Mathieu and Tom Philip
 */

public class MacsBook {
    private List<String> studentNames;
    private List<Long> studentNumbers;
    private List<Double> assignmentMarks;
    private List<Double> testMarks;
    private List<Double> finalProjectMarks;
    private List<Double> studentAverages;
    private final BufferedReader input;

    /**
     * Class constructor. Initializes parallel ArrayLists with data from macsbookdata.csv file.
     * @throws IOException If there is an error with File I/O (such as if the input file is missing).
     */
    public MacsBook() throws IOException {
        this.studentAverages = new ArrayList<>();
        this.studentNames = new ArrayList<>();
        this.studentNumbers = new ArrayList<>();
        this.testMarks = new ArrayList<>();
        this.assignmentMarks = new ArrayList<>();
        this.finalProjectMarks = new ArrayList<>();
        Scanner scanner = new Scanner(new File("macsbookdata.csv"));
        scanner.nextLine(); //read csv header
        String line;
        try {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] values = line.split(",");
                studentNames.add(values[0]);
                studentNumbers.add(Long.parseLong(values[1]));
                assignmentMarks.add(Double.parseDouble(values[2]));
                testMarks.add(Double.parseDouble(values[3]));
                finalProjectMarks.add(Double.parseDouble(values[4]));
                studentAverages.add(Double.parseDouble(values[5]));
            }
        } catch(NumberFormatException e){
            System.err.println("Data folder is corrupted, voiding all data.");
            this.studentAverages = new ArrayList<>();
            this.studentNames = new ArrayList<>();
            this.studentNumbers = new ArrayList<>();
            this.testMarks = new ArrayList<>();
            this.assignmentMarks = new ArrayList<>();
            this.finalProjectMarks = new ArrayList<>();
        }
        this.input = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Controls general program flow through a main menu. Takes a character from System.in as input, and
     * Calls the corresponding method based on the menu option chosen by the user.
     * @return A boolean state to indicate whether the program should continue to run or exit.
     * @throws IOException If Scanner.readLine() throws an exception.
     */
    public boolean menu() throws IOException {
        System.out.println("MacsBook Menu:\n");
        System.out.println("a) Create data");
        System.out.println("b) View class data");
        System.out.println("c) View student data");
        System.out.println("d) Save and Exit\n");
        boolean ret = false;
        while(true){
            System.out.println("Please input a character from a-d: ");
            String in = input.readLine().strip().toLowerCase(Locale.ROOT);
            if(in.isEmpty()){
                System.out.println("Invalid input, please try again.\n");
                continue;
            }
            switch (in.charAt(0)) {
                case 'a' -> createData();
                case 'b' -> displayClass();
                case 'c' -> displayStudent();
                case 'd' -> {
                    exit();
                    ret = true;
                }
                default -> {
                    System.out.println("Invalid input, please try again.\n");
                    continue;
                }
            }
            break;
        }
        return ret;
    }

    /**
     * Displays a single student's data from the parallel arrayLists to the console.
     * @param index The index of the student in the parallel arrayLists to be displayed.
     */
    private void displayStudent(int index){
        System.out.printf("%30s%20d%17.2f%11.2f%20.2f%10.2f\n", studentNames.get(index), studentNumbers.get(index), assignmentMarks.get(index), testMarks.get(index), finalProjectMarks.get(index), studentAverages.get(index));
    }

    /**
     * Allows the user to enter another student's data into the parallel ArrayLists.
     * Asks for the student's name, student number, assignment, test, and final project marks,
     * and uses these marks to determine the student's average. Uses errortraps to prevent invalid
     * values from being entered into the program.
     */
    private void createData() {
        String line;
        try {
            while (true) {
                System.out.print("Enter the student's name: ");
                line = input.readLine();
                if (line.length() > 0) {
                    System.out.println();
                    studentNames.add(line);
                    break;
                } else {
                    System.out.println("Student must have a name!");
                }
            }
            while (true) {
                System.out.print("Enter the student number: ");
                line = input.readLine();
                try {
                    studentNumbers.add(Long.parseLong(line));
                    System.out.println();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Student number must be an integer number.");
                }
            }
            while (true) {
                System.out.print("Enter the assignment mark as a percentage (excluding the percent (%) symbol): ");
                line = input.readLine();
                try {
                    double mark = Double.parseDouble(line);
                    if (mark >= 0.0 && mark <= 100.0) {
                        assignmentMarks.add(mark);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Assignment mark should be a decimal between 0.0 and 100.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Assignment mark should be a decimal between 0.0 and 100.0.");
                }
            }
            while (true) {
                System.out.print("Enter the test mark as a percentage (excluding the percent (%) symbol): ");
                line = input.readLine();
                try {
                    double mark = Double.parseDouble(line);
                    if (mark >= 0.0 && mark <= 100.0) {
                        testMarks.add(mark);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Test mark should be a decimal between 0.0 and 100.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Test mark should be a decimal between 0.0 and 100.0.");
                }
            }
            while (true) {
                System.out.print("Enter the final project mark as a percentage (excluding the percent (%) symbol): ");
                line = input.readLine();
                try {
                    double mark = Double.parseDouble(line);
                    if (mark >= 0.0 && mark <= 100.0) {
                        finalProjectMarks.add(mark);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Final project mark should be a decimal between 0.0 and 100.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Final project mark should be a decimal between 0.0 and 100.0.");
                }
            }
            int index = studentNames.size()-1;
            studentAverages.add((assignmentMarks.get(index)+testMarks.get(index)+finalProjectMarks.get(index))/3);
        } catch (IOException ignored) {
        }
    }

    /**
     * Displays all the contents of the parallel ArrayLists to the console, as well as the class average of all
     * student averages.
     */
    private void displayClass(){
        if(studentNumbers.isEmpty()){
            System.out.println("The class is empty, please create student data to display the whole class.");
            return;
        }
        System.out.println("Displaying class data:");
        System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "Final Project mark", "Average");
        for(int i = 0; i<studentNumbers.size(); i++){
            displayStudent(i);
        }
        double average = 0;
        for(double mark : studentAverages){
            average+=mark;
        }
        average/=studentAverages.size();
        System.out.printf("\nClass average: %4.2f\n", average);
    }

    /**
     * Asks the user to enter a student name or student number, then displays all the information
     * belonging to the matching student.
     * @throws IOException If BufferedReader.readLine() throws an exception.
     */
    private void displayStudent() throws IOException {
        boolean validInput = false;
        while(!validInput){
            System.out.println("Would you like to find a student by name or by number?");
            String line = this.input.readLine().strip().toLowerCase(Locale.ROOT);
            switch(line){
                case "name" -> {
                    System.out.println("Please input the name of the student: ");
                    String name = input.readLine();
                    if(studentNames.contains(name)){
                        System.out.printf("Displaying data for %s\n", name);
                        System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "final project mark", "Average");
                        displayStudent(studentNames.indexOf(name));
                    } else {
                        System.out.println("Student not found, returning to menu.");
                    }
                    validInput = true;
                }
                case "number" -> {
                    System.out.println("Please input the student number: ");
                    try {
                        long number = Long.parseLong(input.readLine().strip());
                        if(studentNumbers.contains(number)){
                            int index = studentNumbers.indexOf(number);
                            System.out.printf("Displaying data for %s\n", studentNames.get(index));
                            System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "final project mark", "Average");
                            displayStudent(index);
                        } else {
                            System.out.println("Student not found, returning to menu.");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid number, returning to menu.");
                    }

                    validInput = true;
                }
                default -> System.out.println("Invalid input, please input either \"name\" or \"number\".");
            }
        }
    }

    /**
     * Saves all data in the parallel ArrayLists to the macsbookdata.csv file, then exits the program
     */
    private void exit(){
        try {
            PrintWriter clearData = new PrintWriter(new FileWriter("macsbookdata.csv"));
            PrintWriter writer = new PrintWriter(new FileWriter("macsbookdata.csv"));
            clearData.print(""); //clears all data from the macsbookdata.csv file
            clearData.close();

            writer.println("Student Name,Student Number,Assignment Mark,Test Mark,Final Project Mark,Student Average");
            for (int i = 0; i < studentNumbers.size(); i++) {
                writer.print(studentNames.get(i) + ",");
                writer.print(studentNumbers.get(i) + ",");
                writer.print(assignmentMarks.get(i) + ",");
                writer.print(testMarks.get(i) + ",");
                writer.print(finalProjectMarks.get(i) + ",");
                writer.println(studentAverages.get(i));
            }
            writer.close();
        } catch (IOException ignored) {

        }
    }
}