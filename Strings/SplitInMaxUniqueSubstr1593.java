import java.util.HashSet;
// greedy do not work here, becaues, we dont know if at any point, remaining string can be properly splitted or not
// WE HAVE TO USE BACKTRACKING
//find each and every possibility recursively
//start with full string -> recursilely call for all possible substrings
public class SplitInMaxUniqueSubstr1593 {
    static int max;
    public static int maxUniqueSplit(String s) {
        max =0;
        HashSet<String> hash = new HashSet<>();
        backtrack(s, hash, 0);
        return max;
    }
    public static void backtrack(String s, HashSet<String> hash, int index){
        int n = s.length();
        //base case
        if(index == n){
            max = Math.max(max, hash.size());
            return;
        }
        for(int i=index; i<n; i++){
            String sub = s.substring(index, i+1);
            if(!hash.contains(sub)){ // if hash donot contains the subtrind, first add it ->
                hash.add(sub);      // then recursily call to its smaller substrings
                backtrack(s, hash, i+1);
                hash.remove(sub);   // onces reached bottom(base case), calculate max(which will be equal to size of hash)
                                    // and backtrack to previous call by removing cuurent choice of the recursion from hashset
            }
        }
    }
    public static void main(String[] args) {
        String s = "wwwzfvedwfvhsww";
        System.out.println(maxUniqueSplit(s));
    }
}
