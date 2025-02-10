package Recursion;

import java.util.ArrayList;
import java.util.List;

public class AlloccurenceofKey {

    public static void count(int arr[], int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                System.out.print(i+" ");
            }
        }

    }
    public static void count2(int arr[], int key, int i){
        if(i==arr.length ){
            return;
        }
        if(arr[i] == key){
            System.out.print(i+" ");
        }
        count2(arr, key, i+1);
    }

    public static List<Integer> count3(int arr[], int key, int i){
        if(i==arr.length){
            return new ArrayList<>();
        }

        List<Integer> ans = count3(arr, key, i+1);

        if(arr[i] == key){
            ans.add(0, i);

        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        count(arr, 2);
        System.out.println();
        count2(arr, 2, 0);
        System.out.println();
        System.out.println(count3(arr, 2, 0));
    }
}
