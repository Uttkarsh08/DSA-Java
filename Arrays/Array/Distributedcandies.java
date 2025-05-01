package Arrays.Array;

import java.util.HashSet;

//THis is the Demo PRogram to distribute the candies to the sister
public class Distributedcandies {
    public static int distributeCandies(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int x = arr.length/2;
        return Math.min(x,set.size());
        // return set.size();
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3};
        System.out.println(distributeCandies(arr));
    }
}
