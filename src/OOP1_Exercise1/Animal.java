package OOP1_Exercise1;

/** <h1>OOP1_Exercise1.Animal</h1>
 * Class to represent an animal with a name and weight. Stores whether the animal is hungry or tired.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 9, 2023
 * @author Luke Mathieu
 */

public class Animal{
    private String name;
    private boolean tired;
    private boolean hungry;
    private double weight;

    // Class constructor
    public Animal(String n, double w){
        name = n;
        tired = true;
        hungry = true;
        weight = w;
    }

    /**
     * Causes the animal to eat, making it no longer hungry, and increases its weight based on what food it ate.
     * @param v The food the animal will eat.
     */
    public void feed(String v){
        hungry = false;
        if (v.equals("vegetables"))
            weight +=2;
        else if (v.equals("meat"))
            weight +=4;
        else
            weight +=1;

    }

    /**
     * Causes the animal to sleep, making it no longer tired, and also causes the animal
     * to lose a small amount of weight.
     */
    public void sleep(){
        tired = false;
        weight -=3;
    }

    /**
     * Returns a String containing the name of the animal and the weight in a simple message.
     * @return The message containing the name and the weight.
     */
    public String message() {
        return name + " has a weight of " + weight + " kilograms.";
    }
} // OOP1_Exercise1.Animal class