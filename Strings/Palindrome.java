public class Palindrome {
    public static boolean ispalindrome(String str){
        int s = 0;
        int e = str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static boolean ispalindrome2(String str){
        int n = str.length()-1;
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "okko";
        System.out.println(ispalindrome(str));
        System.out.println(ispalindrome2(str));
    }
}
