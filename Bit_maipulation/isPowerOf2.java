package Bit_maipulation;

public class isPowerOf2 {

    public static boolean isPowerOfTwo(int a){
        return (a&(a-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(6));
    }
}
