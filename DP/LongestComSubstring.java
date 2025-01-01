package DP;

public class LongestComSubstring {
    public static int Lcstabulation(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
                
            }
        }
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "acdghr";
        int n = s1.length();
        int m = s2.length();
        
        System.out.println(Lcstabulation(s1, s2, n, m));
    }
}
