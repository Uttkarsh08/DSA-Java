package CP;

import java.util.*;

public class CF2039B {
    public static String Substr(String s){
        HashSet<Character> hash = new HashSet<>();
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            String sub = s.substring(i,i+2);
            if(sub.charAt(0) == sub.charAt(1)) return sub;
        }
        for(int i=0; i<n-2; i++){
            String sub = s.substring(i, i+3);
            hash.add(arr[i]);
            hash.add(arr[i+1]);
            hash.add(arr[i+2]);
            if(hash.size() == 3) return sub;
        }
        return "-1";
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
           String s = sc.nextLine();

            System.out.println(Substr(s));
        }
        sc.close();
    }
}
