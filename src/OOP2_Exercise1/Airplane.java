package OOP2_Exercise1;

/** <h1>Airplane</h1>
 * Class to represent an airplane with a gas level, landing gear status,
 * door status, and number of passengers.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 16, 2023
 * @author Luke Mathieu
 */

public class Airplane {
    /** Airplane gas level */
    private int gasLevel;
    /** Airplane landing gear status */
    private String landingGear;
    /** Airplane door status */
    private String doorStatus;
    /** Number of passengers on airplane */
    private int passengers;

    /**
     * Default constructor. Creates an Airplane object with gas level 100,
     * landing gear down, door status open, and 100 passengers inside.
     */
    public Airplane () {
        gasLevel = 100;
        landingGear = "Down";
        doorStatus = "Open";
        passengers = 100;
    }

    /**
     * Creates an Airplane object.
     * @param gasLevel Gas level to be passed to the object.
     * @param landingGear Landing gear status to be passed to the object.
     * @param doorStatus Door status to be passed to the object.
     * @param passengers Number of passengers in the airplane object
     */
    public Airplane (int gasLevel, String landingGear, String doorStatus, int passengers) {
        this.gasLevel = gasLevel;
        this.landingGear = landingGear;
        this.doorStatus = doorStatus;
        this.passengers = passengers;
    }

    /**
     * Opens airplane door, setting doorStatus to "Open".
     */
    public void openDoor () {
        doorStatus = "Open";
    }

    /**
     * Closes airplane door, setting doorStatus to "Closed".
     */
    public void closeDoor () {
        doorStatus = "Closed";
    }

    /**
     * Fills up airplane gas tank, setting gasLevel to 100.
     */
    public void fillUp () {
        gasLevel = 100;
    }

    /**
     * Airplane takes off, decrementing gasLevel by 30.
     */
    public void takeOff () {
        gasLevel -= 30;
    }

    /**
     * Raises airplane landing gear, setting landingGear to "Up".
     */
    public void doneTakeOff () {
        landingGear = "Up";
    }

    /**
     * Airplane flies, losing a percent of its current gas level.
     * @param percent The percent of the current gas level that is consumed by the flight
     */
    public void normalFlight (int percent) {
        gasLevel *= (100-percent)/100.0;
    }

    /**
     * Lowers airplane landing gear, setting landingGear to "Down".
     */
    public void prepLanding () {
        landingGear = "Down";
    }

    /**
     * Airplane lands, decrementing gasLevel by 15.
     */
    public void land () {
        gasLevel -= 15;
    }

    /**
     * Loads a number of passengers onto the plane, increasing passengers variable.
     * @param numPass The number of passengers loaded onto the plane.
     */
    public void loadPass (int numPass) {
        passengers += numPass;
    }

    /**
     * Unloads all passengers from the plane, setting passengers to 0.
     */
    public void unloadPass () {
        passengers = 0;
    }

    /**
     * Airplane gas level getter.
     * @return Airplane gas level.
     */
    public int getGasLevel () {
        return gasLevel;
    }

    /**
     * Airplane door status getter.
     * @return Airplane door status.
     */
    public String getDoorStatus () {
        return doorStatus;
    }

    /**
     * Number of passengers getter.
     * @return Number of passengers on the airplane.
     */
    public int getPassengers () {
        return passengers;
    }

    /**
     * Airplane landing gear status getter.
     * @return Airplane landing gear status.
     */
    public String getLandingGear () {
        return landingGear;
    }
}
