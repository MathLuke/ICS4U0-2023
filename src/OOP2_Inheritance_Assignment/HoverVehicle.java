package OOP2_Inheritance_Assignment;

/**
 * * <h1>Hover Vehicle</h1>
 * Class to represent a prototype hovering vehicle, which uses
 * the Hover Engine technology to power the vehicle.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-02-2
 *
 * @author Luke Mathieu, Tom Philip, and Ethan Xu
 */
public class HoverVehicle extends HoverEngine {

    /**
     * Weight of the vehicle.
     */
    private double weight;
    /**
     * X position of the vehicle.
     */
    private double xPos;
    /**
     * Y position of the vehicle.
     */
    private double yPos;
    /**
     * Z position of the vehicle.
     */
    private double zPos;
    /**
     * Speed of the vehicle.
     */
    private int speed;
    /**
     * The current building in which this vehicle is parked in.
     * If the vehicle is not parked, this attribute is null.
     */
    private HoverBuilding occupiedHoverBuilding;
    /**
     * The current parking space of the vehicle.
     * If the vehicle is not parked, this attribute is -1.
     */
    private int vehicleParkingSpot;

    /**
     * This constructor creates a hover vehicle with a given weight, speed, and starting coordinates.
     * @param wght Weight of the vehicle.
     * @param x X position.
     * @param y Y position
     * @param z Z position.
     * @param spd Speed of the vehicle.
     * @throws Exception Throws an exception if invalid arguments are given. Negative vertical position or weight are
     * invalid, and if the given weight is too heavy for the engine.
     */
    public HoverVehicle(double wght, double x, double y, double z, int spd) throws Exception {
        super(500,2000, false, "Small", 800);
        if(z<0){
            throw new Exception("Vertical position (z) cannot be below 0!");
        }
        if(weight>super.getMaxWeight()){
            throw new Exception("Vehicle weight is too heavy!");
        }
        if (weight<0){
            throw new Exception("Vehicle weight cannot be negative!");
        }
        this.weight = wght;
        this.xPos = x;
        this.yPos = y;

        this.zPos = z;
        this.speed = spd;
        this.occupiedHoverBuilding = null;
        this.vehicleParkingSpot = -1;
    }

    /**
     * This constructor creates a hover vehicle which starts at a hover building.
     * If the building has no empty parking spots it is created at the building and not parked.
     * @param wght Weight of the hover vehicle.
     * @param building The building at which the hover vehicle starts at.
     * @param spd Initial speed of the hover vehicle.
     * @throws Exception Throws an exception if the building argument is null.
     */
    public HoverVehicle(double wght, HoverBuilding building, int spd) throws Exception {
        super(500, 2000, false, "Small", 800);
        if(building == null){
            throw new Exception("Building must not be null");
        }
        this.weight = wght;
        this.xPos = building.getXPos();
        this.yPos = building.getYPos();
        this.zPos = building.getZPos();
        this.speed = spd;
        this.vehicleParkingSpot = -1;
        dock(building);
    }

    /**
     * Moves to a given x, y, z coordinate. Consumes fuel on use.
     * @param x X position to move to.
     * @param y Y position to move to.
     * @param z Z position to move to.
     * @return Returns true if moving to the location was succesful, otherwise returns false.
     */
    public boolean move(double x, double y, double z){
        if(z<0){
            return false;
        }
        if(!super.activateEngine()){
            return false;
        }
        double energyToConsume = Math.sqrt((this.xPos-x)*(this.xPos-x)+(this.yPos-y)*(this.yPos-y)+(this.zPos-z)*(this.zPos-z))/1000*this.weight*(1-0.6/(((double)this.speed/40-2)*((double)this.speed/40-2)+1));
        if(!super.useEngine(energyToConsume)){
            return false;
        }
        this.xPos = x;
        this.yPos = y;
        this.zPos = z;
        super.deactivateEngine();
        if (this.occupiedHoverBuilding!=null){
            try {
                this.occupiedHoverBuilding.exitParkingSpace(this, this.vehicleParkingSpot);
            } catch (Exception e){
                System.err.println("Could not exit parking space. This error should never be seen. \nThere is a critical developer bug if you see this.");
            }
            this.vehicleParkingSpot = -1;
            this.occupiedHoverBuilding = null;
        }
        return true;
    }

    /**
     * This is an overloaded method for convenience to move to a given hover building.
     * @param building The building to move to.
     * @return Returns true if the operation was successful, false otherwise.
     */
    public boolean move(HoverBuilding building){
        return move(building.getXPos(), building.getYPos(), building.getZPos());
    }

    /**
     * Docks the hover vehicle into the parking garage of the hover building.
     * @param building The building to dock to. The coordinates of the hover vehicle must match those of the building
     *                 for docking to be successful.
     * @return Returns true if the operation was successful, false otherwise.
     */
    public boolean dock(HoverBuilding building){
        if(building.getXPos()!=this.xPos||building.getYPos()!=this.yPos||building.getZPos()!=this.zPos){
            return false;
        }
        for(int i = 0; i<building.getParkingSpaces(); i++) {
            if (building.enterParkingSpace(this, i)) {
                this.occupiedHoverBuilding = building;
                this.vehicleParkingSpot = i;
                return true;
            }

        }
        return false;
    }

    /**
     * Getter method for the hover vehicle weight.
     * @return Hover vehicle weight.
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Getter method for the hover vehicle X position.
     * @return Hover vehicle X position.
     */
    public double getX() {
        return xPos;
    }
    /**
     * Getter method for the hover vehicle Y position.
     * @return Hover vehicle Y position.
     */
    public double getY() {
        return yPos;
    }
    /**
     * Getter method for the hover vehicle Z position.
     * @return Hover vehicle Z position.
     */
    public double getZ() {
        return zPos;
    }
    /**
     * Getter method for the hover vehicle speed.
     * @return Hover vehicle speed.
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Getter method for the hover vehicle's currently occupied hover building.
     * @return Hover vehicle's currently occupied hover building.
     */
    public HoverBuilding getOccupiedHoverBuilding() {
        return occupiedHoverBuilding;
    }
    /**
     * Getter method for the hover vehicle parking spot.
     * @return Hover vehicle parking spot.
     */
    public int getVehicleParkingSpot() {
        return vehicleParkingSpot;
    }

    /**
     * Sets the speed of the hover vehicle.
     * @param speed The speed at which to set the hover vehicle.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}