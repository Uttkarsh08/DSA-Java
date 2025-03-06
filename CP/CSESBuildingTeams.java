package CP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CSESBuildingTeams {
    static class pair {
        int node;
        int team;

        pair(int node, int team) {
            this.node = node;
            this.team = team;
        }
    }

    public static void bfs(int[] ans, boolean vis[], Queue<pair> q, ArrayList<ArrayList<Integer>> adj) {
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int team = q.peek().team;
            q.poll();

            for (int neigh : adj.get(node)) {
                if (vis[neigh]) {
                    if (ans[neigh] == team) {
                        System.out.println("IMPOSSIBLE");
                        System.exit(0);
                    }
                } else {
                    vis[neigh] = true;
                    ans[neigh] = (team == 1) ? 2 : 1;
                    q.add(new pair(neigh, ans[neigh]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        while (m-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            adj.get(s).add(e);
            adj.get(e).add(s);

        }
        int[] ans = new int[n + 1];

        boolean vis[] = new boolean[n + 1];
        Queue<pair> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ans[i] = 1;
                q.add(new pair(i, 1));
                bfs(ans, vis, q, adj);
            }
        }

        for (int i = 1; i < ans.length; i++) {
            System.out.print(ans[i] + " ");

        }
        System.out.println();

        sc.close();
    }
}
