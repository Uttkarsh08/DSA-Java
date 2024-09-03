package Greedy;

import java.util.*;

// we want more items with hight value/weight ratio 

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50;
        int ans = 0;
        double[][] ratio = new double[val.length][2];
        for(int i=0; i<val.length; i++){
            ratio[i][0] = i; //index
            ratio[i][1] = (double)val[i]/weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sorting with resprct to ratio

        
        for(int i=ratio.length-1; i>=0; i--){
            int index = (int)ratio[i][0];
            if(W >= weight[index]){  // full item added
                ans+= val[index];
                W -= weight[index];
            }else{  // fraction
                ans += W * ratio[i][1];   //(remaining capacity in knapsack) * ratio of the item which is needed to be added
                W=0;
                break;
            }
        }
        System.out.println("Maximum Value = "+ ans);
    }
}
