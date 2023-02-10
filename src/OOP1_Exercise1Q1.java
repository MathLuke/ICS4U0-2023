/**
 *
 */


public class OOP1_Exercise1Q1 {

    public OOP1_Exercise1Q1 () {}

    public static void main (String[] args) {
        Student adam = new Student("Adam");
        Student bobby = new Student("Bobby");
        Student charlie = new Student("Charlie");
        Student david = new Student("David");
        Student erika = new Student("Erika");

        adam.setMarks(100, 90);
        bobby.setMarks(85, 90);
        charlie.setMarks(70, 95);
        david.setMarks(0, 100);
        erika.setMarks(90, 90);

        adam.calcAverage();
        bobby.calcAverage();
        charlie.calcAverage();
        david.calcAverage();
        erika.calcAverage();

        System.out.println(adam.message());
        System.out.println(bobby.message());
        System.out.println(charlie.message());
        System.out.println(david.message());
        System.out.println(erika.message());


    }
}
