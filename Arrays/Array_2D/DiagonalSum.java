package Arrays.Array_2D;

public class DiagonalSum {
    
    public static int Sum(int arr[][]){
        int s=0;
        // for(int i=0; i<arr.length; i++){
        //     for(int j =0; j<arr[0].length; j++){  // this approach have time Complexity O(n^2)
                    //Primary Diagonal
        //         if(i==j){
        //             s+= arr[i][j];
        //         }
                    //Secondary Diagonal
        //         else if(i+j == arr.length-1){
        //             s+=arr[i][j];
        //         }
        //     }
        // }
        for(int i=0; i<arr.length; i++){  // Complexity of O(n)
            //primary
            s+=arr[i][i];
            //Secondary
            if(i != arr[i][arr.length-1-i]){  // if condition take care of overlap condition
                s+=arr[i][arr.length-1-i];
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int arr[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        System.out.println(Sum(arr));
    }
}
