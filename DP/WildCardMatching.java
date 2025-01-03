package DP;

public class WildCardMatching {
    public static boolean patternMatch(String str, String pattern){
        int n = str.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n+1][m+1];

        //initialization
        dp[0][0] = true;
        for(int i=1; i<=n; i++){
            dp[i][0] = false;    //we have some string but no pattern(always false)
        }

        for(int j=1; j<=m; j++){ // we have no string but a pattern(not always false)
            if(pattern.charAt(j-1) == '*'){ // if last is star-> we can make it null, but we need to check for m-1 length.
                dp[0][j] = dp[0][j-1];  // if m-1 len is true and we encounter * at last -> true
            }else{
                dp[0][j] = false;  // if a character like a, b etc or ?-> always false
            }
        }

        //filling
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern.charAt(j-1) == '*'){ 
                    //2 choices
                    boolean ignore = dp[i][j-1];
                    boolean use = dp[i-1][j];

                    dp[i][j] = ignore || use;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }
    public static void main(String[] args) {
        String str = "cb";
        String pattern = "?";

        System.out.println(patternMatch(str, pattern));
    }
}
