package ex01;

public class Calculator{

    public static <T extends Number> double sum(T a, T b) {
        return (double) a + (double) b;
    }

    public static <T extends Number> double  multiply(T a, T b) {
        return (double) a * (double) b;
    }

    public static <T extends Number> double divide(T a, T b) {
        return (double) a / (double) b;
    }

    public static <T extends Number> double subtract(T a, T b) {
        return (double) a - (double) b;
    }
}
