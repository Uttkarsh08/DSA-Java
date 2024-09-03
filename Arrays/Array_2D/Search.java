package Arrays.Array_2D;

public class Search {
    public static boolean StairCaseSearch(int matrix[][], int target){
        int row = 0, col = matrix[0].length-1; // special point
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return false;
        if(matrix.length == 1){
            for(int i=0; i<matrix[0].length; i++){
                if(matrix[0][i] == target){
                    return true;
                }
            }
            return false;
        }
        while(row <= matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                //left
                col--;
            }
            else{
                //bottom
                row++;
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        int arr[][] = {
            {10,20, 30}
            // {40,50,60}
        };
        int key = 20;

        System.out.println(StairCaseSearch(arr, key));
    }
}
