package Trees;

public class SymmetricTree101 {
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
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1==null || root2 == null || root1.val != root2.val) return false;

        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isSymmetric(root));
    }
}
