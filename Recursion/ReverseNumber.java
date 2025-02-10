package Recursion;

public class ReverseNumber {

    public static int Reverse(int n, int pos){
        if(n==0) return 0;
        return (n%10)*(int)Math.pow(10, pos-1) + Reverse(n/10, pos-1);

    }
    
    public static void main(String[] args) {
        int n = 1842;
        int pos = (int)Math.log10(n)+1;
        // System.out.println(Reverse(n, pos));
    }
}
