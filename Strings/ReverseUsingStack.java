import java.util.*;;

public class ReverseUsingStack {
    public static String Reverse(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            s.push(cur);
        }

        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            char cur = s.pop();
            sb.append(cur);
        }
        return sb.toString();
        
    }
    public static void main(String[] args) {
        System.out.println(Reverse("abc"));
    }
}
