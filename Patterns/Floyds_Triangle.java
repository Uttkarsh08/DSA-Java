package Patterns;

public class Floyds_Triangle {

    public static void pattern(int n){
        int num = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(++num+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pattern(5);
    }
}
