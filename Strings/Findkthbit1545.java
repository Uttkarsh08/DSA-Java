public class Findkthbit1545 {
    public static char findKthBit(int n, int k) {
        int len = (int)Math.pow(2, n)-1;
        return recu(len ,k);
    }
    public static char recu(int len , int k){
        if(len==1){
            return '0';
        }
        int half = len/2;
        int mid = half+1;

        if(k==mid) return '1';
        else if(k<mid){//left
            return recu(half, k);
        }else{
            char ans = recu(half, len-k+1);
            return (ans=='0')?'1':'0';
        }
    }
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }
}
