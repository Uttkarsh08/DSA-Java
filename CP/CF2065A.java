package CP;

import java.util.Scanner;

public class CF2065A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();

            String base = s.substring(0, s.length() - 2);

            System.out.println(base + "i");
        }

        sc.close();
    }
}
