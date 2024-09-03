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
        int n = 5;
        System.out.println(Factorial(n));
    }
}
