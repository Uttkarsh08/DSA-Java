package Recursion;

public class factorial {
    public static int Factorial(int n){
        if(n==0){
            return 1;
        }
        // int fnm1 = Factorial(n-1);
        // int fn = n * fnm1;
        // return fn;
        return n* Factorial(n-1);

    }
    public static void main(String[] args) {
        int n = 10;
        // System.out.println(Factorial(n));
        System.out.println((12700730+14515200+3628799)%998244353);
    }
}
