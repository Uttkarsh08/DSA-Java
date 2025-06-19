package CP;

import java.util.Scanner;

public class CF1853A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int mindiff = Integer.MAX_VALUE;
            int ans = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (i == 0)
                    continue;
                else {
                    int curdiff = arr[i] - arr[i - 1];
                    if (curdiff < 0) {
                        ans = 0;
                        break;
                    }
                    mindiff = Math.min(mindiff, curdiff);
                }

            }

            System.out.println(ans == 0 ? ans : (mindiff / 2) + 1);
        }

        sc.close();
    }
}
