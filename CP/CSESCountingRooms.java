package CP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CSESCountingRooms {
    static class pair {
        int row;
        int col;

        pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    static int[] drow = new int[] { 0, -1, 0, 1 };
    static int[] dcol = new int[] { -1, 0, 1, 0 };

    public static void bfs(char[][] arr, boolean[][] vis, Queue<pair> q, int n, int m) {
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && arr[nr][nc] == '.') {
                    vis[nr][nc] = true;
                    q.add(new pair(nr, nc));
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] arr = new char[n][m];
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '.' && !vis[i][j]) {
                    vis[i][j] = true;
                    Queue<pair> q = new LinkedList<>();
                    q.add(new pair(i, j));
                    bfs(arr, vis, q, n, m);
                    ans++;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
