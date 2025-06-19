package CP;

import java.util.Scanner;

public class CF1498A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            if (n < 10) {
                System.out.println(n);
                return;
            }

            if (n % 3 == 0)
                System.out.println(n);
            else if (n % 3 == 1)
                System.out.println(n + 2);
            else
                System.out.println(n + 1);
        }
        sc.close();
    }
}
