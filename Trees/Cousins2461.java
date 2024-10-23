package Trees;

import java.util.*;


public class Cousins2461 {
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
    
    public static TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum=0;

        //sum of each level
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur == null){
                list.add(sum);
                sum=0;
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                sum+=cur.val;
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        root.val =0;
        //updating Values;
        updateValues(root,list, 0);

        return root;
        
    }

    public static void updateValues(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;
        int curSum = leftVal + rightVal;

        if (root.left != null) {
            root.left.val = list.get(level + 1) - curSum;
        }
        if (root.right != null) {
            root.right.val = list.get(level + 1) - curSum;
        }

        if (root.left != null) updateValues(root.left, list, level + 1);
        if (root.right != null) updateValues(root.right, list, level + 1);
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(replaceValueInTree(root));
    }
}
