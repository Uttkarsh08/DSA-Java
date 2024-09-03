package Backtracking;

public class N_Queens_All {

    public static boolean isSafe(String board[][], int row, int col){
        //conttions for queen to be safe

        //upper straight
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == "Q") return false;
        }

        //upper diagonal left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == "Q") return false;
        }

        //upper diagonal right
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == "Q") return false;
        }
        return true;
    }

    public static void Queens(String board[][], int row){
        //base case
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }

        //n queens in n rows
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = "Q";
                Queens(board, row+1);   // recursive call
                board[row][j] = "X";    // backtracking step, when we go back we need all the spaces empty. so that only one queen willbe in row after updating
            }
            
        }
    }

    public static void printBoard(String board[][]){
        System.out.println("----------------------------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        String board[][] = new String[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = "X";
            }
        }

        Queens(board, 0);
        System.out.println("------------------------------------");
        System.out.println("Total Number of Ways: "+ count);
    }
}
