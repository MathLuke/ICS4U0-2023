/**
 *
 *
 */


public class OOP1_Exercise1Q2 {

    public static void main (String[] args) {
        Student[] students = new Student[5];
        Student[] moreStudents = new Student[10];
        students[0] = new Student("Adam");
        students[1] = new Student("Bobby");
        students[2] = new Student("Charlie");
        students[3] = new Student("David");
        students[4] = new Student("Erika");

        students[0].setMarks(100, 90);
        students[1].setMarks(85, 90);
        students[2].setMarks(70, 95);
        students[3].setMarks(0, 100);
        students[4].setMarks(90, 90);

        for (int i = 0 ; i < students.length ; i++) {
            moreStudents[i] = students[i];
        }

        moreStudents[8] = new Student("Samantha");
        moreStudents[8].setMarks(90, 93);

        double sumOfAverages = 0.0;
        int numStudents = 0;

        for (int i = 0; i < moreStudents.length ; i++) {
            if (moreStudents[i] != null) {
                moreStudents[i].calcAverage();
                System.out.println(moreStudents[i].message());
                sumOfAverages += moreStudents[i].average;
                numStudents++;
            }
        }

        System.out.println("The class average is: " + sumOfAverages / numStudents);
    }
}
