package BST;

public class DeleteNode {
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
    public static Node Delete(Node root, int val){
        if(root.data > val){ // left subtree
            root.left = Delete(root.left, val);
        }
        else if(root.data < val){ // right subtree
            root.right = Delete(root.right, val);
        }else{ // root.data == val
            //case 1-> no child
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2-> one child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //case 3-> 2 childs
            Node InorderSucessor = FindInorderSucessor(root.right);
            root.data = InorderSucessor.data;
            root.right = Delete(root.right, InorderSucessor.data);
        }
        return root;
    }

    public static Node FindInorderSucessor(Node root){  //Inorder sucessor -> a;ways leftmost node in right subtree.
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
    public static void Inorder(Node root){
        if(root == null) return;
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }
    public static void main(String[] args) {
        int vals[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int val: vals){
            root = Insert(root, val);
        }

        Inorder(root);
        System.out.println();
        root = Delete(root, 5);
        Inorder(root);

    }
}
