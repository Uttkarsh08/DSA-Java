package Arrays.Array;

public class Largest {
    public static int LargestNumber(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args){
        int arr[] = {1, 5, 9, 20, -20, 3};
        System.err.println(LargestNumber(arr));
    }
}
