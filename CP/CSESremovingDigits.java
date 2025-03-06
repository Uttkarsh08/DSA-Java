package CP;

import java.util.Scanner;

public class CSESremovingDigits {
    static int ans = 0;

    public static int sol(int n) {
        if (n == 0)
            return ans;
        int temp = n;
        int max = 0;
        while (temp > 0) {
            int last = temp % 10;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(sol(n));
        }
    }
}
