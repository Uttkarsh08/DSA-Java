package BST;

public class ValidateBST2 {
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

    public static Node Insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = Insert(root.left, val);
        }else{
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null) return true;
        if(min != null && root.data <=min.data) return false;
        if(max != null && root.data >=max.data) return false;

        return isValidBST(root.left, min, root) && isValidBST(root, root, max);
    }

    public static void main(String[] args) {
        int vals[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int val: vals){
            root = Insert(root, val);
        }
        System.out.println(isValidBST(root, null, null));
    }
}
