package OOP1_Exercise1;

/** <h1>OOP1_Exercise1.Student</h1>
 * Class to represent a student with a name, marks, and an average mark.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 9, 2023
 * @author Luke Mathieu
 */

public class Student{
    public String name;
    public int mark1;
    public int mark2;
    public double average;

    // Class constructor
    public Student(String n){
        name = n;
        mark1 = 0;
        mark2 = 0;
        average = 0.0;
    }

    /**
     * Sets both of the student's marks.
     *
     * @param x The mark 1 to be set.
     * @param y The mark 2 to be set.
     */
    public void setMarks(int x, int y){
        mark1 = x;
        mark2 = y;
    }

    /**
     * Calculates the student's average based on mark1 and mark2.
     */
    public void calcAverage(){
        average=(mark1 + mark2)/2;
    }

    /**
     * Returns a String containing the student's name and average in a simple message.
     *
     * @return The message containing the name and average.
     */
    public String message( ){
        return name + ", You got an " + average;
    }
} // OOP1_Exercise1.Student class
