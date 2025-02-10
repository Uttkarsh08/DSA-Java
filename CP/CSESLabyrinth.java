package CP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CSESLabyrinth {
    static class pair {
        int row;
        int col;
        String path;

        pair(int r, int c, String path) {
            this.row = r;
            this.col = c;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] arr = new char[n][m];
        boolean vis[][] = new boolean[n][m];

        pair start = null;
        pair end = null;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'A') {
                    start = new pair(i, j, "");
                }
                if (arr[i][j] == 'B') {
                    end = new pair(i, j, "");
                }
            }
        }

        int[] drow = new int[] { 0, -1, 0, 1 };
        int[] dcol = new int[] { -1, 0, 1, 0 };
        char[] dir = new char[] { 'L', 'U', 'R', 'D' };

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(start.row, start.col, ""));
        vis[start.row][start.col] = true;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            String curpath = q.peek().path;

            q.poll();

            if (r == end.row && c == end.col) {
                System.out.println("YES");
                System.out.println(curpath.length());
                System.out.println(curpath);
                sc.close();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] != '#' && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new pair(nr, nc, curpath + dir[i]));
                }
            }
        }
        System.out.println("NO");
        sc.close();
    }
}

// import java.util.*;

// public class CSESLabyrinth {
// static class Pair {
// int row, col;

// Pair(int r, int c) {
// this.row = r;
// this.col = c;
// }
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int n = sc.nextInt();
// int m = sc.nextInt();
// sc.nextLine(); // Consume the newline

// char[][] arr = new char[n][m];
// boolean[][] vis = new boolean[n][m];
// Pair[][] parent = new Pair[n][m]; // To track the shortest path

// Pair start = null, end = null;

// for (int i = 0; i < n; i++) {
// String line = sc.nextLine();
// for (int j = 0; j < m; j++) {
// arr[i][j] = line.charAt(j);
// if (arr[i][j] == 'A') {
// start = new Pair(i, j);
// }
// if (arr[i][j] == 'B') {
// end = new Pair(i, j);
// }
// }
// }

// if (start == null || end == null) {
// System.out.println("NO");
// return;
// }

// int[] drow = { 0, -1, 0, 1 };
// int[] dcol = { -1, 0, 1, 0 };
// char[] dir = { 'L', 'U', 'R', 'D' };

// Queue<Pair> q = new LinkedList<>();
// q.add(start);
// vis[start.row][start.col] = true;

// while (!q.isEmpty()) {
// Pair cur = q.poll();
// int r = cur.row, c = cur.col;

// if (r == end.row && c == end.col) {
// // Reconstruct the shortest path using parent array
// StringBuilder path = new StringBuilder();
// while (parent[r][c] != null) {
// Pair prev = parent[r][c];
// for (int i = 0; i < 4; i++) {
// if (prev.row + drow[i] == r && prev.col + dcol[i] == c) {
// path.append(dir[i]);
// break;
// }
// }
// r = prev.row;
// c = prev.col;
// }
// System.out.println("YES");
// System.out.println(path.length());
// System.out.println(path.reverse());
// sc.close();
// return;
// }

// for (int i = 0; i < 4; i++) {
// int nr = r + drow[i];
// int nc = c + dcol[i];

// if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] != '#' &&
// !vis[nr][nc]) {
// vis[nr][nc] = true;
// parent[nr][nc] = new Pair(r, c); // Store the parent node
// q.add(new Pair(nr, nc));
// }
// }
// }

// System.out.println("NO");
// sc.close();
// }
// }
