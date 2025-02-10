package CP;

import java.util.Scanner;

public class CF19992D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            System.out.println(Sol2(s, n, m, k) ? "YES" : "NO");
        }
        sc.close();
    }
    public static boolean Sol(String s, int n, int m, int k){
        int l = s.length();
        boolean[] dp = new boolean[l+2];
        dp[0] = true;
        for(int i=1; i<=l; i++){
            char ch = s.charAt(i-1);

            int x = i-1;
            int jumps = m;
            while(x>=0 && jumps-->0){
                if(dp[x] && s.charAt(x) == 'L'){
                    dp[i] = true;
                    break;
                }
                x--;
            }
            if(ch == 'W' && !dp[i]){//still false, after checking jump
                //we have to swim
                k--;
                if(k<0) return false;
                dp[i] = true;
            }
   
        }

        return dp[l+1];
    }


    public static boolean Sol2(String w, int n, int m, int k){
        String s = "L"+w+"L";
        int len = s.length();

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch == 'L'){
                if(s.charAt(i+1) != 'L'){
                    if(i+m>=len-1) return true;
                else{
                    int water = -1;
                    int land = -1;
                    for(int j = Math.min(i + m, len - 1); j>i; j--){
                        if(s.charAt(j) == 'W'){
                            water=j;
                        }else if(s.charAt(j) == 'L'){
                            land=j;
                            break;
                        }
                    }
                    if (land != -1) {
                        i = land;
                    } else if (water != -1) {
                        if(k>0){
                            k--;
                            i=water;
                        }else{
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                }
            }else if(ch == 'W'){
                k--;
                if(k<0) return false;
            }else{
                return false;
            }
        }
        return true;
    }
}