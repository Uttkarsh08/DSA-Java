package Arrays.Array_2D;

public class SpiralMatrix {
    public static void Spiral(int arr[][]){
        int startRow = 0;
        int endRow = arr.length-1;
        int startCol = 0;
        int endCol = arr[0].length-1;
        while(startRow <= endRow && startCol <= endCol){
            //Top
            for(int j = startCol; j<= endCol; j++){
                System.out.print(arr[startRow][j]+ " ");
            }
            //Right
            for(int i=startRow+1; i<= endRow; i++){
                System.out.print(arr[i][endCol]+ " "); 
            }
            //Bottom
            for(int j=endCol-1; j>=startCol; j--){
                if(startRow == endRow){  // this is used, becaiuse in some cases only one cell is left in the end, which will be printed in top condition , but it will be printed again in bootom condition if we will not write this condition.
                    break;
                }
                System.out.print(arr[endRow][j]+ " ");
            }
            //Left
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol == endCol){  
                    break;
                }
                System.out.print(arr[i][startCol]+ " ");
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
    }
    public static void main(String[] args) {
        int arr[][]= {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        Spiral(arr);
    }
}
