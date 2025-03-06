package CP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSESTreeDiameter {
    public static List<List<Integer>> adj = new ArrayList<>();
    public static int dia = 0;

    public static void maketree(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);    
    }

    public static int Diameter(int node, int par){
        int maxh = 0;
        for(int neigh: adj.get(node)){
            if (neigh == par) continue;
            int h = Diameter(neigh, node);

            dia = Math.max(dia, maxh+h+1);
            maxh = Math.max(maxh, h+1);

        }

        return maxh;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            maketree(u-1, v-1);
        }

        Diameter(0, -1);
        System.out.println(dia);
        sc.close();
        
    }
}
