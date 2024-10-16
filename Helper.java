import java.util.*;

import javax.swing.tree.TreeNode;

public class Helper {
    public static boolean isSorted(char[] arr){
        boolean sorted = true;
        for(int i=0; i<arr.length; i++){
            if((int)arr[i+1]< (int)arr[i]){
                sorted = false;
            }
        }
        return sorted;
    }
    public static long minimumSteps(String s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int mid = ans.si
    }
    public static void main(String[] args) {
        
        String s = "01011100101";
        System.out.println(minimumSteps(s));
    }
}

