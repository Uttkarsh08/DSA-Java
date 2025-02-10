package CP;

import java.util.Scanner;

public class CF2065B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();

            boolean is1 = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    is1 = true;
                    break;
                }
            }

            if (is1 == true) {
                System.out.println(1);
            } else {
                System.out.println(s.length());
            }
        }

        sc.close();
    }
}
