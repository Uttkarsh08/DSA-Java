import java.util.Stack;

public class Helper {
    public static boolean canChange(String start, String target) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean l= false;
        int x=0;
        for(int i=start.length()-1; i>=0; i--){
            char ch = start.charAt(i);
            if(s.isEmpty()){
                s.push(ch);
                continue;
            }
            if(ch == 'R' && l) return false;
            if(ch=='R'){
                if(s.peek() == '_'){
                    while(!s.isEmpty() && s.peek() == '_'){
                    x++;
                    s.pop();
                    }
                    s.push(ch);
                    while(x>0){
                        s.push('_');
                        x--;
                    }
                }else{
                    s.push(ch);
                }
                
            }else if(ch=='_'){
                if(s.peek() == 'L'){
                    while(!s.isEmpty() && s.peek() == 'L'){
                    x++;
                    s.pop();
                    }
                    s.push(ch);
                    while(x>0){
                        s.push('L');
                        x--;
                    }
                }else{
                    s.push(ch);
                }
                
            }else{
                l = true;
                s.push(ch);
            }

        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return target.equals(sb.toString());
    }
    public static void main(String[] args) {
        
}