package OOP1_Exercise1;

/** <h1>OOP 1 Exercise 1 Question 2</h1>
 * Driver class to Question 2 of OOP 1 Exercise 1.
 * Creates an array of 5 OOP1_Exercise1.Student objects, copies the array
 * to an array of size 10, adds an additional OOP1_Exercise1.Student to
 * position 8 of the array, and outputs all the information
 * in the array to the console.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 9, 2023
 * @author Luke Mathieu
 */


public class OOP1_Exercise1Q2 {
    // Main method
    public static void main (String[] args) {
        Student[] students = new Student[5];
        Student[] moreStudents = new Student[10];
        double sumOfAverages = 0.0;
        int numStudents = 0;

        students[0] = new Student("Adam");
        students[1] = new Student("Bobby");
        students[2] = new Student("Carl");
        students[3] = new Student("David");
        students[4] = new Student("Erika");

        students[0].setMarks(99, 90);
        students[1].setMarks(85, 90);
        students[2].setMarks(70, 95);
        students[3].setMarks(0, 99);
        students[4].setMarks(90, 90);

        for (int i = 0 ; i < students.length ; i++) {
            moreStudents[i] = students[i];
        }

        moreStudents[8] = new Student("Becky");
        moreStudents[8].setMarks(90, 93);

        System.out.println("Student\t\tMark 1\tMark2\t\tAverage");
        for (int i = 0; i < moreStudents.length ; i++) {
            if (moreStudents[i] != null) {
                moreStudents[i].calcAverage();
                System.out.println(moreStudents[i].name + "\t\t\t" + moreStudents[i].mark1 + "\t\t\t" + moreStudents[i].mark2 + "\t\t\t" + moreStudents[i].average);
                sumOfAverages += moreStudents[i].average;
                numStudents++;
            }
        }
        System.out.println("The class average is: " + sumOfAverages / numStudents);
    }
}
