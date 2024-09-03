package Backtracking;

public class Permutations {
    public static void perm(String str, String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        //kaam
        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            String Newstr = str.substring(0, i)+str.substring(i+1);  // removing ith character from the original string, so that next levels of recursion have no access to that character.
            perm(Newstr, ans+cur);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        perm(str, "");
    }
}
