package Stack;

import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean checkRedundancy(String a) {
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<a.length(); i++){
            char ch = a.charAt(i);
            
            if(ch == ')'){
                int count = 0;

                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                
                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }
                
            }
            else{
                s.push(ch);
            }
            
        }
        return false;
        
    }
    public static void main(String[] args) {
        System.out.println(checkRedundancy("(((a+b)+(c+d)))"));
    }
}
