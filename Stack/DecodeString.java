package Stack;

import java.util.Stack;

public class DecodeString {
    public static String solution(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ']'){
                StringBuilder temp = new StringBuilder();
                while(s.peek() != '['){
                    temp.insert(0, s.pop()); // Insert characters at the beginning to reverse the order
                }
                s.pop(); // Remove the '[' from the stack
                StringBuilder num = new StringBuilder();
                while(!s.isEmpty() && Character.isDigit(s.peek())){
                    num.insert(0, s.pop()); // Accumulate the digits in correct order
                }
                int mul = Integer.parseInt(num.toString());

                // Repeat the string 'mul' times
                String repeatedString = temp.toString().repeat(mul);

                // Push the repeated string back to the stack
                for(char ch2 : repeatedString.toCharArray()){
                    s.push(ch2);
                }

            }else{
                s.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c: s){
            result.append(c);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        System.out.println(solution(str));
    }
}
