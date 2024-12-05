package Graphs;

import java.util.ArrayList;

public class ArticulationPtTargan {
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

    public static void CreateGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);
    
        graph.get(1).add(2);
    
        graph.get(2).add(0);
        graph.get(2).add(1);
    
        graph.get(3).add(0);
        graph.get(3).add(4);
        graph.get(3).add(5);
    
        graph.get(4).add(3);
        graph.get(4).add(5);
    
        graph.get(5).add(3);
        graph.get(5).add(4);
    }
    
    
    public static ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];
        int[] dt = new int[V];
        int[] low = new int[V];
        int time =0;
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(adj, vis, ap, i, dt, low, time, -1);
            }
        }
        
        for(int i=0; i<V; i++){
            if(ap[i]){
                ans.add(i);
            }
        }
        if (ans.isEmpty()) {
            ArrayList<Integer> noPoints = new ArrayList<>();
            noPoints.add(-1);
            return noPoints;
        } else {
            return ans;
        }
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] ap, int cur, int[] dt, int[] low, int time, int par){
        vis[cur] = true;
        dt[cur] = low[cur] = time++;
        int child =0;
        
        for(int i: adj.get(cur)){
            if(i== par) continue;
            else if(!vis[i]){
                dfs(adj, vis, ap, i, dt, low, time, cur);
                
                low[cur] = Math.min(low[cur], low[i]);
                
                if(par != -1 && dt[cur] <= low[i]){
                    ap[cur] = true;
                }
                child++;
            }else{
                low[cur] = Math.min(low[cur], dt[i]);
            }
        }
        if(par == -1 && child > 1){
            ap[cur] = true;
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        CreateGraph(graph);
        System.out.println(articulationPoints(graph.size(), graph));
    }
}
