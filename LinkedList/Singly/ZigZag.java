package LinkedList.Singly;

public class ZigZag {
    /**
 * Definition for singly-linked list.
 * public class Node {
 *     int val;
 *     Node next;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node next) { this.val = val; this.next = next; }
 * }
 */
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;

    public int getLength(){
        int len = 0;
        Node cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public void addFirst(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void PrintLL(){
        if(head == null){
            System.out.println("LL is Empty");
            return;
        }
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void zigZag(Node head) {
        if(head == null || head.next == null){
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //find mid
        Node mid = slow;

        //reverse second half
        Node prev = null;
        Node cur = mid.next;
        mid.next = null;
        Node nxt;
        while(cur != null){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        Node right = prev;
        Node left = head;

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(left != null && right != null){
            temp.next = left;
            temp= temp.next;
            left = left.next;
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        while(left != null){
            temp.next = left;
            temp= temp.next;
            left = left.next;
        }
        while(right != null){
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }

    }
    public static void main(String[] args) {
        ZigZag ll = new ZigZag();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        PrintLL();
        zigZag(head);
        PrintLL();
    }
}
