package Graphs;

import java.util.ArrayList;

public class DFS {
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
 
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static ArrayList<Integer> dfs(ArrayList<Edge>[] graph){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        for(int i=0;i<graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, ans, i, visited);
            }
        }

        return ans;
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, ArrayList<Integer> ans, int cur, boolean visited[]){   //0(V+E)
        //visit
        ans.add(cur);
        visited[cur] = true;

        // recursive call for its neighbours
        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!visited[e.des]){
                dfsUtil(graph, ans, e.des, visited);
            }
        }
    }
    public static void main(String[] args) {
        /*
                    1------3
                   /       | \
                  0        |   5 ---- 6
                   \       | /
                    2------4
         */

        int V = 7;
        ArrayList<Integer> ans = new ArrayList<>();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        System.out.println(dfs(graph));
    }
}
