package Recursion;

public class febonacci {
    public static int Febo(int n){
        if(n==0 || n==1){
            return n;
        } 
        return Febo(n-1) + Febo(n-2);
    }
    public static void main(String[] args) {
        int a = 3;
        System.out.println(Febo(a));
    }
}
