package Arrays.Array;
public class SubArray {
    public static void printSubArray(int arr[]){
        int t=0;
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        int minsum = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){  //Start of subarray
            for(int j=i; j<arr.length; j++){  //End of subarray
                for(int k=i; k<=j; k++){
                    
                    System.out.print(arr[k]+" ");
                    sum+=arr[k];
                    
                }
                System.out.println("-> Sum: "+sum);
                if(maxsum < sum){
                    maxsum = sum;
                }
                if(minsum > sum){
                    minsum = sum;
                }
                sum =0;
                t++;
                System.out.println();
            }
        }
        System.out.println("Total: "+t);
        System.out.println("\nMaximum SubArraySum : "+ maxsum);
        System.out.println("\nMinimum SubArraySum : "+ minsum+"\n");
    }  
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        printSubArray(arr);
    }
}
