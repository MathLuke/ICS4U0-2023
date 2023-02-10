package OOP1_Exercise1;

/** <h1>OOP 1 Exercise 1 Question 1</h1>
 * Driver class to Question 2 of OOP 1 Exercise 1.
 * Creates 5 objects from each of the OOP1_Exercise1.Student, OOP1_Exercise1.Car, OOP1_Exercise1.House, and OOP1_Exercise1.Animal classes,
 * then runs all the instance methods in each class.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 9, 2023
 * @author Luke Mathieu
 */


public class OOP1_Exercise1Q1 {
    // Main method
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

        Car car1 = new Car("Toyota", "Corolla", 0.0, 50.0);
        Car car2 = new Car("Honda", "Civic", 10.0, 46.0);
        Car car3 = new Car("Ford", "F150", 40.0, 130.0);
        Car car4 = new Car("Hyundai", "Elantra", 5.5, 45.0);
        Car car5 = new Car("Kia","Seltos", 23.7, 50.0);

        car1.gasUp();
        car2.gasUp();
        car3.gasUp();
        car4.gasUp();
        car5.gasUp();

        car1.drive(230);
        car2.drive(100);
        car3.drive(500);
        car4.drive(77);
        car5.drive(47);

        System.out.println(car1.message());
        System.out.println(car2.message());
        System.out.println(car3.message());
        System.out.println(car4.message());
        System.out.println(car5.message());

        House house1 = new House(1314, "Front St.", "Ottawa", "Ontario", "M3P 9S0", 6500.0, false, 2);
        House house2 = new House(20, "Tillplain Rd.", "Toronto", "Ontario", "M3H 5RU", 30000.0, true, 2);
        House house3 = new House(7, "Sunset Rd.", "Edmonton", "Alberta", "C3V 7H7", 3200.5, true, 1);
        House house4 = new House(43, "Fern Ave.", "Toronto", "Ontario", "M1D 2E4", 7832.2, true,3);
        House house5 = new House(1000, "Main St.", "Vancouver", "British Columbia", "C3V H7A", 1000.0, false, 1);

        house1.displayAddress();
        house2.displayAddress();
        house3.displayAddress();
        house4.displayAddress();
        house5.displayAddress();

        Animal animal1 = new Animal("Lion", 180);
        Animal animal2 = new Animal("Python", 75);
        Animal animal3 = new Animal("Giraffe", 2000);
        Animal animal4 = new Animal("Rabbit", 4);
        Animal animal5 = new Animal("Vulture", 2);

        animal1.feed("meat");
        animal2.feed("meat");
        animal3.feed("leaves");
        animal4.feed("vegetables");
        animal5.feed("vegetables");

        System.out.println(animal1.message());
        System.out.println(animal2.message());
        System.out.println(animal3.message());
        System.out.println(animal4.message());
        System.out.println(animal5.message());
    }
}
