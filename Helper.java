import java.util.Arrays;

public class Helper {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime2(int n) {
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public static boolean isPrime3(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime[n];
    }

    public static long modOp(long a, long x) {
        int MOD = 1000000009;
        long ans = 1;
        for (int i = 0; i < x; i++) {
            ans = ((ans % MOD) * (a % MOD) % MOD);
        }

        return ans;
    }

    public static int BinaryExpmodeOp(int a, int x) {
        int ans = 1;
        while (x > 0) {
            if (x % 2 != 0) {
                ans *= a;
            }
            a *= a;
            x /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        // long st = System.nanoTime();
        // int a = 0;
        // for (int i = 1; i < 10000; i++) {
        // if (isPrime(i)) {
        // a++;
        // }
        // }
        // long et = System.nanoTime();
        // System.out.println(et - st);

        // System.out.println(isPrime3(23));

        // System.out.println(modOp(638743847, 12));
        System.out.println(BinaryExpmodeOp(2, 5));
    }
}
