package Arrays.Array_2D;


public class practice {

    public static void Transpose(int[][] arr){
        int trans[][] = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j< arr[0].length; j++){
                    trans[i][j] = arr[j][i];
            }
        }
        for(int i=0; i<trans.length; i++){
            for(int j=0; j<trans[0].length; j++){
                System.out.print(trans[i][j] +" ");
            }
            System.out.println();
        }
    }
    
    public static void Sum2ndRow(int[][] arr){
        int sum=0;
        for(int j=0; j<arr[0].length; j++){
            sum+=arr[1][j];
        }
        System.out.println(sum);
    }

    public static void nUmber7(int[][] arr){
        int sum =0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 7){
                    sum ++;
                }
            }
        }
        System.out.println(sum); 
    }

    

    
    
    public static void main(String[] args) {
        int[][] arr = { {4,7,8},
                        {8,8,7} };
        int[][] nums = { {1,4,9},
                        {11,4,3},
                        {2,2,3} };
        nUmber7(arr);
        Sum2ndRow(nums);
        Transpose(nums);
    }
}
