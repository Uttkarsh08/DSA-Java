package CP;

import java.util.*;

public class CSESMovieFestival {

    public static int Solve(int n, int[][] arr, int max) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int cur = Integer.MIN_VALUE;
        int ans = 0;

        for (int[] interval : arr) {
            if (interval[0] >= cur) {
                cur = interval[1];
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int i = 0;
        int temp = n;
        int max = Integer.MIN_VALUE;

        while (temp-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            max = Math.max(max, e);

            arr[i][0] = s;
            arr[i][1] = e;
            i++;
        }

        System.out.println(Solve(n, arr, max));
    }
}
