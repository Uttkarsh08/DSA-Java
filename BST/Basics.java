package BST;

public class Basics {
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
        if(root.data > val){ //left subtree
            root.left = Insert(root.left, val);
        }else{
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static boolean Search(Node root, int key){
        if(root == null) return false;
        if(root.data == key){
            return true;
        }else if(root.data > key){
            return Search(root.left, key);
        }else{
            return Search(root.right, key);
        }
    }

    public static void Inorder(Node root){
        if(root == null) return;
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }
    public static void main(String[] args) {
        int vals[] = {5,1,3,4,2,7};
        Node root = null;
        for(int val: vals){
            root = Insert(root, val);
        }
        // Inorder(root);

        System.out.println(Search(root, 6));

    }
}
