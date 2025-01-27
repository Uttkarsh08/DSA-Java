package CP;

import java.util.Arrays;
import java.util.Scanner;

public class CF1538C {
    public static int solution(int arr[], int l, int r) {
        int n = arr.length;
        int ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int left = lowerBound(arr, l - arr[i], i + 1, n);
            int right = upperBound(arr, r - arr[i], i + 1, n);
            ans += (right - left);
        }
        return ans;
    }

    public static int lowerBound(int arr[], int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int upperBound(int arr[], int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr, l, r));
        }
        sc.close();
    }
}
