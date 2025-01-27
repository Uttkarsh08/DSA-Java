package CP;

import java.util.Arrays;
import java.util.Scanner;

public class CF2048B {

    // given the k(length of subset), we only need to make sure that at ecah k(because, they will then be included in more subsets) we have minimum values.
    //for eg - n = 4, k= 2, we have numbers 1, 2, 3 and 4
    //now without arranging , the sum of minimum of all 2 length subsets are - 1+2+3 = 6
    //now, we want smaller values on k's , start putting from 1, then on next k 2 and so on
    //so array becomes _ 1 _ 2, now start filling from 3(all rest values doesnt matter that where it comes).

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] ans = new int[n+1];
            Arrays.fill(ans, -1);
            int cur =1;
            for(int i=k; i<=n; i=i+k){
                ans[i] = cur;
                cur++;
            }
            
            for(int i=1; i<=n; i++){
                if(ans[i] == -1){
                    ans[i] = cur;
                    cur++;
                }
            }

            for(int i=1; i<=n; i++){
                System.out.print(ans[i]+" ");;
            }
            System.out.println();
        }

        sc.close();
    }
}
