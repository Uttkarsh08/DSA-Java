package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static class Edge{
        int src;
        int des;
        int wt;
        public Edge(int src, int des, int wt){
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();    // this will create empty arraylist at each index of array
        }
 
        graph[0].add(new Edge(0, 2, 4));
        graph[0].add(new Edge(0, 1, 2));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        for(int i=0; i<V-1; i++){
            //edges
            for(int j=0; j< edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }

        //check for -ve cycle
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                // Negative weight cycle detected
                return new int[]{-1};
            }
        }
        return dist;
        
        
        
    }

    public static void main(String[] args) {
        /*
                    1------3
                   /       | \
                  0        |   5 ---- 6
                   \       | /
                    2------4
         */

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        // int[] ans = bellmanFord(graph, 0);
        // for(int i=0; i<ans.length; i++){
        //     System.out.print(ans[i]+" ");
        // }
        System.out.println();
    }
}
