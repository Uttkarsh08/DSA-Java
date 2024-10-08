public class MinNoOfSwaps {
    static int minSwaps(String s){
        int unmatched = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '[') unmatched++;
            else if(unmatched >0) unmatched--;
        }
        return(unmatched+1)/2;
    }
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
    }
}
