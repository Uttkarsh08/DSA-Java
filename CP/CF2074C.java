package CP;

import java.util.Scanner;

public class CF2074C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = -1;

            // Check if x is even and not a power of two
            if ((x & 1) == 0) {
                if ((x & (x - 1)) != 0) {
                    y = x - 1;
                    long z = x ^ y;
                    if (y + z > x) {
                        System.out.println(y);
                        continue;
                    }
                }
            }

            // Handle other cases (even power of two or odd x)
            long complement = ~x;
            long mask = complement & -complement;
            if (mask == 0) {
                System.out.println(-1);
                continue;
            }
            int p = Long.numberOfTrailingZeros(mask);
            y = (1L << (p + 1)) - 1;
            if (y >= x) {
                System.out.println(-1);
                continue;
            }
            long z = x ^ y;
            if ((x + y > z) && (x + z > y) && (y + z > x)) {
                System.out.println(y);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}