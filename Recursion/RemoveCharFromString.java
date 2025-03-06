package Recursion;

public class RemoveCharFromString {

    public static String Sol(String s, char c, int i){

        if(i>=s.length()) return "";

        char ch = s.charAt(i);

        if(ch != c){
            return ch+Sol(s, c, i+1);
        }else{
            return Sol(s, c, i+1);  //skip
        }
        
    }
    public static String Sol2(String s, char c, int i){

        if(i>=s.length()) return "";

        String ans= Sol2(s, c, i+1);

        char ch = s.charAt(i);
        if(ch != c){
            return Character.toString(ch)+ans;
        }


        return ans;
        
    }
    public static void main(String[] args) {

        String  s= "chaacffag";
        System.out.println(Sol2(s, 'a', 0));
        
    }
}
