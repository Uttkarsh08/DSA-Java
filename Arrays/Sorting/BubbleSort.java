package Arrays.Sorting;

public class BubbleSort {
    public static void Bubble(int[] arr){
        int l = arr.length;
        for(int i=0; i<=l-2; i++){
            for(int j=0; j<=l-2-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0; i<l; i++){
            System.out.print(arr[i]+ " ");
        }

    }

    public static void BubbleRecursion(int[] arr, int i, int j){
            if(j >= arr.length-1) return;
            if(i> arr.length-j-2){
                BubbleRecursion(arr, 0, j+1);
                return;
            }
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            BubbleRecursion(arr, i+1, j);
            
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2};
        // Bubble(arr);
        System.out.println();
        BubbleRecursion(arr, 0, 0);
        for(int x=0; x<arr.length; x++){
            System.out.print(arr[x]+ " ");
        }
    }
}
