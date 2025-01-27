package CP;
import java.util.Arrays;
import java.util.Scanner;

public class CSESgridPaths {
    public static int MOD = 1000000007;
    public static int Sol(char[][] grid, int i, int j, int[][] dp){
        int n= grid.length;

        if (i >= n || j >= n || grid[i][j] == '*') return 0;
        if(i== n-1 && j== n-1){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = ((Sol(grid, i, j+1, dp)%MOD+ Sol(grid, i+1, j, dp)%MOD)%MOD);

    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();

            char[][] grid = new char[n][n];
            for(int i=0; i<n; i++){
                String row = sc.nextLine().trim();
                
                for(int j=0; j<n; j++){
                    grid[i][j] = row.charAt(j);
                }
                
            }

            int[][] dp = new int[n][n];
            for(int i=0; i<n; i++){
                Arrays.fill(dp[i], -1);
            }
            
            
            System.out.println(Sol(grid, 0, 0, dp));
    }
}
