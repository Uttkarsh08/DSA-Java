package Arrays.Sorting;

public class MergeSort {

    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }

    public static void mergeSort(int arr[], int start, int end){
        //Base Case
        if(start>=end) return;
        //kaam
        int mid = start +(end-start)/2; 
        mergeSort(arr, start, mid);  //Left Part
        mergeSort(arr, mid+1, end);  //Right Part
        //merge --->
        merge(arr, start, mid, end);

    }
    public static void merge(int arr[], int start, int mid, int end){
        int temp[] = new int[end-start+1];
        int i= start; //iterator for left part
        int j = mid+1; //iterator for right part
        int k = 0; //iterator for temp array

        while(i<=mid && j<=end){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        //Right part khatam ho gya oor left part me kuch bacha hai
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        //Left part khatam ho gya oor Right part me kuch bacha hai
        while(j<=end){
            temp[k++] = arr[j++];
        }
        //copy temp array to original array
        for(k=0, i=start; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        PrintArr(arr);
        
    }
}
