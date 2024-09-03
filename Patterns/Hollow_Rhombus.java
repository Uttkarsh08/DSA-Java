package Patterns;

public class Hollow_Rhombus {

    public static void pattern1(int n ){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=(2*n)-1; j++){
                if((i==1 && j>=6) || (i==n && j<6) || (i+j == 6) || (i+j) == 10  ){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void pattern2(int n){
        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //hollow-rectangle
            for(int z=1; z<=n; z++){
                if( i==1 || i == n || z==1 || z==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }    
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
    }
}
