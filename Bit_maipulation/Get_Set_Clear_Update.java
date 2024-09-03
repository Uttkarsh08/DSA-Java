package Bit_maipulation;

public class Get_Set_Clear_Update {
    public static void getBit(int a,int i){
        int bitmask = 1<<i;
        if((a & bitmask) == 0){
            System.out.println("0");
        }else System.out.println("1");
    }

    public static int SetBit(int a, int i){
        int bitMask = 1<<i;
        return a|bitMask;
    }

    public static int clearBit(int a, int i){
        int bitMask = ~(1<<i);
        return a & bitMask;
    }

    public static int UpdateBit(int a, int i, int newBit){
        if(newBit == 0){
            return clearBit(a, i);
        }else return SetBit(a, i);
    }

    public static int UpdateBit2(int a, int i, int newBit){
        a = clearBit(a, i);
        int bitMask  = newBit<<i;
        return a|bitMask;
    }
    public static void main(String[] args) {
        // getBit(4, 1);
        // System.out.println(SetBit(4, 1));
        // System.out.println(clearBit(7, 1));
        System.out.println(UpdateBit(10,2,1));
        System.out.println(UpdateBit2(10,2,1));

    }
}
 