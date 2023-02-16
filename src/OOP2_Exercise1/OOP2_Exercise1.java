package OOP2_Exercise1;

/** <h1>OOP2 Exercise 1</h1>
 * Driver class to OOP 2 Exercise 1. Creates an Airplane object and tests all
 * of the methods and attributes of the Airplane object.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 16, 2023
 * @author Luke Mathieu
 */

public class OOP2_Exercise1 {

    // main method
    public static void main (String[] args) {
        Airplane airplane = new Airplane();

        System.out.println("Initial airplane status:");
        System.out.println("Gas level: " + airplane.getGasLevel());
        System.out.println("Door status: " + airplane.getDoorStatus());
        System.out.println("Landing gear status: " + airplane.getLandingGear());
        System.out.println("Number of passengers onboard: " + airplane.getPassengers() + "\n");

        airplane.loadPass(51);
        System.out.println("Loaded 51 passengers onto airplane. Number of passengers onboard: " + airplane.getPassengers() + "\n");

        airplane.closeDoor();
        System.out.println("Closed airplane door. Door status: " + airplane.getDoorStatus() + "\n");

        airplane.takeOff();
        System.out.println("Plane takeoff successful. Gas level after takeoff: " + airplane.getGasLevel() + "\n");

        airplane.doneTakeOff();
        System.out.println("Landing gear status after takeoff: " + airplane.getLandingGear() + "\n");

        airplane.normalFlight(50);
        System.out.println("Gas level after flying for 50% of remaining gas level: " + airplane.getGasLevel() + "\n");

        airplane.prepLanding();
        System.out.println("Landing gear status before landing: " + airplane.getLandingGear() + "\n");

        airplane.land();
        System.out.println("Airplane gas level after landing: " + airplane.getGasLevel() + "\n");

        airplane.openDoor();
        System.out.println("Opened airplane door. Door status: " + airplane.getDoorStatus() + "\n");

        airplane.unloadPass();
        System.out.println("Unloaded all passengers. Number of passengers onboard: " + airplane.getPassengers() + "\n");

        airplane.fillUp();
        System.out.println("Filled airplane gas tank. Gas level: " + airplane.getGasLevel() + "\n");

        System.out.println("Final airplane status:");
        System.out.println("Gas level: " + airplane.getGasLevel());
        System.out.println("Door status: " + airplane.getDoorStatus());
        System.out.println("Landing gear status: " + airplane.getLandingGear());
        System.out.println("Number of passengers onboard: " + airplane.getPassengers() + "\n");
    }
}
