package Others;

public class EuclideanGCD {

    public static int calcGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 12, b = 18;
        System.out.println(calcGcd(a, b));
    }
}
