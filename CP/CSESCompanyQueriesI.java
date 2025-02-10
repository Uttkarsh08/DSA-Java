package CP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSESCompanyQueriesI {
    static List<List<Integer>> adj;
    static int LOG;
    static int[][] dp;

    public static void maketree(int child, int parent) {
        adj.get(parent).add(child);
    }

    public static void dfs(int node, int parent) {
        dp[node][0] = parent;

        for (int i = 1; i <= LOG; i++) {
            if (dp[node][i - 1] != -1) {
                dp[node][i] = dp[dp[node][i - 1]][i - 1];
            } else {
                dp[node][i] = -1; // No valid ancestor
            }
        }

        for (int neigh : adj.get(node)) {
            if (neigh != parent) {
                dfs(neigh, node);
            }
        }
    }

    public static int Sol(int node, int k) {
        for (int i = 0; i <= LOG; i++) {
            if ((k & (1 << i)) > 0) { // If the i-th bit in k is set
                node = dp[node][i];
                if (node == -1)
                    return -1; // No ancestor exists
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int parent = sc.nextInt();
            maketree(i, parent);
        }

        dp = new int[n + 1][LOG + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= LOG; j++) {
                dp[i][j] = -1;
            }
        }
        dfs(1, -1);

        // Process queries
        while (q-- > 0) {
            int node = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(Sol(node, k));
        }

        sc.close();
    }
}
