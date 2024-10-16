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
        boolean isBst = false;
        int size = 0;
        int min  = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Info(boolean isBst, int size, int min, int max){
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isBst(Node root, int min, int max){
        if(root == null) return true;
    }

    public static Info SizeOfLargestBST(Node root){
        int size =0;

        return size;
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



    }
}
