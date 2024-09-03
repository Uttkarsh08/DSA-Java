package Backtracking;

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

    public static void main(String[] args) {
        String str = "abc";
        Subsets(str, "", 0);
    }
}
