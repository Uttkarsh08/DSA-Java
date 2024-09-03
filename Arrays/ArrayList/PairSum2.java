package Arrays.ArrayList;

import java.util.ArrayList;

public class PairSum2 {

    public static boolean fun(ArrayList<Integer> list, int target){
        int n = list.size();
        int breaking_point = -1;
        for(int i=0; i<n; i++){
            if(list.get(i) > list.get(i+1)){
                breaking_point = i;
                break;
            }
        }

        int l =breaking_point+1;  // smallest
        int r= breaking_point;  // largest
        while(l!=r){
            if(list.get(l) + list.get(r) == target) return true;

            else if(list.get(l) + list.get(r) > target){
                r=(n+r-1)%n;
            }

            else l = (l+1)%n;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(fun(list,15));
    }
}