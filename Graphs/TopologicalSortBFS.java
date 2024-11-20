package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
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

    public static void CalcInDegree(ArrayList<Edge>[] graph, int[] indeg){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.des]++;
            }
        }
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<Edge>[] graph){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indeg = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        CalcInDegree(graph, indeg);
        
        for(int i=0; i<indeg.length; i++){  // first add all those nodes in queue, whoes indegree is 0.
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){  ///BFS
            int cur = q.poll();
            ans.add(cur);

            for(int i=0; i<graph[cur].size(); i++){
                Edge e = graph[cur].get(i);
                indeg[e.des]--;

                if(indeg[e.des] ==0){
                    q.add(e.des);
                }
            }
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
        System.out.println(topologicalSort(graph));
    }
}
