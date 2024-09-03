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
            System.out.println(arr[i]+ " ");
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        Bubble(arr);
    }
}
