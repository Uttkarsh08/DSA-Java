package CP;

import java.util.Scanner;

public class CF2072A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();

            int ans = Math.abs(k) / p + (Math.abs(k) % p == 0 ? 0 : 1);

            if (ans <= n) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }

        }
        sc.close();
    }
}
