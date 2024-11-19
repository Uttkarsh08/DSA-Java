package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalDFS {
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
 

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static ArrayList<Integer> topologicalSort(ArrayList<Edge>[] graph){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSortUtil(graph, i, visited, s);
            }
        }
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
        return ans;
        
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int cur, boolean visited[], Stack<Integer> s){   //0(V+E)
        visited[cur] = true;

        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!visited[e.des]){
                topologicalSortUtil(graph, e.des, visited, s);
            }
        }
        s.push(cur);   // adding to stack so to use its LIFO property
        // since we are using DFS(recursion), in u->v, V will always be added before U in the stack
        // so when removing elements from stack , we get V after U.
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
        System.out.println(topologicalSort(graph));
    }
}
