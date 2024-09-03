package Queue;

import java.util.*;

public class FirstNonRepeating {
    public static String firstNonRepeating(String a){
        StringBuilder ans = new StringBuilder();
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<a.length(); i++){
            char ch = a.charAt(i);
            
            q.add(ch);
            freq[ch-'a']++;
            
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                ans.append("#");
            }else{
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("aabccxb"));
    }
}
