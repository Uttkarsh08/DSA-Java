package CP;

import java.util.Scanner;

public class CF2057A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(Math.max(n, m)+1);
        }

        sc.close();
    }

    
}
