package LinkedList.Singly;

public class OddEven {
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

    public  Node solve(Node head){
        if (head == null) return null;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
        OddEven ll = new OddEven();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        PrintLL();
        ll.solve(head);
        PrintLL();
    }
    
}
