package Graphs;

import java.util.ArrayList;

public class DetectCycle {
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
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

    }
    
    public static boolean detechCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detechCycleUtil(graph, i, -1, vis)){
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean detechCycleUtil(ArrayList<Edge>[] graph, int cur, int par, boolean[] vis){
        
        vis[cur] = true;

        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);

            //case 3
            if(!vis[e.des]){
                if(detechCycleUtil(graph, e.des, cur, vis)){
                    return true;
                }
            }

            //case 1
            else if(vis[e.des] && e.des != par){
                return true;
            }

            //case 2 -> cur == par -> continue
        }
        return false;
    }
    
    public static void main(String[] args) {
        /*
                0------------3
               /|            |
              / |            |
             /  |            4
            1   |
             \  |
              \ |
                2
         */

         int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);

        System.out.println(detechCycle(graph));
    }
}
