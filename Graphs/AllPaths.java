package Graphs;

import java.util.ArrayList;

public class AllPaths {
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
 
        graph[0].add(new Edge(0, 3, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static ArrayList<String> allPaths(ArrayList<Edge>[] graph, int src, int des, String path, ArrayList<String> ans){
        if(src == des){
            ans.add(path+des);
            return ans;
        }

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            allPaths(graph, e.des, des, path+src, ans);
        }

        return ans;
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
        System.out.println(allPaths(graph, 5, 1, "", new ArrayList<>()));
    }
}
