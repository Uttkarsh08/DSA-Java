package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgo{
    static int find(int a, int[] par){
        if(a == par[a]) return a;
        
        return par[a] = find(par[a], par);
    }
    
    static void union(int a, int b, int[] par, int[] rank){
        int parA = find(a, par);
        int parB = find(b, par);
        
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int[]> edges = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            for(int[] edge: adj.get(i)){
                int v = edge[0];
                int wt = edge[1];
                
                edges.add(new int[]{i, v, wt});
            }
        }
        
        edges.sort(Comparator.comparingInt(a -> a[2]));
        
        
        int[] par = new int[V];
        int[] rank = new int[V];
        
        for(int i=0; i<V; i++){
            par[i]= i;
            rank[i]=0;
        }
        
        int ans=0; int count=0;
        for(int[] edge: edges){
            int u=edge[0];
            int v= edge[1];
            int wt = edge[2];
            
            if(find(u, par) != find(v, par)){
                union(u, v, par, rank);
                ans+=wt;
                count++;
                if(count==V-1) break;
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
       
    }
}
