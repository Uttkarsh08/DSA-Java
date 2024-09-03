package Recursion;

public class BinaryString {

    public static void printStrings(int n, int lastPlace, String s){
        //base
        if(n==0){
            System.out.println(s);
            return;
        }
        //kaam
        printStrings(n-1, 0, s+"0");
        if(lastPlace == 0){
            printStrings(n-1, 1, s+"1");
        }
    }
    public static void main(String[] args) {
        printStrings(3, 0, "");
    }
}
