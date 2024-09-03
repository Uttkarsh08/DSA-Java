package Backtracking;

public class N_Queens_OneSoln {
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

    public static boolean Queens(String board[][], int row){
        //base case
        if(row == board.length){
            // printBoard(board);
            return true;
        }

        //n queens in n rows
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = "Q";
                if(Queens(board, row+1)){
                    return true;
                }
                   // recursive call
                board[row][j] = "X";    
            }
            
        }
        return false;
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

    public static void main(String[] args) {
        int n = 4;
        String board[][] = new String[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = "X";
            }
        }

        if(Queens(board, 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }else System.out.println("Solution is not possible");
    

    }
}
