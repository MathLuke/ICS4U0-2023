package OOP1_Exercise1;

public class Dummy {
    public static int staticInt = 3;
    private final int nonStaticInt;

    Dummy (int x, int y) {
        nonStaticInt = x;
        staticInt = y;
    }

    public int getNonStaticInt() {
        return nonStaticInt;
    }

    public int getStaticInt() {
        return staticInt;
    }
}