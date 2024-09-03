package Arrays.Array;

public class MaxSubarraySum2 {
    public static void kadaneSum(int arr[]) {
        int cursum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            cursum += arr[i];
            maxSum = Math.max(cursum, maxSum); // maxsum is calculater before checking for curSum < 0, to pass the testcase where all elements of array are -ve
            if(cursum < 0){
                cursum = 0;
            }
            
 
        }
        System.out.println("Max Sum : "+ maxSum);
    }
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        // int arr2[] = {2,-1,3,-5,4};
        kadaneSum(arr);
    }
}
