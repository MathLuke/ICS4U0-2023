/**
 * <h1>Hover Engine</h1>
 * Class to represent a prototype hover engine, with a size and energy amount,
 * capable of lifting up to a maximum weight.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-02-20
 *
 * @author Luke Mathieu, Tom Philip, and Ethan Xu
 */

public class HoverEngine {
    /** The amount of energy stored within the engine. */
    private double energyAmount;
    /** Whether the engine is on or not. */
    private boolean isEngineOn;
    /** The engine size (small, medium, large, etc.) */
    private final String size;
    /** The maximum weight capacity the engine can support */
    private final double MAX_WEIGHT;

    HoverEngine () {
        energyAmount = 0.0;
        isEngineOn = false;
        size = "Small";
        MAX_WEIGHT = 0.0;
    }

    HoverEngine (double energyAmount, boolean isEngineOn, String size, double maxWeight) {
        this.energyAmount = energyAmount;
        this.isEngineOn = isEngineOn;
        this.size = size;
        this.MAX_WEIGHT = maxWeight;
    }

    /**
     * Adds an amount of charge to the engine.
     * @param amount The amount of charge to be added.
     */
    public void chargeEngine (double amount) {
        energyAmount += amount;
    }

    /**
     * Turns the engine on if there is enough energy for the engine to activate.
     * @return True if the engine successfully activates, false if there is
     * not enough energy for the engine to turn on.
     */
    public boolean activateEngine () {
        if (energyAmount >= 30.0){
            energyAmount -= 30.0;
            isEngineOn = true;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Deactivates the engine.
     */
    public void deactivateEngine () {
        isEngineOn = false;
    }

    /**
     * Decrements energyAmount by a specified amount, used whenever the engine is in operation.
     * @param amount The amount of energy to be decremented.
     * @return True if energyAmount was successfully decremented, false if the amount is greater than the energyAmount
     */
    public boolean useEngine(double amount) {
        if (energyAmount >= amount) {
            energyAmount -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Getter for isEngineOn variable.
     * @return State of isEngineOn.
     */
    boolean getEngineStatus () {
        return isEngineOn;
    }

    /**
     * Getter for energyAmount variable.
     * @return State of energyAmount.
     */
    double getEnergyAmount () {
        return energyAmount;
    }

    /**
     * Getter for size variable.
     * @return State of size.
     */
    String getSize () {
        return size;
    }

    /**
     * Getter for MAX_WEIGHT variable.
     * @return State of MAX_WEIGHT.
     */
    double getMaxWeight () {
        return MAX_WEIGHT;
    }
}
