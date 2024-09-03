package Arrays.Array;


public class Nextpermitataion {
    public static void reverse(int[] arr, int i, int j){
        while(j>i){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void permutation(int[]arr){
        int index=-1;
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(arr, 0, arr.length-1);
            return;
        }
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] > arr[index]){
                int temp = arr[i];
                arr[i]= arr[index];
                arr[index] = temp;
                break;
            }
        }

        reverse(arr, index+1, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,4};
    
        permutation(arr);
    }
}
