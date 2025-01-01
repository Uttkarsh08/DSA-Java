package DP.LongestComSubsequence;

public class LCSrecursion {

    public static int LcsRecursion(String s1, String s2, int n, int m){
        if(n==0 || m==0) return 0;

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return LcsRecursion(s1, s2, n-1, m-1)+1;
        }else{
            int ans1 = LcsRecursion(s1, s2, n-1, m);
            int ans2 = LcsRecursion(s1, s2, n, m-1);

            return Math.max(ans1, ans2);
        }
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println(LcsRecursion(s1, s2, s1.length(), s2.length()));
    }
}
