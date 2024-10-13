package Trees;

public class PathSum112 {
    static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
        }
    }
    public static boolean helper(TreeNode root, int targetsum, int cursum){
        if(root == null) return false;
        cursum+=root.val;
        if(root.left == null && root.right == null){
            return cursum == targetsum;
        }
        boolean l = helper(root.left, targetsum, cursum);
        boolean r = helper(root.right, targetsum, cursum);

        return l||r;
    }

    public static boolean hasPathSum(TreeNode root, int targetsum){
        return helper(root, targetsum, 0);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        // TreeNode root = new TreeNode(1);

        System.out.println(hasPathSum(root, 26));

    }
}
