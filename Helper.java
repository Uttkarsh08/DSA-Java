public class Helper {
    public static String getSmallestString(int n, int k) {
        char[] ans =new char[n];
        k-=n;   // since every 
        for(int i=n-1; i>=0; i--){
            if(k>=25){
                ans[i] = 'z';
                k-=25;
            }else{
                ans[i] = (char) ('a'+k);
                k=0;
            }
        }
        return new String(ans);
    }
    public static void main(String[] args) {
        System.out.println(getSmallestString(3,3));
    }
}
