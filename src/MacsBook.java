import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MacsBook {
    private List<String> studentNames;
    private List<Long> studentNumbers;
    private List<Double> assignmentMarks;
    private List<Double> testMarks;
    private List<Double> finalProjectMarks;
    private List<Double> studentAverages;
    private BufferedReader input;

    public MacsBook() throws IOException {
        this.studentAverages = new ArrayList<>();
        this.studentNames = new ArrayList<>();
        this.studentNumbers = new ArrayList<>();
        this.testMarks = new ArrayList<>();
        this.assignmentMarks = new ArrayList<>();
        this.finalProjectMarks = new ArrayList<>();
            Scanner scanner = new Scanner("macsbookdata.csv");
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

    public boolean menu() throws IOException {
        System.out.println("MacsBook Menu:\n");
        System.out.println("a) Create data");
        System.out.println("b) View class data");
        System.out.println("c) View student data");
        System.out.println("d) Exit\n");
        boolean ret = false;
        while(true){
            System.out.println("Please input a character from a-d: ");
            String in = input.readLine().strip().toLowerCase();
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

    private void displayStudent(int index){
        System.out.printf("%30s%20d%10.4f%10.4f%10.4f%10.4f\n", studentNames.get(index), studentNumbers.get(index), assignmentMarks.get(index), testMarks.get(index), finalProjectMarks.get(index), studentAverages.get(index));
    }

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
                    if (((Double.parseDouble(line) >= 0.0 && Double.parseDouble(line) <= 100.0))) {
                        assignmentMarks.add(Double.parseDouble(line));
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Assignment mark should be a decimal between 0.0 and 100.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Assignment mark should be a decimal between 0.0 and 100.0.");
                }
            }
        } catch (IOException ignored) {
        }
    }

    private void displayClass(){
        System.out.println("Displaying class data:");
        for(int i = 0; i<studentNumbers.size(); i++){
            displayStudent(i);
        }
    }

    private void displayStudent(){
    }

    private void exit(){
        try {
            PrintWriter clearData = new PrintWriter(new FileWriter("macsbookdata.csv"));
            PrintWriter writer = new PrintWriter(new FileWriter("macsbookdata.csv"));
            clearData.print("");
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