package OOP1_Exercise1;

public class Static_Test {

    public static void main (String [] args) {
        Dummy dummy1 = new Dummy(1, 2);
        Dummy dummy2 = new Dummy(2, 4);

        System.out.println(dummy1.getNonStaticInt() + " " + dummy1.getStaticInt());
        System.out.println(dummy2.getNonStaticInt() + " " + dummy2.getStaticInt());
        System.out.println(Dummy.staticInt);
    }
}
