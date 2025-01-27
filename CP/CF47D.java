package CP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF47D {
    static List<String> ans = new ArrayList<>();

    //generate all stfings
    static void Sol(StringBuilder s, int n, int idx){
        if(idx >= s.length()){
            if(n==0){
                ans.add(s.toString());
            }
            return;
        }
        Sol(s, n, idx+1);
        if(n>0){
            char ch = s.charAt(idx);
            s.setCharAt(idx, (char)(ch^1));
            Sol(s, n-1, idx+1);
            s.setCharAt(idx, ch);
        }
    }

    static boolean check(String w, String g, int m){
        int cnt =0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) != g.charAt(i)) cnt++;
        }
        return cnt == m;
    }

    static int Sool(String guess){
        for(int i=0; i<ans.size(); i++){
            String pw = ans.get(i);
            boolean f = false;
            for(int j=0; j<guess.length(); j++){

            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        while(m-->0){
            String sb = sc.next();
            StringBuilder s = new StringBuilder(sb);

            int k = sc.nextInt();

            Sol(s, n, 0);
            System.out.println(ans);
        }
    }
}
