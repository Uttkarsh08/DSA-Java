package Trees;

public class diameter2 {
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
        int diameter;
        int height;
        public Info(int d, int h){
            this.diameter = d;
            this.height = h;
        }
    }
    public static Info diameter(Node root){   //O(n^2)
            if(root == null){
                return new Info(0,0);
            }

            Info leftInfo = diameter(root.left);
            Info righInfo = diameter(root.right);

            int selftDiam = Math.max(Math.max(leftInfo.diameter, righInfo.diameter), leftInfo.height+righInfo.height+1);
            int selfheight = Math.max(leftInfo.height, righInfo.height)+1;

            return new Info(selftDiam, selfheight);
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
        System.out.println("Diameter = "+diameter(root).diameter);

    }
}
