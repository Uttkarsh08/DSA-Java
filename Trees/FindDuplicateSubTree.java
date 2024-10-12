package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubTree {
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
    
    public static String helper(Node root, HashMap<String, Integer> map, List<Node> ans){
        if(root == null) return "@";
        String l = helper(root.left, map, ans);
        String r = helper(root.right, map, ans);
        String s = root.data+","+l+","+r;

        map.put(s, map.getOrDefault(s, 0)+1);

        if(map.get(s) > 1){
            ans.add(root);
        }
        return s;
        
    }
    public static List<Node> FindDuplicate(Node root){
        List<Node> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if(root == null){
            return ans;
        }
        
        helper(root, map, ans);
        return ans;


    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                /   /   \
               4   2     4
                  /
                4
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.left.left = new Node(2);
        root.right.right = new Node(4);

        FindDuplicate(root);
    }
}
