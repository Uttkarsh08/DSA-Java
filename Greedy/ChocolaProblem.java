package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        // int n = 4, m = 6;
        Integer costver[] = {2,1,3,1,4};  // size = m-1
        Integer costHor[] = {4,1,2};  //size = n-1

        Arrays.sort(costver, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());


        int h =0, v=0;
        int hp=1, vp=1;
        int cost = 0;

        while(h< costHor.length && v < costver.length){
            if(costHor[h] >= costver[v]){ // Horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;

            }else{  //Vertical cut
                cost += (costver[v] * hp);
                vp++;
                v++;
            }
        }
        while(h< costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while(v < costver.length){
            cost += (costver[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum cost = "+ cost);
    }
}
