package Stack;

import java.util.*;
public class MinAddtoMakeParValidWithStackSame{
    public static int valid(String st){

        Stack<Character> s = new Stack<>();
        int ans = 0;
        for(int i=0; i<st.length(); i++){
            char ch = st.charAt(i);

            if(ch == '('){
                s.add(ch);
            }else{
                if(!s.isEmpty() && s.peek() == '('){
                    s.pop();
                }else{
                    s.add(ch);
                }
            }
        }
        while(!s.isEmpty()){
            s.pop();
            ans+=1;
        }
        return ans;


        // int openct=0; int closect=0;

        // for(char ch : st.toCharArray()){
        //     if(ch=='(') openct++;
        //     else{
        //         if(openct>0) openct--;
        //         else closect++;
        //     }
        // }
        // return openct+closect;


    }
    public static void main(String[] args) {
        String st= "()))((";
        System.out.println(valid(st));
    }
}
