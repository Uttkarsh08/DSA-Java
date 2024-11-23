package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo_MST {
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
    static class Pair{
        int v;
        int cost;

        Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public static int Prims(ArrayList<Edge>[] graph){

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.cost, b.cost)
        );
        int finalcost = 0;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int node = cur.v;
            if(!vis[node]){
                vis[node] = true;
                finalcost+=cur.cost;
                //neighbours
                for(int i=0; i<graph[node].size(); i++){
                    Edge e = graph[node].get(i);
                    pq.add(new Pair(e.des, e.wt));
                }
            }
        }

        return finalcost;
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
        int ans = Prims(graph);
        System.out.println(ans);
    }
}
