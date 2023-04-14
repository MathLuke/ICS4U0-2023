public class Recursion_Assignment_Set1 {

    public int sum(int end) {
        int sum = 0;
        for (int i = 1; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumR(int end) {
        if (end == 1) {
            return 1;
        }
        return end + sumR(end-1);
    }

    public int timeTable(int base, int exponent) {
        int total = 1;
        for (int i = 0; i < exponent; i++) {
            total *= base;
        }
        return total;
    }

    public int timeTableR(int base, int exponent) {
        if (exponent <= 0) {
            return 1;
        }
        return base * timeTableR(base, exponent - 1);
    }
}
