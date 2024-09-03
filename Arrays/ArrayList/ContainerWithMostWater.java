package Arrays.ArrayList;
import java.util.*;
public class ContainerWithMostWater {

    public static int MaxWaterAns(ArrayList<Integer> list){
        int left =0;
        int right = list.size()-1;
        int ans = 0;

        while(left < right){
            int minHeight = Math.min(list.get(left), list.get(right));
            int length = right - left;
            int area = minHeight*length;
            ans = Math.max(ans, area);

            if(list.get(left) < list.get(right)){
                left++;
            }else{
                right--;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);

        System.out.println(MaxWaterAns(list));
    }
    

    
}
