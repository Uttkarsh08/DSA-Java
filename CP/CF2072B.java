package CP;

import java.util.Scanner;

public class CF2072B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            int small = 0;
            int large = 0;

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '-') {
                    small++;
                } else {
                    large++;
                }
            }

            if (small < 2 || large < 1) {
                System.out.println(0);
                continue;
            }
            int left = small / 2;
            int right = small - left;

            long ans = (long) left * right * large;
            System.out.println(ans);
        }

        sc.close();

    }
}
