package Arrays.Array;
//USING PREFIX ARRAY
public class MaxSubArraySum {
    public static void findMaxArray(int arr[]){
        int ans=0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int prearr[] = new int[arr.length];
        for(int i=0; i<prearr.length; i++){
            if(i==0) prearr[i] = arr[i];
            else prearr[i] = prearr[i-1]+arr[i];
        }
        for(int i=0; i<prearr.length; i++){
            for(int j=i; j<prearr.length; j++){
                if(i==0) ans = prearr[j];
                else ans = prearr[j] - prearr[i-1];

                if(maxSum < ans){
                    maxSum = ans;
                }
                if(minSum > ans){
                    minSum = ans;
                }
            }
        }
        
        System.out.println("Max sum : "+ maxSum);
        System.out.println("Min Sum : "+ minSum);
    }
    public static void main(String[] args){
        int arr[] = {1,-2,6,-1,3};
        findMaxArray(arr);
    }
}
