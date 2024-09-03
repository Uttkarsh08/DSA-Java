package Recursion;

public class XtoPn {
    public static int XtopowerN(int x, int n){   // O(n)
        if(n==0){
            return 1;
        } 
        return x * XtopowerN(x, n-1);
    }

    public static int XtopowerN2(int x, int n){    // O(logn)  {to get the reason analyse stack calls }{it bacically is doing less stack calls}
        if(n==0) return 1;
        // int halfPower = XtopowerN2(x, n/2) * XtopowerN2(x, n/2);   // make two function calls, which will lead to increasee in time complexity.
        int halfPower = XtopowerN2(x, n/2);
        halfPower = halfPower*halfPower;   // instead sqauring the variable after making one function call only.
        if(n%2!=0) halfPower = x*halfPower;
        return halfPower;

    }
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(XtopowerN(x, n));
        System.out.println(XtopowerN2(x, n));
    }
}
