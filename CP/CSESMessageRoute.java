package CP;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CSESMessageRoute {
    static class pair {
        int node;
        int dis;

        pair(int node, int dis) {
            this.node = node;
            this.dis = dis;

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
        int x = m;
        while (x-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            adj.get(s).add(e);
            adj.get(e).add(s);

        }

        boolean vis[] = new boolean[n + 1];
        int[] par = new int[n + 1];

        PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        q.add(new pair(1, 1));
        vis[1] = true;
        par[1] = -1;

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int dis = q.peek().dis;
            q.poll();

            if (node == n) {
                System.out.println(dis);
                ArrayList<Integer> path = new ArrayList<>();
                while (node != -1) {
                    path.add(node);
                    node = par[node];
                }

                for (int i = path.size() - 1; i >= 0; i--) {
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();

                sc.close();
                return;
            }

            for (int neigh : adj.get(node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    par[neigh] = node;
                    q.add(new pair(neigh, dis + 1));
                }
            }
        }
        System.out.println("IMPOSSIBLE");

        sc.close();
    }
}
