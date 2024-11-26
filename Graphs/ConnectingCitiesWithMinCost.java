package Graphs;

import java.util.PriorityQueue;

public class ConnectingCitiesWithMinCost {

        public static int minCost(int[][] cities){
            int n = cities.length;
            boolean[] vis = new boolean[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)-> a[1]- b[1]
            );

            int ans=0;

            pq.add(new int[]{0,0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int node = cur[0];
                int cost = cur[1];

                if(vis[node]) continue;
                vis[node] = true;
                ans+=cost;

                for(int neigh=0; neigh <n; neigh++){
                    if(!vis[neigh] && cities[node][neigh] >0){
                        pq.add(new int[]{neigh, cities[node][neigh]});
                    }
                }
            }

            return ans;
        }

        public static void main(String[] args) {
            int[][] cities = {{0,1,2,3,4},
                            {1,0,5,0,7},
                            {2,5,0,6,0}, 
                            {3,0,6,0,0},
                            {4,7,0,0,0}
                            };
            System.out.println(minCost(cities));
        }
    }
