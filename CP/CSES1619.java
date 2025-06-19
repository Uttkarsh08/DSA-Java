package CP;

import java.util.*;

public class CSES1619 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], d = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(d);

        int i = 0, j = 0, c = 0, m = 0;

        while (i < n) {
            if (a[i] < d[j]) {
                c++;
                m = Math.max(m, c);
                i++;
            } else {
                c--;
                j++;
            }
        }
        System.out.println(m);
    }
}
