package Trees;

import java.util.HashSet;

public class UniValued {
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
    public static boolean isUniValued(Node root, HashSet<Integer> hash){
        if(root == null) return true;
        hash.add(root.data);
        isUniValued(root.left, hash);
        isUniValued(root.right, hash);
        if(hash.size()>1) return false;
        else return true;
        
    }

    //OR
    
    public static boolean isUniValued(Node root){
        if(root == null) return true;
        
        boolean l = isUniValued(root.left);
        boolean r = isUniValued(root.right);
        if(root.left != null && root.left.data != root.data) return false;
        if(root.right != null && root.right.data != root.data) return false;

        return l&&r;
        
    }
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);
        System.out.println(isUniValued(root, h));
        System.out.println(isUniValued(root));
    }
}