package CP;

import java.util.Scanner;

public class CF1857A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            int odd = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                if ((arr[i] & 1) != 0) {
                    odd++;
                }
            }

            System.out.println((odd & 1) == 0 ? "YES" : "NO");

        }
    }
}
