package Recursion;

public class friendsPair {
    public static int NumberOfWays(int n){
        if(n==1 || n==2) return n;
/*if we take a single frined we are left with n-1 options
                    |
                    v                                           */ 
        return NumberOfWays(n-1)+ (n-1)*NumberOfWays(n-2);
        /*                                      ^
                                                |
        if we take out a pair we are left with n-2 options, but there are n-1 choices to make a pair for eg. is for pair aq is selected it has n-1 options to make pare with. */
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(NumberOfWays(n));
    }
}
