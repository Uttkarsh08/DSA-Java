import java.util.Arrays;

public class Anagrams {
    public static boolean Anagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        char[] ar1 = str1.toCharArray();
        char[] ar2 = str2.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        return Arrays.equals(ar1, ar2);
    }
    public static void main(String[] args) {
        String str1 = "carea";
        String str2 = "racea";
        System.out.println(Anagram(str1, str2));
    }
}
