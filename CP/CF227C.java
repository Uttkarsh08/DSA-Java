package CP;

import java.util.Scanner;

public class CF227C {
    static int ans = 0;
    static int MOD = 1000000007;

    public static void Sol(long n, int from, int to, int using) {
        if (n == 0)
            return;
        // given 1 2 3 4 and places A B C(they are in C)
        // Ideal case is to move smallest to A first. WHY? -> because
        // if largest(4) is first to move to A , we cant move smaller elements(1 2 3) to
        // A,
        // because a number larger then them(4) is already on A, and then we have to
        // again move largest elemet on A(4) to put smaller elements on A
        // But, to move smallest on A(1), we have to first move all elements larger then
        // it(2 3 4) to A
        Sol(n - 1, from, to, using); // move 2 3 4 from C to A
        ans++; // move 1 from C to B(we cant directly move from C to A beacuse we can move 1
               // step(to adjacent only)
        Sol(n - 1, to, from, using); // move 2 3 4 from A to C
        ans++; // move 1 from B to A
        Sol(n - 1, from, to, using); // move 2 3 4 from C to A
    }

    public static int Sol2(int n) {
        long result = (power(3, n) - 1 + MOD) % MOD; // Ensure no negative values
        return (int) result;
    }

    public static int power(int b, int e) {
        if (e == 0)
            return 1; // Base case: any number to the power of 0 is 1
        int half = power(b, e / 2); // Recursive call for half the exponent
        half = (int) ((1L * half * half) % MOD); // Modular multiplication to avoid overflow
        if (e % 2 == 0) {
            return half; // If exponent is even
        } else {
            return (int) ((1L * b * half) % MOD); // If exponent is odd331358794
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // Sol(n, 3, 1, 2);
        // System.out.println(ans % m);
        MOD = m;
        System.out.println(Sol2(n));

        sc.close();
    }

}
