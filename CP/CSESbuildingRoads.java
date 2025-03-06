package CP;

import java.util.ArrayList;
import java.util.Scanner;

public class CSESbuildingRoads {

    public static void dfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[cur] = true;
        for (int neigh : adj.get(cur)) {
            if (!vis[neigh]) {
                dfs(neigh, adj, vis);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int nr = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= cities; i++) {
            adj.add(new ArrayList<>());
        }

        while (nr-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            adj.get(s).add(e);
            adj.get(e).add(s);

        }

        boolean[] vis = new boolean[cities + 1];
        int ans = 0;
        ArrayList<Integer> ans2 = new ArrayList<>();
        for (int i = 1; i <= cities; i++) {
            if (!vis[i]) {
                ans2.add(i);
                dfs(i, adj, vis);
                ans++;
            }
        }

        System.out.println(ans - 1);

        for (int i = 0; i < ans - 1; i++) {
            System.out.println(ans2.get(i) + " " + ans2.get(i + 1));
        }
        sc.close();
    }
}
