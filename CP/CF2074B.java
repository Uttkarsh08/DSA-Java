package CP;

import java.util.Scanner;

public class CF2074B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int ans = 1;
            for (int i = 0; i < n; i++) {
                ans += arr[i] - 1;
            }

            System.out.println(ans);
        }
    }
}
