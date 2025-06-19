package CP;

import java.util.Scanner;

public class CF581A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int next = (max - min) / 2;

        System.out.println(min + " " + next);
    }
}
