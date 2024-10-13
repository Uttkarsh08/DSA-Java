import java.util.*;

public class MinLengthAfterRemovingsubStr2696 {
    public static int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!st.isEmpty()){
                if(ch=='B' && st.peek()=='A') st.pop();
                else if(ch=='D' && st.peek()=='C') st.pop();
                else st.add(ch);
            }
            
            else st.add(ch);
            
        }
        return st.size();
    }
    public static void main(String[] args) {
        System.out.println(minLength(""));
    }
}
