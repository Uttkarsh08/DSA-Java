package Patterns;

public class Butterfly {

    public static void pattern(int n){

    //!st Half
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int z=1;z<=(2*(n-i)); z++){
                System.out.print(" ");
            }
            for(int w=1; w<=i; w++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        //2nd Half
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int z=1;z<=(2*(n-i)); z++){
                System.out.print(" ");
            }
            for(int w=1; w<=i; w++){
                System.out.print("*");
            }
            System.out.println();
        }

        

    }
    public static void main(String[] args) {
        pattern(3);
    }
}
