import java.util.ArrayList;
import java.util.Scanner;

public class CSESRoundTrip {

    public static void cycle(int cur, int par, boolean[] vis, ArrayList<Integer> ans,
            ArrayList<ArrayList<Integer>> adj) {
        vis[cur] = true;
        ans.add(cur);
        for (int neigh : adj.get(cur)) {
            if (!vis[neigh]) {
                cycle(neigh, cur, vis, ans, adj);
            } else if (vis[neigh] && neigh != par) { // cycle
                int cyclestart = ans.indexOf(neigh);
                if (cyclestart != -1) {
                    System.out.println(ans.size() - cyclestart + 1); // length
                    for (int i = cyclestart; i < ans.size(); i++) {
                        System.out.print(ans.get(i) + " ");
                    }
                    System.out.println(neigh); // To close the cycle
                    System.exit(0);
                }

            }
        }
        ans.remove(ans.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int x = m;
        while (x-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            adj.get(s).add(e);
            adj.get(e).add(s);

        }

        boolean vis[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                cycle(i, -1, vis, new ArrayList<>(), adj);
            }
        }
        System.out.println("IMPOSSIBLE");

        sc.close();
    }
}
