package Graphs;

public class DisJointSet {
    static int n = 7;
    static int par[] = new int[n];
    static int[] rank = new int[n];

    static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }
    
    static int find(int x){
        if(x==par[x]) return x;
        return par[x] = find(par[x]);  // path compression(we use par[x] = find(par[x]), beacuse if we again call find(x) for the same x, we donot have to perform whole recursion again    )
    }

    static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }
    public static void main(String[] args) {
        init();
        System.out.println(find(1));
        union(1, 2);
        System.out.println(find(2));
    }   
}
