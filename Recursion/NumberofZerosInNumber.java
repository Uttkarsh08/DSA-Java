package Recursion;

public class NumberofZerosInNumber {
    public static int numberOFZeros(int n){
        if(n==0) return 0;
        int rem = n%10;      
        if(rem == 0){
            return 1+ numberOFZeros(n/10);
        }

        return numberOFZeros(n/10);
    }
    public static int numberOFZeros2(int n, int ans){
        if(n==0){
            return ans;
        }
        int rem = n%10;
        if(rem == 0){
            return numberOFZeros2(n/10, ans+1);
        }
        return numberOFZeros2(n/10, ans);
    
        
    }
    public static void main(String[] args) {
        System.out.println(numberOFZeros2(7007808, 0));
    }
}
