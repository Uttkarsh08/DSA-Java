package Patterns;
public class Hollow_rectangle{
    public static void hollow_rectangle(int rows, int columns){
        for(int i =1; i<=rows; i++){ //outer loop -> Rows
            for(int j=1; j<=columns; j++){  // Inner Loop -> Columns
            if(i==1 || i==rows || j==1 || j==columns){  // Check for the boundry, cell = (i,j).
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollow_rectangle(3, 7);
    }
}