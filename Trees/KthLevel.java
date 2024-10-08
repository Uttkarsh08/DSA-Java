package Trees;

public class KthLevel {
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

    public static void kthlevel(Node root, int level, int cur){
        if(root == null){
            return;
        }
        if(cur==level){
            System.out.print(root.data+" ");
            return;
        }
        kthlevel(root.left, level, cur+1);
        kthlevel(root.right, level, cur+1);
        
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

        kthlevel(root, 3, 1);
    }
}
