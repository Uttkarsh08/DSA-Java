package Graphs;

import java.util.ArrayList;

public class MotherVertex {
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
       boolean[] vis = new boolean[V];
       int lastvis=-1;
       for(int i=0; i<V; i++){
           if(!vis[i]){
               dfs(adj, vis, i);
               lastvis = i;  // candidate for the mother vertex()
           }
       }
       vis = new boolean[V];
       dfs(adj, vis, lastvis);
       
       for(boolean i: vis){
           if(!i) return -1;
       }
       return lastvis;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>>adj, boolean[] vis, int i){
        vis[i] = true;
        
        for(int neigh: adj.get(i)){
            if(!vis[neigh]){
                dfs(adj, vis, neigh);
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);

        System.out.println(findMotherVertex(V, adj));
        
    }
}
