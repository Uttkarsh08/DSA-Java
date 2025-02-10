package CP;

import java.util.Scanner;

public class CF344C {
    static long ans = 0;

    static void Sol(int a, int b) {
        if (a == 0 || b == 0) {
            return;
        }
        if (a >= b) { // series;
            ans++;
            Sol(a - b, b);

        } else { // parallel
            ans++;
            Sol(a, b - a);
        }
    }

    static void Sol2(int a, int b) {
        if (a == 0 || b == 0) {
            return;
        }
        if (a >= b) { // series;
            ans += a / b; // reduce redundent operations to minus 1 from a/b, if a/b > 1,
            // instead use modulo to identify how many times we can minus 1, add minus it
            // all together
            Sol2(a % b, b);

        } else { // parallel
            ans += b / a;
            Sol2(a, b % a);
        }
    }

    static void Sol3(long a, long b) { // always asume a>b
        if (b == 0)
            return;
        ans += a / b; // since a> b
        Sol3(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        Sol3(a, b);
        System.out.println(ans);

        sc.close();
    }
}
