package Arrays.Searching;

public class Binary {
    public static int Binarysearch(int arr[], int key) {
        if (arr.length == 0)
            return -1;
        if (arr.length == 1)
            return 0;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) { // found
                return mid;
            } else if (arr[mid] > key) { // left
                end = mid - 1;
            } else { // right
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int lower(int arr[], int key) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] >= key) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return arr[s];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7, 10, 13, 19, 21 };
        int key = 14;
        System.out.println(Binarysearch(arr, key));
        System.out.println(lower(arr, key));
    }
}
