package Backtracking;

public class Letter_Combination {
    final static char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
                                {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},
                                {'w','x','y','z'}};

    public static void letterCombination(String D){
        if(D.length()==0){
            System.out.println("");
            return;
        }
        bfs(0,D.length(), new StringBuilder(), D);
    }
    public static void bfs(int pos, int len, StringBuilder S, String D){
        
        //base case
        if(pos == len){
            System.out.println(S.toString());
            return;
        }
        //kaam

        char letters[] = map[Character.getNumericValue(D.charAt(pos))];
        for(int i=0; i<letters.length; i++){
            bfs(pos+1, len, new StringBuilder(S).append(letters[i]), D);
        }
    }

    public static void main(String[] args) {
        letterCombination("23");
    }
    
}
