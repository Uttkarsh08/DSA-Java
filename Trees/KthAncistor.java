package Trees;

public class KthAncistor {
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
    static int ans =0;
    public static int kthAncistor(Node root, int n, int k){
        
        if(root == null) return -1;
        if(root.data == n) return 0;
        int ld = kthAncistor(root.left, n, k);
        int rd = kthAncistor(root.right, n, k);

        if(ld == -1 && rd == -1) return-1;
        int max = Math.max(ld, rd);
        if(max+1 == k){
            ans = root.data;
        }
        return max+1;
        
    }
    public static int kthAncistormain(Node root, int n, int k){
        ans = 0;
        kthAncistor(root, n, k);
        return ans;
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(kthAncistormain(root, 6, 2));
    }
}
