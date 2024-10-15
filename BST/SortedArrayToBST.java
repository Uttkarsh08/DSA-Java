package BST;

public class SortedArrayToBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node ArraytoBST(int arr[], int start, int end){
        if(start == end) return null;
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);

        root.left = ArraytoBST(arr, start, mid-1);
        root.right = ArraytoBST(arr, mid+1, end);

        return root;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        
        System.out.println(ArraytoBST(arr, 0, arr.length-1).data);
    }
}
