package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
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

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }
    public static int[] dijkstra(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );

        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            if(!vis[node]){
                vis[node] = true;
                //neighbours
                for(int i=0; i<graph[node].size(); i++){
                    Edge e = graph[node].get(i);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if(dist[u]+ wt < dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
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
        int[] ans = dijkstra(graph, 0);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
