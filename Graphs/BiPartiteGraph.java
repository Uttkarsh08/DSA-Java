package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraph {
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

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

    }


    public static boolean isBypartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];
        for(int i=0; i<color.length; i++){
            color[i] = -1;  // No color
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){  // perform bfs
                q.add(i);
                color[i] = 0; //red

                while(!q.isEmpty()){
                    int cur = q.remove();
                    for(int j=0; j<graph[cur].size(); j++){
                        Edge e = graph[cur].get(j);

                        //case 3
                        if(color[e.des] == -1){
                            int nxtColor = color[cur] == 0? 1: 0;
                            color[e.des] = nxtColor;
                            q.add(e.des);
                        }

                        //case 1
                        else if(color[e.des] == color[cur]) return false;

                        //case 2 -> different colors -> continue

                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        /*
                0--------2
               /        /
              /        /
             /        4
            1        /
             \      /
              \    /
                2
         */

         int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        System.out.println(isBypartite(graph));
    }
}
