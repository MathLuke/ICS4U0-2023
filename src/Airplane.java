/** <h1>Airplane</h1>
 * Class to represent an airplane with a gas level, landing gear status,
 * door status, and number of passengers.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 15, 2023
 * @author Luke Mathieu
 */

public class Airplane {
    private int gasLevel;
    private String landingGear;
    private String doorStatus;
    private int passengers;

    public Airplane () {
        gasLevel = 100;
        landingGear = "Down";
        doorStatus = "Open";
        passengers = 100;
    }

    public Airplane (int gasLevel, String landingGear, String doorStatus, int passengers) {
        this.gasLevel = gasLevel;
        this.landingGear = landingGear;
        this.doorStatus = doorStatus;
        this.passengers = passengers;
    }

    public void openDoor () {
        doorStatus = "Open";
    }

    public void closeDoor () {
        doorStatus = "Closed";
    }

    public void fillUp () {
        gasLevel = 100;
    }

    public void takeOff () {
        gasLevel -= 30;
    }

    public void doneTakeOff () {
        landingGear = "Up";
    }

    /**
     * TEST METHOD BEHAVIOUR
     * @param percent
     */
    public void normalFlight (int percent) {
        gasLevel *= (100-percent)/100.0;
    }

    public void prepLanding () {
        landingGear = "Down";
    }

    public void land () {
        gasLevel -= 15;
    }

    public void loadPass (int numPass) {
        passengers += numPass;
    }

    public void unloadPass () {
        passengers = 0;
    }

    public int getGasLevel () {
        return gasLevel;
    }

    public String getDoorStatus () {
        return doorStatus;
    }

    public int getPassengers () {
        return passengers;
    }

    public String getLandingGear () {
        return landingGear;
    }
}
