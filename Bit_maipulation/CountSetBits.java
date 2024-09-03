package Bit_maipulation;

public class CountSetBits {
    public static int countSetBits(int a){
            int count = 0;
            while(a>0){
                if((a&1) == 1) count++;
                a= a>>1;
            }
            return count;
    }
    public static void main(String[] args) {
        System.out.println(countSetBits(10));
    }
}
