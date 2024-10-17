package BST;

public class SizeOflargestBST {
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
    static class Info{
        boolean isBst;
        int size;
        int min;
        int max;

        Info(boolean isBst, int size, int min, int max){
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
static int maxBST =0;
    public static Info SizeOfLargestBST(Node root){
        if(root == null) return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info left = SizeOfLargestBST(root.left);
        Info right = SizeOfLargestBST(root.right);

        int size = left.size+right.size+1;
        int min = Math.min(Math.min(left.min, right.min), root.data);
        int max = Math.max(Math.max(left.max, right.max), root.data);

        if(root.data <= left.max || root.data >= right.min){
            return new Info(false, size, min, max);
        }

        if(left.isBst && right.isBst){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static int LargestBST(Node root){
        Info ans = SizeOfLargestBST(root);
        return maxBST;
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);

        System.out.println(LargestBST(root));

    }
}
