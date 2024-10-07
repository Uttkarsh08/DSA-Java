package Stack;

public class ReverseSubStr {
        static int i=0;
        public static String reverseParentheses(String s) {
            
            char[] ch = s.toCharArray();
            return helper(ch);
            
        }
    
        public static String helper(char[] ch){
            StringBuilder sb = new StringBuilder();
            while(i<ch.length){
                if(ch[i]==')'){
                    i++;
                    return sb.reverse().toString();
                }else if(ch[i]=='('){
                    i++;
                    String st = helper(ch);
                    sb.append(st);
                }else{
                    sb.append(ch[i]);
                    i++;
                }
            }
            return sb.toString();
    
        }
    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
