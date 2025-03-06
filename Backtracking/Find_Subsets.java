package Backtracking;

import java.util.ArrayList;

public class Find_Subsets {

    public static void Subsets(String str, String ans, int i){
        //Base Case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else System.out.println(ans);
            return;
        }

        //kaam
        //YES Choice        
        Subsets(str, ans+str.charAt(i), i+1);

        //NO Choice
        Subsets(str, ans, i+1);
    }


    public static ArrayList<String> Subsets2(String str, String ans, int i){
        if(i==str.length()){
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add(ans);
            return baseList;
        }
      
        ArrayList<String> take = Subsets2(str, ans+str.charAt(i), i+1);
        ArrayList<String> left = Subsets2(str, ans, i+1);

        take.addAll(left);
        return take;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Subsets2(str, "", 0));
    }
}
