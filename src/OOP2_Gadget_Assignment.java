/**
 * <h1>OOP2 Gadget Assignment</h1>
 * Driver class for the OOP2 Gadget Assignment.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-02-20
 *
 * @author Luke Mathieu, Tom Philip, Ethan Xu
 */

public class OOP2_Gadget_Assignment extends HoverEngine {

    // main method 
    public static void main(String[] args) {
        HoverEngine engine = new HoverEngine(100.0, 100.0, false, "Medium", 100.0);

        System.out.print("This " + engine.getSize() + "-sized engine supports a maximum weight of " + engine.getMaxWeight() + ", with a maximum energy capacity of " + engine.getMaxEnergy() + ". This engine currently has an energy level of " + engine.getEnergyAmount());
        if (engine.getEngineStatus()) {
            System.out.println(" and is currently enabled.\n");
        } else {
            System.out.println(" and is currently disabled.\n");
        }

        if (engine.activateEngine()) {
            System.out.println("Engine has just been enabled. Current energy level is " + engine.getEnergyAmount() + "\n");
        } else {
            System.out.println("Engine could not be enabled due to a lack of energy. Current energy level is " + engine.getEnergyAmount() + "\n");
        }


        engine.chargeEngine(30);
        System.out.println("Engine has just been charged. Current energy level is " + engine.getEnergyAmount() + "\n");

        if (engine.useEngine(70)) {
            System.out.println("Engine was used. Current energy level is " + engine.getEnergyAmount() + "\n");
        } else {
            System.out.println("Engine could not be used due to a lack of energy. Current energy level is " + engine.getEnergyAmount() + "\n");
        }

        engine.deactivateEngine();
        if (!engine.getEngineStatus()) {
            System.out.println("Engine has been deactivated. Current engine status is disabled.");
        } else {
            System.out.println("A fatal error has occurred.");
        }
        System.out.println("\n=====\n");


        try {
            HoverBuilding building = new HoverBuilding(0.0, 1000000.0, false, 100.0, 15.0, 0.0, 0.0, 0.0, true, "Townhome", 10);
            HoverVehicle vehicle = new HoverVehicle(1.5, 10.0,10.0, 10.0, 20);

            System.out.print(building.getBuildingType() + " building has a weight of " + building.getBuildingWeight() + " and a height of " + building.getBuildingHeight() + ". ");
            System.out.print("The building is currently located at coordinates " + building.getXPos() + ", " + building.getYPos() + ", " + building.getZPos() + ". ");
            System.out.print("There are " + building.getParkingSpaces() + " in the building. The building has an energy level of " + building.getEnergyAmount() + ". ");
            if (!building.getDoorStatus()) {
                System.out.println("The building's doors are currently closed.\n");
            } else {
                System.out.println("The building's doors are currently open.\n");
            }

            System.out.print("Hover vehicle has a weight of " + vehicle.getWeight() + " and a speed of " + vehicle.getSpeed() + ". ");
            System.out.print("The vehicle is currently located at coordinates " + vehicle.getX() + ", " + vehicle.getY() + ", " + vehicle.getZ() + ". ");
            System.out.println("The vehicle is not currently occupying any building, thus its current parking space is represented by " + vehicle.getVehicleParkingSpot() + ".");
            System.out.println("The vehicle has an energy level of " + vehicle.getEnergyAmount() + ".\n");

            building.openDoors();
            System.out.println("Building doors are now open.\n");

            building.closeDoors();
            System.out.println("Building doors are now closed for safety while the building is in motion.\n");

            building.chargeEngine(50000.0);
            building.activateEngine();
            System.out.println("Building engine was charged and activated. Energy level is now " + building.getEnergyAmount() + ".\n");

            building.raiseBuilding(150);
            building.lowerBuilding(50);
            System.out.println("Building moved upwards 150 metres, then down 50 metres. Current height above the ground is " + building.getZPos() + ". Building energy level is " + building.getEnergyAmount() + ".\n");

            vehicle.move(building);
            vehicle.dock(building);
            System.out.println("Hover vehicle moved into building, then docked in one of its parking spots. Vehicle energy level is " + vehicle.getEnergyAmount() + ". Vehicle is now parked in spot " + vehicle.getVehicleParkingSpot() + " of the " + vehicle.getOccupiedHoverBuilding().getBuildingType() + ".");
            if (building.checkParkingSpace(0) != null) {
                System.out.println("The building has recognized that a vehicle is parked in spot 0.\n");
            }

            vehicle.setSpeed(100);
            System.out.println("Vehicle speed is now " + vehicle.getSpeed() + ".\n");

            vehicle.move(20,20,20);
            System.out.println("Vehicle has moved to 20.0, 20.0, 20.0. Vehicle is no longer parked at the building, so its occupied hover building is " + vehicle.getOccupiedHoverBuilding() + ".\n");

        } catch (Exception e) {
            System.out.println("Fatal error.");
        }

    }
}
