package Arrays.Sorting;

public class SelectionSort {
    public static void Selection(int[] arr){
        int n = arr.length;
        for(int i=0; i<=n-2; i++){
            int minPos = i;
            for(int j=i+1; j<n; j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void SelectionRecursion(int[] arr, int i, int j, int idx){
        if(j >= arr.length-1) return;
        if(i> arr.length-j-1){
            SelectionRecursion(arr, i, j+1, idx);
            return;
        }
        if(arr[idx] > arr[i]){
           idx = i;
        }
        SelectionRecursion(arr, i+1, j, idx);


    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        Selection(arr);
    }
}
