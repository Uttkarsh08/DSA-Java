package CP;

import java.util.Scanner;

public class CF2040B {
    // see the pattern , initially all are 0, we will make 1st 0 as 1, now , ideally, if we add a ! at some other 0, first 1 and the new converted 1 can make some 0's -> 1 if the 2nd condition satisfies
    //so we see pattern that , after adding first 1, n-=1  then after adding 2nd 1 , n-=3(ist and 2nd one make some more 0's-> 1 using 2nd condition), then n-=6..... i.e, they are multipel of 2 with itself 3, 6, 12, 24.....
    public static int sol(int n){
        int ans=1;
        n-=1;
        int multiple = 3;
        while(n>0){
            n-=multiple;
            ans++;
            multiple*=2;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            System.out.println(sol(n));
        }

        sc.close();
    }
}
