package Graphs;

import java.util.ArrayList;

public class BridgeTarjans {
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
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

    }

    public static ArrayList<ArrayList<Integer>> targenBridge(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean[] vis = new boolean[V];
        int[] time =new int[1];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                ArrayList<Integer> bridge = new ArrayList<>();
                dfs(graph, vis, dt, low, time, -1, i,bridge);
                ans.add(bridge);
            }
        }

        return ans;
    }

    public static void dfs(ArrayList<Edge> graph[], boolean[] vis, int[] dt, int[] low, int[] time ,int par, int cur,ArrayList<Integer> bridge){
        vis[cur] = true;
        dt[cur] = low[cur] = time[0]++;

        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            int neigh = e.des;
            //CASE 1:   neighbour is parent 
            if(neigh == par) continue;

            //CASE 3:   not visited
            else if(!vis[neigh]){
                dfs(graph, vis, dt, low, time, cur, neigh, bridge);

                low[cur] = Math.min(low[cur], low[neigh]);

                if(dt[cur] < low[neigh]){
                    bridge.add(cur);
                    bridge.add(neigh);
                }
            }else{  //CASE 2: already Visited (back edge)
                low[cur] = Math.min(low[cur], dt[neigh]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        System.out.println(targenBridge(graph, V));
    }
}
