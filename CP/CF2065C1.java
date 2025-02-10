package CP;

import java.util.Scanner;

public class CF2065C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            long[] arr2 = new long[x];
            for (int i = 0; i < x; i++) {
                arr2[i] = sc.nextInt();
            }

            long m = arr2[0];

            long[] finalarr = new long[n];

            finalarr[0] = Math.min(m - arr[0], arr[0]);
            for (int i = 1; i < n; i++) {
                long mod = m - arr[i];
                if (mod >= finalarr[i - 1]) {
                    if (arr[i] > finalarr[i - 1]) {
                        finalarr[i] = Math.min(arr[i], mod);
                    } else {
                        finalarr[i] = mod;
                    }
                } else {
                    finalarr[i] = arr[i];
                }

            }

            boolean isAsc = true;
            for (int i = 0; i < n - 1; i++) {
                if (finalarr[i] > finalarr[i + 1]) {
                    isAsc = false;
                    break;
                }
            }

            System.out.println((isAsc == true) ? "YES" : "NO");

        }

        sc.close();
    }
}
