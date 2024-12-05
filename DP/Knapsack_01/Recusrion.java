package DP.Knapsack_01;

public class Recusrion {

    public static int knapsack(int val[], int wt[], int W, int i){
        if(W==0 || i == val.length){
            return 0;
        }

        // 2 choices
        if(wt[i] <= W){
            //include
            int inc = val[i]+ knapsack(val, wt, W-wt[i], i+1);

            //exclude
            int exc = knapsack(val, wt, W, i+1);

            return Math.max(inc, exc);
        }else{
            return knapsack(val, wt, W, i+1);
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapsack(val, wt, W, 0));
    }
}  