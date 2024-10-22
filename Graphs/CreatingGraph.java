package Graphs;
import java.util.*;
public class CreatingGraph {
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
 
         //0 vertex
         graph[0].add(new Edge(0, 1, 5));
 
         //1 vertex
         graph[1].add(new Edge(1, 0, 5));
         graph[1].add(new Edge(1, 2, 1));
         graph[1].add(new Edge(1, 3, 3));
 
         //2 vertex
         graph[2].add(new Edge(2, 1, 1));
         graph[2].add(new Edge(2, 3, 1));
         graph[2].add(new Edge(2, 4, 2));
 
         //3 vertex
         graph[3].add(new Edge(3, 1, 3));
         graph[3].add(new Edge(3, 2, 1));
         
         //4 vertex
         graph[4].add(new Edge(4, 2, 2));
    }
    public static void main(String[] args) {
        /*
                        (5)
                    0---------1
                            /  \
                       (1) /    \ (3)
                          /      \
                          2------ 3
                          |  (1)
                       (2)|
                          |
                          4
         */

        int V = 5; //vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];   // Array of Arraylist<Edge>, it will have null at each imdex
        CreateGraph(graph);
        
    }
}
