package CP;

import java.util.ArrayList;
import java.util.Scanner;

public class CF1352A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            int mul = 1;
            ArrayList<Integer> arr = new ArrayList<>();
            while (n > 0) {
                int last = n % 10;
                if (last > 0) {
                    ans++;
                    arr.add(last * mul);
                }
                mul *= 10;
                n /= 10;
            }

            System.out.println(ans);
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
