package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlienDict {
    public static String findOrder(String[] dict, int k) {
        boolean[] vis = new boolean[k];
        Stack<Integer> s = new Stack<>();
        StringBuilder st = new StringBuilder();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        
        createGraph(dict, k, adj);
        
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                topsort(adj, vis, s, i);
            }
        }
        while(!s.isEmpty()){
            st.append((char) (s.pop()+'a'));
        }
    
        
        
        return st.toString();
        
        
    }
    
    
    public static void createGraph(String[] dict, int k, List<List<Integer>> adj){

        for(int i=0; i<dict.length-1; i++){
            String first = dict[i];
            String second = dict[i+1];
            
            
            int len = Math.min(first.length(), second.length());
            
            for(int j=0; j<len; j++){
                char x = first.charAt(j);
                char y = second.charAt(j);
                if(x!=y){
                    adj.get(x-'a').add(y-'a');
                    break;
                }
                
            }
        }
        System.out.println("Adjacency List:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println((char) (i + 'a') + " -> " + adj.get(i));
        }
        
    }
    
    public static void topsort(List<List<Integer>> adj, boolean[] vis , Stack<Integer> s, int cur){
        vis[cur] = true;
        
        for(int neigh : adj.get(cur)){
            if(!vis[neigh]){
                topsort(adj, vis, s, neigh);
            }
        }
        s.push(cur);
        
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"baa","abcd","abca","cab","cad"};
        int k = 4;

        System.out.println(findOrder(dict, k));
    }
}
