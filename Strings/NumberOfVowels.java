public class NumberOfVowels {
    public static int Lower(String str){
        int cnt =0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a' ||  ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String str = "ABcaeLMoN";
        System.out.println(Lower(str));
    }
}
