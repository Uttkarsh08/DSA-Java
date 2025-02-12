package CP;

import java.util.Scanner;

public class CF2067A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y == x + 1) {
                System.out.println("YES");
            } else {
                int diff = x - y + 1;
                if (diff >= 9 && diff % 9 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}