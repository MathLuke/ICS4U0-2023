package OOP1_Exercise1;

/** <h1>OOP1_Exercise1.House</h1>
 * Class to represent a house with an address, postal code, size, number of stories, and whether the home is detached.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 *
 * February 9, 2023
 * @author Luke Mathieu
 */

public class House{
    private int street_num;
    private String street;
    private String city;
    private String province;
    private String postal_code;
    private double size;
    private boolean detached;
    private int stories;

    // Class constructor
    public House(int n, String s, String c, String pv, String p, double si, boolean d, int l){
        street_num = n;
        street = s;
        city = c;
        province = pv;
        postal_code = p;
        size = si;
        detached = d;
        stories = l;
    }

    /**
     * Outputs the house's address to the console.
     */
    public void displayAddress(){
        System.out.println(street_num + " " + street);
        System.out.println(city + ", " + province);
        System.out.println(postal_code);
    }
} // OOP1_Exercise1.House class