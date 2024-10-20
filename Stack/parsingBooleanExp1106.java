package Stack;

import java.util.*;

public class parsingBooleanExp1106 {
    public static boolean parseBoolExpr(String str) {
        HashSet<Character> hash = new HashSet<>();  // two boolean containstre and containsfalse can also be used
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == ')'){
                while(s.peek() != '('){
                    hash.add(s.pop());
                }
                s.pop();
                char op = s.pop();
                if(op == '|' && hash.contains('t')){
                    s.push('t');
                }else if(op == '&' && hash.size() == 1 && hash.contains('t')){
                    s.push('t');
                }else if(op == '!' && hash.contains('f')){
                    s.push('t');
                }else{
                    s.push('f');
                }
                hash.clear();
            }else if(ch == ','){
                continue;
            }else{
                s.push(ch);
            }
        }
        return (s.pop()=='f')?false: true;
    }

    public static void main(String[] args) {
        String str = "!(&(f,t))";
        System.out.println(parseBoolExpr(str));
    }
}
