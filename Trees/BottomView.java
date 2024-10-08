package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomView {
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
    static class Info{
        Node node;
        int hd;
        public Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> bottomview(Node root){
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hash = new HashMap<>();
        int min = 0; int max = 0;

        q.add(new Info(root, 0));
        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur != null){
                hash.put(cur.hd, cur.node);
            }
            if(cur.node.left != null){
                q.add(new Info(cur.node.left, cur.hd-1));
                min = Math.min(min, cur.hd-1);
            }
            if(cur.node.right != null){
                q.add(new Info(cur.node.right, cur.hd+1));
                max = Math.max(max, cur.hd+1);
            }
        }
        for(int i=min; i<=max; i++){
            ans.add(hash.get(i).data);
        }
        return ans;

    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(bottomview(root));
    }
}
