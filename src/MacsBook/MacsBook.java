package MacsBook;

import java.io.*;
import java.util.*;

/**
 * <h1>Sorting Assignment</h1>
 * <p>
 *     This program manages student marks by reading student mark data from a
 *     CSV file, and providing the user with the choice to either add additional
 *     students to the class, view all student data from the class, or to view a
 *     specific student's data, by searching either for a student name or student number.
 *     The user may also choose to sort saved data by student name or by student average.
 *     Finally, the program stores all the data back into the CSV file when the user
 *     exits the program.
 * </p>
 * <p>
 *     Daphne Tu was responsible for sorting the students based on their average,
 *     Luke Mathieu was responsible for sorting the students based on their names,
 *     and Henry Zhang created the method to allow for student data to be changed.
 *     All members contributed in updating the original MacsBook assignment so it
 *     could be used for this assignment.
 * </p>
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-31
 *
 * @author Daphne Tu, Luke Mathieu, and Henry Zhang
 */

public class MacsBook {
    public ArrayList<Student> students;
    private final BufferedReader input;

    /**
     * Class constructor. Initializes students ArrayList with data from macsbookdata.csv file.
     * @throws IOException If there is an error with File I/O (such as if the input file is missing).
     */
    public MacsBook() throws IOException {
        this.students = new ArrayList<>();
        Scanner scanner = new Scanner(new File("macsbookdata.csv"));
        scanner.nextLine(); //read csv header
        String line;
        try {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] values = line.split(",");
                students.add(new Student());
                students.get(students.size()-1).setName(values[0]);
                students.get(students.size()-1).setStudentNumber(Long.parseLong(values[1]));
                students.get(students.size()-1).setAssignmentMark(Double.parseDouble(values[2]));
                students.get(students.size()-1).setTestMark(Double.parseDouble(values[3]));
                students.get(students.size()-1).setFinalProjectMark(Double.parseDouble(values[4]));
            }
        } catch(NumberFormatException e){
            System.err.println("Data folder is corrupted, voiding all data.");

            this.students = new ArrayList<>();
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
        System.out.println("d) Sort students by name");
        System.out.println("e) Sort students by average");
        System.out.println("f) Edit student data");
        System.out.println("g) Save and Exit\n");
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
                    students = sortByName(students);
                    System.out.println("Students are now sorted alphabetically by name.\nSelect \"Display Class Data\" to view all student data.\n");
                }
                case 'e' -> {
                    students = sortByAvg(students);
                    System.out.println("Students are now sorted numerically by average (greatest to least).\nSelect \"Display Class Data\" to view all student data.\n");
                }
                case 'f' -> editData();
                case 'g' -> {
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
     * Allows the user to enter another student's data into the students ArrayList.
     * Asks for the student's name, student number, assignment, test, and final project marks,
     * and uses these marks to determine the student's average. Uses errortraps to prevent invalid
     * values from being entered into the program.
     */
    private void createData() {
        students.add(new Student());
        String line;
        try {
            while (true) {
                System.out.print("Enter the student's name: ");
                line = input.readLine();
                if (line.length() > 0) {
                    System.out.println();
                    students.get(students.size()-1).setName(line);
                    break;
                } else {
                    System.out.println("Student must have a name!");
                }
            }
            while (true) {
                System.out.print("Enter the student number: ");
                line = input.readLine();
                try {
                    students.get(students.size()-1).setStudentNumber(Long.parseLong(line));
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
                        students.get(students.size()-1).setAssignmentMark(mark);
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
                        students.get(students.size()-1).setTestMark(mark);
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
                        students.get(students.size()-1).setFinalProjectMark(mark);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Final project mark should be a decimal between 0.0 and 100.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Final project mark should be a decimal between 0.0 and 100.0.");
                }
            }
        } catch (IOException ignored) {
        }
    }

    /**
     * Displays all the contents of the students ArrayList to the console, as well as the class average of all
     * student averages.
     */
    private void displayClass(){
        if(students.isEmpty()){
            System.out.println("The class is empty, please create student data to display the whole class.");
            return;
        }
        System.out.println("Displaying class data:");
        System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "Final Project mark", "Average");
        for(Student student : students){
            System.out.printf(student.toString());
        }
        double average = 0;
        for(Student s : students){
            average+=s.getAverage();
        }
        average/=students.size();
        System.out.printf("\nClass average: %4.2f\n", average);
    }

    /**
     * Asks the user to enter a student name or student number, then displays all the information
     * belonging to the matching student.
     * @throws IOException If BufferedReader.readLine() throws an exception.
     */
    private void displayStudent() throws IOException {
        while(true){
            System.out.println("Would you like to find a student by name or by number?");
            String line = this.input.readLine().strip().toLowerCase(Locale.ROOT);
            switch(line){
                case "name" -> {
                    System.out.println("Please input the name of the student: ");
                    String name = input.readLine();
                    for (Student student : students) {
                        if (student.getName().equals(name)) {
                            System.out.printf("Displaying data for %s\n", name);
                            System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "final project mark", "Average");
                            System.out.printf(student.toString());
                            return;
                        }
                    }
                    System.out.println("Student not found, try again!");
                }
                case "number" -> {
                    System.out.println("Please input the student number: ");
                    try {
                        long number = Long.parseLong(input.readLine().strip());
                        for (Student student : students) {
                            if (student.getStudentNumber() == number) {
                                System.out.printf("Displaying data for %s\n", student.getName());
                                System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "final project mark", "Average");
                                System.out.printf(student.toString());
                                return;
                            }
                        }
                        System.out.println("Student not found, try again!");
                    } catch (NumberFormatException e){
                        System.out.println("Invalid number, try again!");
                    }
                }
                default -> System.out.println("Invalid input, please input either \"name\" or \"number\".");
            }
        }
    }

    /**
     * Saves all data in the students ArrayList to the macsbookdata.csv file, then exits the program
     */
    private void exit(){
        try {
            PrintWriter clearData = new PrintWriter(new FileWriter("macsbookdata.csv"));
            PrintWriter writer = new PrintWriter(new FileWriter("macsbookdata.csv"));
            clearData.print(""); //clears all data from the macsbookdata.csv file
            clearData.close();

            writer.println("Student Name,Student Number,Assignment Mark,Test Mark,Final Project Mark,Student Average");
            for (Student student : students) {
                writer.print(student.getName() + ",");
                writer.print(student.getStudentNumber() + ",");
                writer.print(student.getAssignmentMark() + ",");
                writer.print(student.getTestMark() + ",");
                writer.print(student.getFinalProjectMark() + ",");
                writer.println(student.getAverage());
            }
            writer.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * Sorts and returns a copy of a Student Arraylist lexicographically from least to greatest using the selection sort algorithm.
     * Selection sort implementation based off an implementation from <a href="https://www.geeksforgeeks.org/selection-sort/">GeeksForGeeks</a>
     * @param arr The ArrayList to be sorted.
     * @return A copy of the Student ArrayList ordered lexicographically from least to greatest.
     */
    private ArrayList<Student> sortByName(ArrayList<Student> arr){
        ArrayList<Student> copy = new ArrayList<>(arr);

        for (int i = 0; i < copy.size() - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < copy.size(); j++) {
                if (copy.get(j).getName().compareTo(copy.get(minimumIndex).getName()) < 0) {
                    minimumIndex = j;
                }
            }

            Student temp = copy.get(minimumIndex);
            copy.set(minimumIndex, copy.get(i));
            copy.set(i, temp);
        }

        return copy;
    }

    /**
     * Sorts and returns a copy of a Student ArrayList numerically from greatest to least using the selection sort algorithm.
     * Selection sort implementation based off an implementation from <a href="https://www.geeksforgeeks.org/selection-sort/">GeeksForGeeks</a>
     * @param arr The ArrayList to be sorted.
     * @return A copy of the Student array ordered numerically from greatest to least.
     */
    private ArrayList<Student> sortByAvg(ArrayList<Student> arr){
        ArrayList<Student> copy = new ArrayList<>(arr);

        for (int i = 0; i < copy.size() - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < copy.size(); j++) {
                if (copy.get(j).getAverage() < copy.get(minimumIndex).getAverage()) {
                    minimumIndex = j;
                }
            }

            Student temp = copy.get(minimumIndex);
            copy.set(minimumIndex, copy.get(i));
            copy.set(i, temp);
        }

        Collections.reverse(copy);
        return copy;
    }

    /**
     * Allows data stored within the students ArrayList to be changed by the user.
     * @throws IOException If BufferedReader.readLine() throws an exception.
     */
    public void editData() throws IOException {
        if(students.isEmpty()){
            System.out.println("The class is empty, please create student data to edit student data.");
            return;
        }

        System.out.println("Choose a student to edit: ");
        System.out.printf("%30s%20s%17s%11s%20s%10s\n", "Student name", "Student number", "Assignments mark", "Test mark", "Final Project mark", "Average");
        for(int i = 0; i<students.size(); i++){
            System.out.printf("%5s%25s%20d%17.2f%11.2f%20.2f%10.2f\n", i+1 +" -", students.get(i).getName(), students.get(i).getStudentNumber(), students.get(i).getAssignmentMark(), students.get(i).getTestMark(), students.get(i).getFinalProjectMark(), students.get(i).getAverage());
        }
        int index;
        while (true) {
            try{
                System.out.println("Enter the number on the left of the screen corresponding to the student whose data you wish to edit.");
                index = Integer.parseInt(this.input.readLine())-1;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer from 1 to " + students.size());
            }
        }
        System.out.println("Enter what part of " + students.get(index).getName() +"'s data you would like to modify: ");
        System.out.println("1 - name");
        System.out.println("2 - student number");
        System.out.println("3 - assignment mark");
        System.out.println("4 - test mark");
        System.out.println("5 - final project mark");
        System.out.println("6 - return to main menu");
        int modify;
        while (true) {
            try {
                modify = Integer.parseInt(this.input.readLine());
                if (modify > 6 || modify < 1) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 6.");
            }
        }
        String name;
        long num;
        double mark;
        while(modify!=6){
            if(modify==1){
                System.out.println("You have chose to modify "+students.get(index).getName()+"'s name. ");
                System.out.println("Please enter this student's new name. ");
                name=this.input.readLine().strip();
                if (!name.isEmpty()) {
                    students.get(index).setName(name);
                    System.out.println("The chosen student's new name is "+students.get(index).getName()+". ");
                } else {
                    System.out.println("Invalid input! Please try again.");
                }
            }
            if(modify==2){
                System.out.println("You have chose to modify "+students.get(index).getName()+"'s student number. ");
                System.out.println("Please enter "+students.get(index).getName()+"'s new student number. ");
                try {
                    num=Long.parseLong(this.input.readLine().strip());
                    if (num < 0) throw new NumberFormatException();
                    students.get(index).setStudentNumber(num);
                    System.out.println(students.get(index).getName()+"'s new student number is "+students.get(index).getStudentNumber()+". ");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please try again.");
                }
            }
            if(modify==3){
                System.out.println("You have chose to modify "+students.get(index).getName()+"'s assignment mark. ");
                System.out.println("Please enter "+students.get(index).getName()+"'s new assignment mark. ");
                try {
                    mark = Double.parseDouble(this.input.readLine().strip());
                    if (mark > 100.0 || mark <0.0) throw new NumberFormatException();
                    students.get(index).setAssignmentMark(mark);
                    System.out.println(students.get(index).getName() + "'s new assignment mark is " + students.get(index).getAssignmentMark() + ". ");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please try again.");
                }
            } if(modify==4){
                System.out.println("You have chose to modify "+students.get(index).getName()+"'s test mark. ");
                System.out.println("Please enter "+students.get(index).getName()+"'s new test mark. ");
                try {
                    mark = Double.parseDouble(this.input.readLine().strip());
                    if (mark > 100.0 || mark <0.0) throw new NumberFormatException();
                    students.get(index).setTestMark(mark);
                    System.out.println(students.get(index).getName()+"'s new test mark is "+students.get(index).getTestMark()+". ");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please try again.");
                }

            } if(modify==5){
                System.out.println("You have chose to modify "+students.get(index).getName()+"'s final project mark. ");
                System.out.println("Please enter "+students.get(index).getName()+"'s new final project mark. ");
                try {
                    mark = Double.parseDouble(this.input.readLine().strip());
                    if (mark > 100.0 || mark <0.0) throw new NumberFormatException();
                    students.get(index).setFinalProjectMark(mark);
                    System.out.println(students.get(index).getName()+"'s new final project mark is "+students.get(index).getFinalProjectMark()+". ");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please try again.");
                }
            }
            System.out.println("\nEnter what part of " + students.get(index).getName() +"'s data you would like to modify: ");
            System.out.println("1 - name");
            System.out.println("2 - student number");
            System.out.println("3 - assignment mark");
            System.out.println("4 - test mark");
            System.out.println("5 - final project mark");
            System.out.println("6 - return to main menu");
            while (true) {
                try {
                    modify = Integer.parseInt(this.input.readLine());
                    if (modify > 6 || modify < 1) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number from 1 to 6.");
                }
            }
        }
        System.out.println();
    }
}