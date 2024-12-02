package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosaRaju {
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
 
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

    }


    public static List<List<Integer>> kosaraju(ArrayList<Edge>[] graph, int V){
        //topological sort
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                topological(graph, vis, st, i); 
            }
        }

        //transpose graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> trans[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++){
            vis[i] = false;
            trans[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                trans[e.des].add(new Edge(e.des, e.src, e.wt));
            }
        }

        //dfs over transposed graph
        List<List<Integer>> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            int cur = st.pop();
            if(!vis[cur]){
                ArrayList<Integer> scc = new ArrayList<>();
                dfs(trans, vis, cur, scc);
                ans.add(scc);
            }
        }

        return ans;
    }

    public static void topological(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> st, int cur){
        vis[cur] = true;
        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!vis[e.des]){
                topological(graph, vis, st, e.des);
            }
        }
        st.push(cur);
    }

    public static void dfs(ArrayList<Edge>[] trans, boolean[] vis, int cur, ArrayList<Integer> scc){
        vis[cur] = true;
        scc.add(cur);
        for(int i=0; i<trans[cur].size(); i++){
            Edge e = trans[cur].get(i);
            if(!vis[e.des]){
                dfs(trans, vis, e.des, scc);
            }
        }
    }


    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        System.out.println(kosaraju(graph, V));
    }
}
