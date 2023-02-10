package OOP1_Exercise1;

/** <h1>OOP1_Exercise1.Car</h1>
 * Class to represent a car with a brand model, mileage, gas level, and tank capacity.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 9, 2023
 * @author Luke Mathieu
 */

public class Car{
    private String brand;
    private String model;
    private int kilometres;
    private double gas;
    private double tankCapacity;

    // Class constructor
    public Car(String b, String m, double g, double tCap){
        brand = b;
        model = m;
        kilometres = 0;
        gas = g;
        tankCapacity = tCap;
    }

    /**
     * Causes the car to drive a certain distance, affecting the mileage and the gas level.
     *
     * @param distance The distance to be travelled.
     */
    public void drive(double distance){
        kilometres += distance;
        gas -= distance / 5;
    }

    /**
     * Refills the car's gas tank with gas, increasing its gas level to its maximum capacity.
     */
    public void gasUp(){
        gas = tankCapacity;
    }

    /**
     * Returns a String containing the cars brand, model, and mileage in a simple message.
     *
     * @return The message containing the brand, model, and mileage.
     */
    public String message() {
        return "The " + brand + " " + model + " has driven " + kilometres + " kilometres.";
    }
} // OOP1_Exercise1.Car class