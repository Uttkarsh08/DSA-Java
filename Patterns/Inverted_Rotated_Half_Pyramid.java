package Patterns;

public class Inverted_Rotated_Half_Pyramid{

    public static void Patterns(int rows){
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=rows-i; j++){
                System.out.print(" ");
            }
            for(int z=1; z<=i; z++){
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        Patterns(4);
    }
    
}
