package Recursion;

public class TilingProblem {
    public static int NumberOfWays(int n){
        //base case  ----->
        if(n==0 || n==1) return 1;
        //kaam ---->
        return NumberOfWays(n-1) + NumberOfWays(n-2);
    }
 public static void main(String[] args) {
    int n = 4;
    System.out.println(NumberOfWays(n));
 }   
}
