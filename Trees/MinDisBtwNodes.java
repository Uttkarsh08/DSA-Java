package Trees;

public class MinDisBtwNodes {
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
    public static Node lca(Node root, int n1, int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }
        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }
        return root;
    }
    public static int distance(Node root, int n){
        //root -> lca, n -> node
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftd = distance(root.left, n);
        int rightd = distance(root.right, n);
        if(rightd == -1 && leftd == -1){
            return -1;
        }
        if(rightd == -1){
            return leftd+1;
        }
        return rightd+1;


    }

    public static int MinDis(Node root, int n1, int n2){

        Node node = lca(root, n1, n2);
        int d1 = distance(node, n1);
        int d2 = distance(node, n2);

        return d1+d2;


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
        System.out.println(MinDis(root, 2, 6));
    }
}
