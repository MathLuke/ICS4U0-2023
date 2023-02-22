/**
 * <h1>Hover Building</h1>
 * Class to represent a prototype hover building which utilizes hover engines to achieve its
 * hovering abilities.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * <p>
 * 2023-02-21
 *
 * @author Luke Mathieu, Tom Philip, and Ethan Xu
 */

public class HoverBuilding extends HoverEngine {
    /**
     * The weight of the building
     */
    private double buildingWeight;
    /**
     * The height of the building, in meters
     */
    private final double buildingHeight;
    /**
     * The x-coordinate position of the building
     */
    private final double xPos;
    /**
     * The y-coordinate position of the building
     */
    private final double yPos;
    /**
     * The z-coordinate position of the building
     * or how high the building is above the ground
     */
    private double zPos;
    /**
     * Is the door of the building open or closed
     */
    private boolean isDoorClosed;
    /**
     * The type of building is hovering
     * i.e. apartment, shop, house, etc.
     */
    private final String buildingType;
    /**
     * The number of available parking spaces in the building
     */
    private final int PARKING_SPACES;
    /**
     * Stores all the vehicles parking in the building garage
     */
    HoverVehicle[] garage;

    /**
     * This constructor creates a hover building with a specified building weight, height, and type
     * as well as the building's location in the form of a (x,y,z) coordinate system
     * @param buildingWeight the weight of the building
     * @param buildingHeight the height of the building
     * @param buildingType the type of building
     * @param x the x position
     * @param y the y position
     */
    public HoverBuilding(double buildingWeight, double buildingHeight, String buildingType, double x, double y) {
        super(0.0, 10000.0,false, "Large", 2000);
        this.buildingWeight = buildingWeight;
        this.buildingHeight = buildingHeight;
        xPos = x;
        yPos = y;
        zPos = 0.0;
        isDoorClosed = true;
        this.buildingType = buildingType;
        PARKING_SPACES = 0;
        garage = new HoverVehicle[0];
    }

    /**
     * This constructor creates a hover building with a custom hover engine
     * @param energyAmount the energy amount of the engine
     * @param maxEnergy the maximum energy capacity of the engine
     * @param isEngineOn whether the engine is on or off
     * @param buildingWeight the weight of the building
     * @param buildingHeight the height of the building
     * @param x the x position
     * @param y the y position
     * @param z the z position
     * @param isDoorClosed whether the door is open or closed
     * @param buildingType the type of the building
     * @param numParkingSpaces the number of parking spaces available for this building
     */
    public HoverBuilding(double energyAmount, double maxEnergy, boolean isEngineOn, double buildingWeight, double buildingHeight, double x, double y, double z, boolean isDoorClosed, String buildingType, int numParkingSpaces) {
        super(energyAmount, maxEnergy, isEngineOn, "Large", 2000);
        this.buildingWeight = buildingWeight;
        this.buildingHeight = buildingHeight;
        xPos = x;
        yPos = y;
        zPos = z;
        this.isDoorClosed = isDoorClosed;
        this.buildingType = buildingType;
        PARKING_SPACES = numParkingSpaces;
        garage = new HoverVehicle[numParkingSpaces];
    }

    /**
     * raises the height of the building or the z position. Energy is used depending on the height moved
     * @param increaseHeight the distance to raise the building
     */
    public void raiseBuilding(double increaseHeight) {
        double requiredEnergy = increaseHeight*100.3;
        if(super.useEngine(requiredEnergy)) {
            zPos += increaseHeight;
        }
    }

    /**
     * lowers the height of the building or the z position. Energy is used depending on the height moved
     * @param decreaseHeight the distance to lower the building
     */
    public void lowerBuilding(double decreaseHeight) {
        double requiredEnergy = decreaseHeight*50.5;
        if(super.useEngine(requiredEnergy)) {
            zPos -= decreaseHeight;
        }
    }

    /**
     * Adds a vehicle to the garage and updates the building's total weight depending on the weight
     * of the new vehicle
     * @param vehicle the vehicle that wants to park into garage
     * @param parkingSpace the parking space index the car want to park in
     * @return true if the vehicle is able to park, false if the vehicle is unable to
     */
    public boolean enterParkingSpace(HoverVehicle vehicle, int parkingSpace){
        double vehicleWeight = vehicle.getWeight();

        if(parkingSpace < 0 || parkingSpace >= PARKING_SPACES-1) {
            return false;
        } else if(garage[parkingSpace] == null && buildingWeight+vehicleWeight <= super.getMaxWeight()) {
            buildingWeight += vehicleWeight;
            garage[parkingSpace] = vehicle;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a vehicle from the garage and updates the building's total weight depending on the
     * weight of the removed vehicle
     * @param vehicle the vehicle that wants to exit the garage
     * @param parkingSpace the parking space index of the car
     * @throws Exception if the parking space index is invalid or if the parking space is already empty
     */
    public void exitParkingSpace(HoverVehicle vehicle, int parkingSpace) throws Exception {
        if(parkingSpace < 0 || parkingSpace >= PARKING_SPACES-1) {
            throw new Exception("That is not a valid parking space");
        } else if(garage[parkingSpace] != null) {
            buildingWeight -= garage[parkingSpace].getWeight();
            garage[parkingSpace] = null;
        } else {
            throw new Exception("That parking space is already empty");
        }
    }

    /**
     * Setter method which opens the doors
     */
    public void openDoors() {
        isDoorClosed = false;
    }

    /**
     * Setter method which closes the doors
     */
    public void closeDoors() {
        isDoorClosed = true;
    }

    //=-----------------------------// get methods //---------------------------------=

    /**
     * Getter method for the hover building weight
     * @return hover building weight
     */
    public double getBuildingWeight() {
        return buildingWeight;
    }

    /**
     * Getter method for the hover building height
     * @return hover building height
     */
    public double getBuildingHeight() {
        return buildingHeight;
    }

    /**
     * Getter method for the hover building x position
     * @return hover building x position
     */
    public double getXPos() {
        return xPos;
    }

    /**
     * Getter method for the hover building y position
     * @return hover building y position
     */
    public double getYPos() {
        return yPos;
    }

    /**
     * Getter method for the hover building z position
     * @return hover building z position
     */
    public double getZPos() {
        return zPos;
    }

    /**
     * Getter method for the hover building current door status
     * @return hover building door status
     */
    public boolean getDoorStatus() {
        return isDoorClosed;
    }

    /**
     * Getter method for the hover building's building type
     * @return hover building type
     */
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * Getter method for the number of parking spaces in hover building
     * @return number of parking spaces in hover building
     */
    public int getParkingSpaces() {
        return PARKING_SPACES;
    }

    /**
     * Getter method to find the vehicle parked at the specified parking space index
     * @param parkingSpace the index of the parking space
     * @return the vehicle object parked at the specified index or null if there is none
     * @throws Exception throws an exception if an invalid parking space index is passed into the method
     */
    public HoverVehicle checkParkingSpace(int parkingSpace) throws Exception {
        if(parkingSpace < 0 || parkingSpace >= PARKING_SPACES-1) {
            throw new Exception("That is not a valid parking space");
        } else if(garage[parkingSpace] != null) {
            return garage[parkingSpace];
        }
        return null;
    }
}
