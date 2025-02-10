package CP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSESTreeDistances1 {
    public static List<List<Integer>> adj = new ArrayList<>();
    public static int[] firstMax, scndMax, ans;
    public static int n;

    public static void maketree(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);    
    }

    public static void dfs(int node, int par){

        firstMax[node] = scndMax[node] = 0;

        for(int neigh : adj.get(node)){
            if(neigh == par) continue;
            dfs(neigh, node);

            int h = firstMax[neigh] + 1;
            if(h > firstMax[node]){
                scndMax[node] = firstMax[neigh];
                firstMax[node] = h;
            }else if(h > scndMax[node]){
                scndMax[node] = h;
            }
        }

    }

    public static void Solve(int node, int par, int parContribution) {
        ans[node] = Math.max(firstMax[node], parContribution);

        for (int neigh : adj.get(node)) {
            if (neigh == par) continue;

            int newParContribution = parContribution + 1;
            if (firstMax[neigh] + 1 == firstMax[node]) {
                newParContribution = Math.max(newParContribution, scndMax[node] + 1);
            } else {
                newParContribution = Math.max(newParContribution, firstMax[node] + 1);
            }

            Solve(neigh, node, newParContribution);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            maketree(u-1, v-1);
        }

        firstMax = new int[n];
        scndMax = new int[n];
        ans = new int[n];

        dfs(0, -1);

        Solve(0, -1, 0);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();

    }
}
