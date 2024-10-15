package BST;

import java.util.ArrayList;
import java.util.List;


public class ValidateBST {
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
   public static List<Integer> Inorder(Node root, List<Integer> list){
        if(root == null) return list;
        Inorder(root.left, list);
        list.add(root.data);
        Inorder(root.right, list);
        return list;
    }
    public static boolean isValidBST(Node root) {
        List<Integer> list = new ArrayList<>();
        Inorder(root, list);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
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

    public static void main(String[] args) {
        int vals[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int val: vals){
            root = Insert(root, val);
        }
        System.out.println(isValidBST(root));
    }
}
