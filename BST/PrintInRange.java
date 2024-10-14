package BST;
import java.util.*;
public class PrintInRange {
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
    

    public static List<Integer> InRange(Node root, int k1, int k2, List<Integer> ans){
        
        if(root == null){
            return ans;
        }
        if(root.data >=k1 && root.data <=k2){
            InRange(root.left, k1, k2, ans);
            ans.add(root.data);
            InRange(root.right, k1, k2, ans);
        }
        else if(k1 < root.data){
            InRange(root.left, k1, k2, ans);
        }
        else{
            InRange(root.right, k1, k2, ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        int vals[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int val: vals){
            root = Insert(root, val);
        }
        System.out.println(InRange(root, 5, 12, ans));
    }

}
