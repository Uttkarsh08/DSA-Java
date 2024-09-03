package Bit_maipulation;

public class clearBitsInRange {

    public static int clearBit(int x, int i, int j){
        int a= ~0<<(j+1);
        int b= (1<<i)-1;
        int bitMask = a|b;
        return x&bitMask;

    }

    public static void main(String[] args) {
        
    }
}
