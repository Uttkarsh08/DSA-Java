package CP;

import java.util.*;

public class CF2072D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            arr[0] = 0;

            int maxval = 0;
            int l = 1;

            for (int i = 1; i <= n; i++) {
                int cnt = 0;
                for (int j = i + 1; j <= n; j++) {
                    if (arr[j] < arr[i]) {
                        cnt++;
                    }
                }
                if (cnt > maxval) {
                    maxval = cnt;
                    l = i;
                } else if (cnt == maxval) {
                    l = arr[l] > arr[i] ? l : i;
                }
            }
            int r = 1;
            if (l == n) {
                r = l;
            } else {
                for (int i = n; i > 0; i--) {
                    if (arr[i] < arr[l]) {
                        r = i;
                        break;
                    }
                }
            }

            System.out.println(l + " " + r);
        }
        sc.close();
    }
}
