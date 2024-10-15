public class SeperateBlackAndWhite2938 {
    public static long minimumSteps(String s) {
        long ans = 0;
        int ones = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '1'){
                ones++;
            }
            if(arr[i] == '0'){
                ans+=ones;
            }
        } 
        return ans;
    }
    public static void main(String[] args) {
        
        String s = "01011100101";
        System.out.println(minimumSteps(s));
    }
}
