package Others;

public class GCD {

    public static int calcGcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        int ans = 0;
        int min = Math.min(a, b);

        for (int i = 1; i < min; i++) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 18, b = 0;
        System.out.println(calcGcd(a, b));
    }
}
