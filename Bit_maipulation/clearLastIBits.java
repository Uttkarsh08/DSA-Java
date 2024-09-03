package Bit_maipulation;

public class clearLastIBits{

public static int clearBits(int a, int i){

    int bitMask = ~0 <<i;
    return a&bitMask;
}

    public static void main(String[] args) {
        System.out.println(clearBits(7, 1));
    }
}