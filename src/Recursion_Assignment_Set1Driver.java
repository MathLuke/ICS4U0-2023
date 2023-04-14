public class Recursion_Assignment_Set1Driver {

    public static void main (String[] args) {
        Recursion_Assignment_Set1 set1 = new Recursion_Assignment_Set1();

        System.out.println("Result of calling sum(10): " + set1.sum(10));
        System.out.println("Result of calling sumR(10): " + set1.sumR(10));

        System.out.println("Result of calling timeTable(12, 3): " + set1.timeTable(12, 3));
        System.out.println("Result of calling timeTableR(12, 3): " + set1.timeTableR(12, 3));
    }
}
