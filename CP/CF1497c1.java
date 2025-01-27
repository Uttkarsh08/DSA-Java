package CP;

import java.util.Scanner;

public class CF1497c1 {
    public static void solution(int n, int k){
        for (int i = 0; i < k - 3; i++) {
            System.out.print(1 + " ");
        }
        n -= (k - 3);
        if(n%2!=0){
            int m = (n-1)/2;
            System.out.println(m+" "+m+" "+"1");
        }else{
            if(n%4!=0){
                int m = (n-2)/2;
                System.out.println(m+" "+m+" "+"2");
            }else{
                int m = n/4;
                System.out.println(2*m+" "+m+" "+m);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            solution(n, k);
        }
        sc.close();
    }
}
