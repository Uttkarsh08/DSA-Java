import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Helper {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    public static List<List<Integer>> helper(TreeNode root, List<List<Integer>> ans, List<Integer> cur, Queue<TreeNode> q, boolean rtl){
        if(root == null) return ans;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curNode = q.remove();
            if(curNode == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
                ans.add(new ArrayList<>(cur));
                cur.clear();
                rtl = !rtl;
            }else{
                cur.add(curNode.val);
                if(rtl){
                    if(curNode.right != null){
                        q.add(curNode.right);
                    }
                    if(curNode.left != null){
                        q.add(curNode.left);
                    }
                }else{
                    if(curNode.left != null){
                        q.add(curNode.left);
                    }
                    if(curNode.right != null){
                        q.add(curNode.right);
                    }
                }
            }
        }
        if (!cur.isEmpty()) {
            ans.add(new ArrayList<>(cur));  // Add the last level to the result
        }
        return ans;
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean rtl = true;
        return helper(root, ans, cur, q, rtl);
    }
       
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));

    }
}

