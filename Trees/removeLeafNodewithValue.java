package Trees;

public class removeLeafNodewithValue {
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
    public static Node removeLeafNodes(Node root, int k){
        if(root == null){
            return null;
        }
        
        Node l = removeLeafNodes(root.left, k);
        Node r = removeLeafNodes(root.right, k);

        if(l==null){
            root.left = null;
        }
        if(r== null){
            root.right = null;
        }
        if(root.left == null && root.right == null && root.data == k){
            return null;
        }
        return root;
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
        removeLeafNodes(root, 5);
    }
}
