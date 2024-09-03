package Backtracking;

import java.util.ArrayList;

public class RatinMaze {

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        
        function(0, 0, m, m.length, "", ans, visited);
        if(ans.size() == 0){
            ans.add("-1");
        }
        return ans;
    }
    
    public static void function(int i, int j, int[][] arr, int n, String str, ArrayList<String> ans, boolean[][] visited){
        
        if(i<n && j<n && i>=0 && j>=0 && arr[i][j] !=0 && visited[i][j] == false){
            
            if(i==n-1 && j==n-1){
                ans.add(str);
                return;
            }
            
            visited[i][j] = true;
            function(i+1, j, arr, n, str+"D", ans, visited);
            function(i-1, j, arr, n, str+"U", ans, visited);
            function(i, j+1, arr, n, str+"R", ans, visited);
            function(i, j-1, arr, n, str+"L", ans, visited);
            visited[i][j] = false;
        }
        else{
            return;
        }
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 0, 1, 0, 0 },
        { 1, 1, 1, 1 } };

        System.out.println(findPath(maze, 4));
    }
    
}
