package Recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicates {
    public static void Remove(String s){
        Set<Character> hash = new HashSet<>();
        for(char i: s.toCharArray()){
            if(hash.contains(i)) continue;
            else hash.add(i);
        }

        Iterator<Character> iterator = hash.iterator();
        while (iterator.hasNext()) {
            Character element = iterator.next();
            System.out.print(element);
        }
    }

    public static void RemoveDuplicates2(String s, int index, StringBuilder newStr, boolean map[]){
        //base case ------>
        if(index == s.length()){
            System.out.println(newStr);
            return; 
        }
        //kaam  ------->
        char currChar = s.charAt(index);
        if(map[currChar-'a'] == true){          
            RemoveDuplicates2(s, index+1, newStr, map);
        }else{
            map[currChar-'a'] = true;
            RemoveDuplicates2(s, index+1, newStr.append(currChar), map);
        }

    }
    public static void main(String[] args) {
        String s = "aaaghmmo";
        Remove(s);
        System.out.println();
        RemoveDuplicates2(s,0, new StringBuilder(""), new boolean[26]);
    }
}
