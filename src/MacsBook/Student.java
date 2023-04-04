package MacsBook;

/**
 * <h1>Student</h1>
 *
 * Class to represent a Student, with a name, student number, assignment, test, and final project mark, and overall average.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-31
 *
 * @author Daphne Tu, Luke Mathieu, and Henry Zhang
 */

public class Student {
    private String name;
    private long studentNumber;
    private double assignmentMark;
    private double testMark;
    private double finalProjectMark;
    private double average;

    public Student() {
        name = "";
        studentNumber = 0;
        assignmentMark = 0.0;
        testMark = 0.0;
        finalProjectMark = 0.0;
        average = calcAverage();
    }

    public Student(String name, long studentNumber, double assignmentMark, double testMark, double finalProjectMark) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.assignmentMark = assignmentMark;
        this.testMark = testMark;
        this.finalProjectMark = finalProjectMark;
        this.average = calcAverage();
    }

    private double calcAverage () {
        return (assignmentMark + testMark + finalProjectMark) / 3.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getAssignmentMark() {
        return assignmentMark;
    }

    public void setAssignmentMark(double assignmentMark) {
        this.assignmentMark = assignmentMark;
        average = calcAverage();
    }

    public double getTestMark() {
        return testMark;
    }

    public void setTestMark(double testMark) {
        this.testMark = testMark;
        average = calcAverage();
    }

    public double getFinalProjectMark() {
        return finalProjectMark;
    }

    public void setFinalProjectMark(double finalProjectMark) {
        this.finalProjectMark = finalProjectMark;
        average = calcAverage();
    }

    public double getAverage() {
        return average;
    }

    public String toString() {
        return String.format("%30s%20d%17.2f%11.2f%20.2f%10.2f\n", name, studentNumber, assignmentMark, testMark, finalProjectMark, average);
    }
}
