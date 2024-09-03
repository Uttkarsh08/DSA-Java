package Bit_maipulation;

public class Odd_even{

    public static void check(int a){
        int bitMask = 1;  // 1 with leftShift =0
        if((a&bitMask) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
    public static void main(String[] args) {
        check(5);
        check(10);
    }
}