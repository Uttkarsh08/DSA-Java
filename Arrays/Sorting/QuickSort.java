package Arrays.Sorting;

public class QuickSort {
    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }

    public static void quickSort(int arr[] , int s, int e){
        if(s>=e) return;
        //last element
        int pvt_index = partition(arr, s, e);
        quickSort(arr, s, pvt_index-1);
        quickSort(arr, pvt_index+1, e);
    
    }

    public static int partition(int arr[], int s, int e){
        int pvt = arr[e];
        int i =-1; // to make place for elements smaller than pivot
        for(int j =0; j<e; j++){
            if(arr[j] <= pvt){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pvt;
        arr[e] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        PrintArr(arr);
    }
}
