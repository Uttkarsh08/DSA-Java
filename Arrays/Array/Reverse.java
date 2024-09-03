package Arrays.Array;

public class Reverse {
    public static void doreverse(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start=+1;
            end -=1;
        }
    }
    public static void main(String[] args){
        int arr[] = {1, 3, 5, 7, 9, 11};
        doreverse(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        

    }
}
