package DP.LongestComSubsequence;

public class LCStabulation {
    static String ans ="";
    public static int LcsTabulation(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0) dp[i][j] = 0;
            }    
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans+=s1.charAt(i-1);
                    
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int n = s1.length();
        int m = s2.length();
        
        System.out.println(LcsTabulation(s1, s2, n, m));
        System.out.println(ans);
    }
}
