package Backtracking;

public class Grid_Ways {

    public static int gridWays(int i, int j, int n, int m){ // (i,j)-> current positions ;  (n,m) ->rows and columns
            //base case
            if(i==n-1 || j==m-1) return 1;  //for last cell
            if(i==n || j==m) return 0;      //boundry cross condition
//                       Down
//                       |
            return gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m);
//                                                     |
//                                                     right


    }
    public static int factorial(int n){
        if(n==1 || n==2) return n;
        return n*factorial(n-1);
    }

    public static int gridWays2(int n, int m){
            return factorial(n-1+m-1)/(factorial(n-1)*factorial(m-1));
    }

    public static void main(String[] args) {
        int n=3, m=5;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(gridWays2(n, m));
    }
}
