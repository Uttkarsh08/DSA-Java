package Recursion;

public class PrintNumbes {

    public static void Decreasingnumbers(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        Decreasingnumbers(n-1);
    }

    public static void Increasingnumbers(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        Increasingnumbers(n-1);
        System.out.print(n+" ");
        
    }

    public static int SumofNnumbers(int n){
        if(n==0){
            return 0;
        }
        return n + SumofNnumbers(n-1);
        
    }
    public static void main(String[] args) {
        int a = 10;
        // Increasingnumbers(a);
        // System.out.println();
        // Decreasingnumbers(a);
        // System.out.println(SumofNnumbers(a));
        Increasingnumbers(a);
    }
}
