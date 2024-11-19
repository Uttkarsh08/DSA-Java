import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
    public static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans=-1;
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        long curSum=0;
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            if(cur==null){
                pq.offer(curSum);
                curSum=0;
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                curSum +=root.val;
                System.out.println(curSum);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        // while(!pq.isEmpty()){
        //     System.out.println(pq.poll());
        // }
        
        return ans;
    }
       
    public static void main(String[] args) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        StringBuilder sb = new StringBuilder();
        sb.length();
        sb.
        System.out.println(kthLargestLevelSum(root, 2));

    }
}

